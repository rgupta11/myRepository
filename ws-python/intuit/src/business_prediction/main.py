"""
Main entry point for business prediction application
"""
import joblib

def predict_category_sales(business_id, category_id, horizon=30):
    models = joblib.load(f"models/prophet_{business_id}.joblib")
    model = models[category_id]

    future = model.make_future_dataframe(periods=horizon)
    forecast = model.predict(future)

    return forecast[['ds', 'yhat', 'yhat_lower', 'yhat_upper']]


def predict_category_sales_By_month(
    business_id: str,
    category_id: str,
    months: int = 6
):
    # Convert months to days (approximate)
    horizon = months * 30
    return predict_category_sales(business_id, category_id, horizon=horizon)

def monthly_forecast(forecast_df):
    forecast_df['month'] = forecast_df['ds'].dt.to_period('M')

    monthly = (
        forecast_df
        .groupby('month')
        .agg(
            predicted_revenue=('yhat', 'sum'),
            lower_bound=('yhat_lower', 'sum'),
            upper_bound=('yhat_upper', 'sum')
        )
        .reset_index()
    )

    return monthly


if __name__ == "__main__":
    business_id = "biz_123"
    category_id = "ELECTRONICS"
    forecast = predict_category_sales_By_month(business_id, category_id, 6)
    monthly_forecast_df = monthly_forecast(forecast)
    print(f"Forecast for business_id '{business_id}' and category_id '{category_id}':")
    print(monthly_forecast_df.tail())