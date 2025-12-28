from prophet import Prophet
import joblib
import os
import pandas as pd
from enum import Enum
from business_prediction.ml.training.loader_business_data import loader_business_data

class Category(Enum):
    ELECTRONICS = "ELECTRONICS"
    FASHION = "FASHION"
    HOME_KITCHEN = "HOME_KITCHEN"
    GROCERY = "GROCERY"
    SPORTS_OUTDOORS = "SPORTS_OUTDOORS"


def train_business_model(df, business_id):
    models = {}
    df = loader_business_data().load_business_data(business_id)
    if df.empty:
        print(f"No data found for business_id '{business_id}'")
        return None
    for category_id, group_df in df.groupby("category_id"):
        if len(group_df) < 90:
            continue

        model = Prophet(
            yearly_seasonality=True,
            weekly_seasonality=True
        )
        model.fit(group_df[['ds', 'y']])
        models[category_id] = model

    os.makedirs("models", exist_ok=True)
    path = f"models/prophet_{business_id}.joblib"
    joblib.dump(models, path)

    return path


if __name__ == "__main__":
    business_id = "biz_123"
    result = train_business_model(None, business_id)
    if result:
        print(f"Models trained and saved to {result}")
    else:
        print("No models trained due to lack of data")