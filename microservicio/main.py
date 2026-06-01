from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
import joblib, json, numpy as np
from pathlib import Path

app = FastAPI(title="Anticipalta API")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

BASE = Path(__file__).parent / "model"
model         = joblib.load(BASE / "model_xgboost.pkl")
le_provincia  = joblib.load(BASE / "le_provincia.pkl")
le_tipo_suelo = joblib.load(BASE / "le_tipo_suelo.pkl")
le_fundo      = joblib.load(BASE / "le_fundo.pkl")
clases        = json.loads((BASE / "clases.json").read_text())

class InputData(BaseModel):
    Anio:       int
    Mes:        int
    Fundo:      str
    Lote:       str
    Provincia:  str
    Area_Ha:    float
    Edad_Anios: float
    Prec_mm:    float
    Rad_Solar:  float
    Tipo_Suelo: str
    pH_Suelo:   float
    Temp_C:     float
    Hum_Rel:    float

@app.get("/")
def root():
    return {"status": "ok", "proyecto": "Anticipalta", "modelo": clases.get("mejor_modelo"), "r2": clases.get("r2")}

@app.get("/clases")
def get_clases():
    return clases

@app.post("/predecir")
def predecir(data: InputData):
    try:
        prov  = le_provincia.transform([data.Provincia])[0]
        suelo = le_tipo_suelo.transform([data.Tipo_Suelo])[0]
        fundo = le_fundo.transform([data.Fundo])[0]

        # Orden exacto de features del pipeline de entrenamiento
        X = np.array([[
            data.Anio,
            data.Mes,
            prov,
            fundo,
            data.Area_Ha,
            data.Edad_Anios,
            data.Prec_mm,
            data.Rad_Solar,
            suelo,
            data.pH_Suelo,
            data.Temp_C,
            data.Hum_Rel
        ]])

        pred = float(model.predict(X)[0])
        return {
            "rendimiento_toneladas": round(pred, 2),
            "provincia":  data.Provincia,
            "tipo_suelo": data.Tipo_Suelo,
            "fundo":      data.Fundo,
            "anio":       data.Anio,
            "mes":        data.Mes
        }
    except ValueError as e:
        raise HTTPException(status_code=400, detail=f"Valor no reconocido: {str(e)}")