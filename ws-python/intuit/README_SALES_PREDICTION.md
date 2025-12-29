# Amazon Sales Prediction with Prophet

This project demonstrates how to use Facebook Prophet models to predict top sales by category over different selectable time frames (week, month, year) using Amazon sales sample data.

## Overview

The system trains separate Prophet models for each product category but provides unified prediction functions to:
- Forecast sales for individual categories
- Rank categories by predicted sales over different time frames
- Compare sales trends across categories

## Key Features

- **Multi-category forecasting**: Predict sales for all Amazon categories simultaneously
- **Flexible time frames**: Support for weekly, monthly, and yearly forecasts
- **Top-N ranking**: Identify top-performing categories by predicted sales
- **Trend analysis**: Compare sales trends across categories over time

## Usage

### Basic Usage

```python
from src.business_prediction.main import predict_top_categories_by_sales

# Get top 5 categories by sales for next month
top_categories = predict_top_categories_by_sales(
    business_id="AMAZON",
    time_frame='month',
    periods=1,
    top_n=5
)
print(top_categories)
```

### Available Functions

#### `predict_top_categories_by_sales()`
Predict and rank top categories by sales for a specific time frame.

**Parameters:**
- `business_id` (str): Business identifier (e.g., "AMAZON")
- `time_frame` (str): 'week', 'month', or 'year'
- `periods` (int): Number of time periods to forecast (default: 1)
- `top_n` (int): Number of top categories to return (default: 5)

**Returns:** DataFrame with columns:
- `category_id`: Category identifier
- `predicted_sales`: Forecasted sales amount
- `lower_bound`: Lower confidence bound
- `upper_bound`: Upper confidence bound
- `forecast_period`: Time period of forecast
- `time_frame`: Time frame used
- `periods`: Number of periods forecasted

#### `predict_category_sales_trend()`
Get detailed sales trends for specified categories over multiple periods.

**Parameters:**
- `business_id` (str): Business identifier
- `category_ids` (List[str], optional): Specific categories to forecast (None for all)
- `time_frame` (str): 'week', 'month', or 'year'
- `periods` (int): Number of time periods to forecast

**Returns:** DataFrame with aggregated sales predictions per time period

### Example Usage Patterns

```python
# Weekly forecast for top 3 categories
weekly_top = predict_top_categories_by_sales(
    business_id="AMAZON",
    time_frame='week',
    periods=1,
    top_n=3
)

# Monthly trends for next 6 months for all categories
monthly_trends = predict_category_sales_trend(
    business_id="AMAZON",
    time_frame='month',
    periods=6
)

# Year-ahead forecast for specific categories
yearly_forecast = predict_category_sales_trend(
    business_id="AMAZON",
    category_ids=['ELECTRONICS', 'FASHION'],
    time_frame='month',
    periods=12
)
```

## Model Training

The system uses pre-trained Prophet models stored in the `models/` directory. Each model is trained on historical sales data for a specific category.

To retrain models:
```bash
cd src/business_prediction/ml/training
python model_training.py
```

## Data Structure

The system expects sales data with the following structure:
- `ds`: Date column (datetime)
- `y`: Sales/revenue column (numeric)
- `category_id`: Category identifier

## Categories Supported

- ELECTRONICS
- FASHION
- HOME_KITCHEN
- GROCERY
- SPORTS_OUTDOORS

## Running the Demo

```bash
python demo_top_sales.py
```

This will demonstrate:
1. Top 5 categories by monthly sales
2. Top 3 categories by weekly sales
3. Sales trends summary for all categories
4. Year-ahead comparison for top categories

## Dependencies

- prophet
- pandas
- numpy
- joblib
- pyarrow (for parquet data loading)

## Notes

- Models are trained separately for each category for better accuracy
- Predictions include uncertainty bounds (lower/upper confidence intervals)
- Time frame aggregation uses approximate conversions (30 days/month, 365 days/year)
- All sales predictions are clipped to non-negative values</content>
<parameter name="filePath">/Users/ravigupta/work/codebase/myRepository/ws-python/intuit/README_SALES_PREDICTION.md