#!/usr/bin/env python3
"""
Demonstration script for predicting top sales by category using Prophet models
"""

import pandas as pd
from business_prediction.main import (
    predict_top_categories_by_sales,
    predict_category_sales_trend
)

def main():
    business_id = "AMAZON"

    print("🚀 Amazon Sales Prediction - Top Categories by Time Frame")
    print("=" * 60)

    # Example 1: Get top 5 categories by monthly sales for next month
    print("\n📊 Top 5 Categories - Next Month Sales Forecast:")
    try:
        top_monthly = predict_top_categories_by_sales(
            business_id=business_id,
            time_frame='month',
            periods=1,
            top_n=5
        )
        print(top_monthly.to_string(index=False))
    except Exception as e:
        print(f"Error: {e}")

    # Example 2: Get top categories by weekly sales for next week
    print("\n📈 Top 3 Categories - Next Week Sales Forecast:")
    try:
        top_weekly = predict_top_categories_by_sales(
            business_id=business_id,
            time_frame='week',
            periods=1,
            top_n=3
        )
        print(top_weekly.to_string(index=False))
    except Exception as e:
        print(f"Error: {e}")

    # Example 3: Get sales trends for next 6 months for all categories
    print("\n📉 Sales Trends - Next 6 Months for All Categories:")
    try:
        trends = predict_category_sales_trend(
            business_id=business_id,
            time_frame='month',
            periods=6
        )

        # Show summary for each category
        summary = trends.groupby('category_id').agg({
            'yhat': ['mean', 'max'],
            'period': 'count'
        }).round(2)

        summary.columns = ['avg_monthly_sales', 'peak_monthly_sales', 'periods']
        print(summary.to_string())
    except Exception as e:
        print(f"Error: {e}")

    # Example 4: Compare specific categories over next year
    print("\n🔍 Year-ahead Forecast Comparison for Top Categories:")
    try:
        # First get top categories for next month
        top_cats = predict_top_categories_by_sales(
            business_id=business_id,
            time_frame='month',
            periods=1,
            top_n=3
        )

        top_category_ids = top_cats['category_id'].tolist()

        yearly_trends = predict_category_sales_trend(
            business_id=business_id,
            category_ids=top_category_ids,
            time_frame='month',
            periods=12
        )

        # Pivot for easier comparison
        comparison = yearly_trends.pivot(
            index='period',
            columns='category_id',
            values='yhat'
        ).round(2)

        print("Monthly predicted sales for top categories (next 12 months):")
        print(comparison.head(12))
    except Exception as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    main()