#!/usr/bin/env python3
"""
Parquet Data Loader
Loads parquet files and optionally inserts data into ClickHouse
"""

import os
from business_prediction.dataloader.parquet_loader import ParquetLoader

def loader():
    """Main function to execute the parquet loader"""
    # Check if we should run in dry-run mode (no ClickHouse insertion)
    dry_run = os.getenv('DRY_RUN', 'false').lower() == 'true'

    loader = ParquetLoader()
    parquet_file_path = os.getenv('CLICKHOUSE_ORDER_FILE', 'data/amazon_category_sales_2023_2025.parquet')
    table_name = os.getenv('CLICKHOUSE_TABLE_NAME', 'category_sales_daily')

    print("🚀 Starting parquet loader...")
    if dry_run:
        print("🔍 Running in DRY RUN mode - will load data but skip ClickHouse insertion")

    df = loader.load_parquet(parquet_file_path, table_name, dry_run=dry_run)

    print("✅ Parquet loading completed!")
    if df is not None:
        print(f"📊 Final dataset shape: {df.shape}")

if __name__ == "__main__":
    loader()