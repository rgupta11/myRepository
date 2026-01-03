from prophet import Prophet
import joblib
import os
import pandas as pd
from datetime import datetime
from enum import Enum
from business_prediction.ml.training.loader_business_data import loader_business_data

class Category(Enum):
    ELECTRONICS = "ELECTRONICS"
    FASHION = "FASHION"
    HOME_KITCHEN = "HOME_KITCHEN"
    GROCERY = "GROCERY"
    SPORTS_OUTDOORS = "SPORTS_OUTDOORS"


def train_business_model(df, business_name):
    models = {}
    df = loader_business_data().load_business_data(business_name)
    if df.empty:
        print(f"No data found for business_name '{business_name}'")
        return None
    for category_id, group_df in df.groupby("category_id"):
        if len(group_df) < 90:
            continue

        model = Prophet(
            # growth ='linear' - default 
            # daily_seasonality=False, -- auto
            # interval_growth By default, this is set to 0.80. need higher confidence set it to 0.95 (95%)
            yearly_seasonality=True,
            weekly_seasonality=True
        )
        model.fit(group_df[['ds', 'y']])
        models[category_id] = model

    os.makedirs("models", exist_ok=True)
    #timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    path = f"models/prophet_{business_name}.joblib"
    joblib.dump(models, path)

    return path


if __name__ == "__main__":
    business_name = "AMAZON"
    result = train_business_model(None, business_name)
    if result:
        print(f"Models trained and saved to {result}")
    else:
        print("No models trained due to lack of data")