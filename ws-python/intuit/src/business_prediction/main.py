"""
Main entry point for business prediction application
"""
import warnings
warnings.filterwarnings("ignore", category=RuntimeWarning)
from calendar import month
import joblib
import pandas as pd
import os
from business_prediction.ml.training.model_training import train_business_model
from typing import List, Dict, Optional
from datetime import datetime, timedelta

def predict_category_sales(business_id, category_id, horizon=30):
    model_path = os.path.join(os.path.dirname(__file__), '..', '..', 'models', f'prophet_{business_id}.joblib')
    models = joblib.load(model_path)
    model = models[category_id]

    future = model.make_future_dataframe(periods=horizon)
    forecast = model.predict(future)

    return forecast[['ds', 'yhat', 'yhat_lower', 'yhat_upper']].rename(columns={
        'ds': 'Date',
        'yhat': 'Predicted_Sales',
        'yhat_lower': 'Lower_Bound',
        'yhat_upper': 'Upper_Bound'
    })


def predict_category_sales_By_month(
    business_id: str,
    category_id: str,
    months: int = 6
):
    # Convert months to days (approximate)
    horizon = months * 30
    return predict_category_sales(business_id, category_id, horizon=horizon)

def monthly_forecast(forecast_df):
    forecast_df['Month'] = forecast_df['Date'].dt.to_period('M')

    monthly = (
        forecast_df
        .groupby('Month')
        .agg(
            Predicted_Revenue=('Predicted_Sales', 'sum'),
            Lower_Bound=('Lower_Bound', 'sum'),
            Upper_Bound=('Upper_Bound', 'sum')
        )
        .reset_index()
    )

    return monthly


def predict_future(
    business_id: str,
    category_id: str,
    start_date: str,
    end_date: str
):

    model_path = os.path.join(os.path.dirname(__file__), '..', '..', 'models', f'prophet_{business_id}.joblib')
    models = joblib.load(model_path)
    model = models[category_id]

    # Get the last date from training data
    last_train_date = model.history_dates.max()
    start_dt = pd.to_datetime(start_date)
    end_dt = pd.to_datetime(end_date)
    
    # Calculate periods needed to cover up to end_date
    periods = (end_dt - last_train_date).days
    
    if periods <= 0:
        # If end_date is before or at last_train_date, return empty
        return pd.DataFrame(columns=['ds', 'yhat', 'yhat_lower', 'yhat_upper'])
    
    future = model.make_future_dataframe(
        periods=periods,
        freq="D"
    )

    forecast = model.predict(future)
    # Filter for the requested date range
    mask = (forecast['ds'] >= start_dt) & (forecast['ds'] <= end_dt)
    return forecast.loc[mask, ['ds', 'yhat', 'yhat_lower', 'yhat_upper']].rename(columns={
        'ds': 'Date',
        'yhat': 'Predicted_Sales',
        'yhat_lower': 'Lower_Bound',
        'yhat_upper': 'Upper_Bound'
    })

def filter_date_range(
    forecast_df: pd.DataFrame,
    start_date: str,
    end_date: str
):
    mask = (
        (forecast_df['ds'] >= start_date) &
        (forecast_df['ds'] <= end_date)
    )
    return forecast_df.loc[mask]

def total_sales_for_range(forecast_df: pd.DataFrame):
    return {
        "predicted_revenue": forecast_df['Predicted_Sales'].clip(lower=0).sum(),
        "lower_bound": forecast_df['Lower_Bound'].clip(lower=0).sum(),
        "upper_bound": forecast_df['Upper_Bound'].clip(lower=0).sum()
    }


def predict_top_categories_by_sales(
    business_id: str,
    time_frame: str = 'month',
    periods: int = 1,
    top_n: int = 5
) -> pd.DataFrame:
    """
    Predict top sales by category over different time frames.

    Args:
        business_id: The business identifier (e.g., 'AMAZON')
        time_frame: 'week', 'month', or 'year'
        periods: Number of time frames to forecast
        top_n: Number of top categories to return

    Returns:
        DataFrame with top categories and their predicted sales
    """
    model_path = os.path.join(os.path.dirname(__file__), '..', '..', 'models', f'prophet_{business_id}.joblib')

    if not os.path.exists(model_path):
        raise FileNotFoundError(f"Model file not found: {model_path}")

    models = joblib.load(model_path)

    # Calculate horizon based on time_frame and periods
    if time_frame == 'week':
        horizon_days = periods * 7
        freq = 'W'
    elif time_frame == 'month':
        horizon_days = periods * 30  # Approximate
        freq = 'M'
    elif time_frame == 'year':
        horizon_days = periods * 365  # Approximate
        freq = 'Y'
    else:
        raise ValueError("time_frame must be 'week', 'month', or 'year'")

    category_forecasts = []

    # Get forecasts for all categories
    for category_id, model in models.items():
        future = model.make_future_dataframe(periods=horizon_days)
        forecast = model.predict(future)

        # Aggregate by time frame
        forecast['period'] = forecast['ds'].dt.to_period(freq)

        aggregated = (
            forecast
            .groupby('period')
            .agg({
                'yhat': 'sum',
                'yhat_lower': 'sum',
                'yhat_upper': 'sum'
            })
            .reset_index()
        )

        aggregated['category_id'] = category_id
        aggregated['time_frame'] = time_frame
        aggregated['periods'] = periods

        category_forecasts.append(aggregated)

    # Combine all category forecasts
    all_forecasts = pd.concat(category_forecasts, ignore_index=True)

    # Get the most recent period for ranking
    latest_period = all_forecasts['period'].max()

    # Filter for the latest period and rank by predicted sales
    top_categories = (
        all_forecasts[all_forecasts['period'] == latest_period]
        .sort_values('yhat', ascending=False)
        .head(top_n)
        .rename(columns={
            'yhat': 'predicted_sales',
            'yhat_lower': 'lower_bound',
            'yhat_upper': 'upper_bound',
            'period': 'forecast_period'
        })
        [['category_id', 'predicted_sales', 'lower_bound', 'upper_bound', 'forecast_period', 'time_frame', 'periods']]
    )

    return top_categories


def predict_category_sales_trend(
    business_id: str,
    category_ids: Optional[List[str]] = None,
    time_frame: str = 'month',
    periods: int = 12
) -> pd.DataFrame:
    """
    Predict sales trends for specified categories over time.

    Args:
        business_id: The business identifier
        category_ids: List of category IDs to forecast (None for all)
        time_frame: 'week', 'month', or 'year'
        periods: Number of time frames to forecast

    Returns:
        DataFrame with sales trends for each category
    """
    model_path = os.path.join(os.path.dirname(__file__), '..', '..', 'models', f'prophet_{business_id}.joblib')

    if not os.path.exists(model_path):
        raise FileNotFoundError(f"Model file not found: {model_path}")

    models = joblib.load(model_path)

    # Calculate horizon
    if time_frame == 'week':
        horizon_days = periods * 7
        freq = 'W'
    elif time_frame == 'month':
        horizon_days = periods * 30
        freq = 'M'
    elif time_frame == 'year':
        horizon_days = periods * 365
        freq = 'Y'
    else:
        raise ValueError("time_frame must be 'week', 'month', or 'year'")

    trend_forecasts = []

    # Filter categories if specified
    categories_to_forecast = category_ids if category_ids else list(models.keys())

    for category_id in categories_to_forecast:
        if category_id not in models:
            continue

        model = models[category_id]
        future = model.make_future_dataframe(periods=horizon_days)
        forecast = model.predict(future)

        # Aggregate by time frame
        forecast['period'] = forecast['ds'].dt.to_period(freq)

        aggregated = (
            forecast
            .groupby('period')
            .agg({
                'yhat': 'sum',
                'yhat_lower': 'sum',
                'yhat_upper': 'sum'
            })
            .reset_index()
        )

        aggregated['category_id'] = category_id
        trend_forecasts.append(aggregated)

    return pd.concat(trend_forecasts, ignore_index=True)


if __name__ == "__main__":
    business_id = "AMAZON"
    category_id = "ELECTRONICS"
    forecast = predict_category_sales_By_month(business_id, category_id, 6)
    monthly_forecast_df = monthly_forecast(forecast)
    print(f"Forecast for business_id '{business_id}' and category_id '{category_id}':")
    print(monthly_forecast_df.tail())

    ## Forecast for business_id 'biz_123' and category_id 'ELECTRONICS':
    #        month   predicted_revenue   lower_bound   upper_bound
    #    5  2023-06        9112.079906   -487.710719  18658.838866
    #    6  2023-07        5731.412243  -4241.616098  15513.223125
    #    7  2023-08        2127.679470  -7763.255184  11958.414838
    #    8  2023-09       -1454.581473 -11033.789128   8112.214608
    #    9  2023-10        -443.639805  -2626.447318   1772.966112


    ##
    # "Prophet expects around $9.1k in electronics sales in June,
    # but based on uncertainty, sales could be as low as ~$0
    # or as high as ~$18.6k."

    # Example of filtering date range
    print('-----------------------------------------------------------------------------------------')
    start_date = "2026-12-01"
    end_date = "2026-12-31"
    forecast = predict_future(business_id="biz_123",category_id="ELECTRONICS", start_date=start_date, end_date=end_date)

    print(f"\nFiltered forecast from {start_date} to {end_date}:")
    march_forecast = forecast  # Already filtered
    march_total = total_sales_for_range(march_forecast)

    print(march_forecast.head())
    predicted = float(march_total['predicted_revenue'])
    lower = float(march_total['lower_bound'])
    business_id = "AMAZON"
    category_id = "ELECTRONICS"
    forecast = predict_category_sales_By_month(business_id, category_id, 6)
    monthly_forecast_df = monthly_forecast(forecast)
    print(f"Forecast for business_id '{business_id}' and category_id '{category_id}':")
    print(monthly_forecast_df.tail())

    ## Forecast for business_id 'biz_123' and category_id 'ELECTRONICS':
    #        month   predicted_revenue   lower_bound   upper_bound
    #    5  2023-06        9112.079906   -487.710719  18658.838866
    #    6  2023-07        5731.412243  -4241.616098  15513.223125
    #    7  2023-08        2127.679470  -7763.255184  11958.414838
    #    8  2023-09       -1454.581473 -11033.789128   8112.214608
    #    9  2023-10        -443.639805  -2626.447318   1772.966112


    ##
    # “Prophet expects around $9.1k in electronics sales in June,
    # but based on uncertainty, sales could be as low as ~$0
    # or as high as ~$18.6k.”

    # Example of filtering date range
    print('-----------------------------------------------------------------------------------------')
    start_date = "2026-12-01"
    end_date = "2026-12-31"
    forecast = predict_future(business_id="biz_123",category_id="ELECTRONICS", start_date=start_date, end_date=end_date)

    print(f"\nFiltered forecast from {start_date} to {end_date}:")
    march_forecast = forecast  # Already filtered
    march_total = total_sales_for_range(march_forecast)
    
    print(march_forecast.head())
    predicted = float(march_total['predicted_revenue'])
    lower = float(march_total['lower_bound'])
    upper = float(march_total['upper_bound'])
    print(f"\nTotal predicted sales for December 2026: ${predicted:.2f} (Lower bound: ${lower:.2f}, Upper bound: ${upper:.2f})")