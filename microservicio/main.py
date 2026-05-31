from fastapi import FastAPI
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
clases        = json.loads((BASE / "clases.json").read_text())

class InputData(BaseModel):
    anio:       int
    provincia:  str
    area_ha:    float
    edad_anios: float
    prec_mm:    float
    rad_solar:  float
    tipo_suelo: str
    ph_suelo:   float
    temp_c:     float
    hum_rel:    float

@app.get("/")
def root():
    return {"status": "ok", "proyecto": "Anticipalta", "r2": 0.9533}

@app.get("/clases")
def get_clases():
    return clases

@app.post("/predecir")
def predecir(data: InputData):
    prov  = le_provincia.transform([data.provincia])[0]
    suelo = le_tipo_suelo.transform([data.tipo_suelo])[0]
    X = np.array([[data.anio, prov, data.area_ha, data.edad_anios,
                   data.prec_mm, data.rad_solar, suelo,
                   data.ph_suelo, data.temp_c, data.hum_rel]])
    pred = float(model.predict(X)[0])
    return {
        "rendimiento_toneladas": round(pred, 2),
        "provincia":  data.provincia,
        "tipo_suelo": data.tipo_suelo,
        "anio": data.anio
    }