import clickhouse_connect
import pandas as pd
import os
from clickhouse_driver import Client


class loader_business_data:
    
    def __init__(self, clickhouse_host='localhost', clickhouse_port=8123, user='default', password='password', database='default'):
        self.clickhouse_host = clickhouse_host
        self.clickhouse_port = clickhouse_port
        self.user = user
        self.password = os.getenv('CLICKHOUSE_PASSWORD', '') if password is None else password
        self.database = database
        self.client = None
        self.use_driver = False

    def connect(self):
        """Connect to ClickHouse if not already connected"""
        if self.client is None:
            try:
                self.client = clickhouse_connect.get_client(host=self.clickhouse_host, port=self.clickhouse_port,
                                   user=self.user, password=self.password, database=self.database)
                # Test the connection
                result = self.client.query("SELECT 1")
                print(f"✅ Connected to ClickHouse at {self.clickhouse_host}:{self.clickhouse_port}")
                return True
            except Exception as e:
                print(f"❌ Failed to connect to ClickHouse: {e}")
                print("💡 Trying with clickhouse_driver...")
                try:
                    from clickhouse_driver import Client as CHClient
                    self.client = CHClient(host=self.clickhouse_host, port=self.clickhouse_port,
                                           user=self.user, password=self.password, database=self.database)
                    self.client.execute("SELECT 1")
                    print(f"✅ Connected to ClickHouse with clickhouse_driver at {self.clickhouse_host}:{self.clickhouse_port}")
                    self.use_driver = True
                    return True
                except Exception as e2:
                    print(f"❌ Failed with clickhouse_driver: {e2}")
                    print("💡 ClickHouse not available, using parquet data")
                    self.client = None
                    return False
        return True
    
    def load_business_data(self, business_id: str):
        #client = clickhouse_connect.get_client(host='localhost')
        
        query = f"""
        SELECT
            day_start AS ds,
            total_revenue AS y,
            category_id
        FROM category_sales_daily
        WHERE business_id = '{business_id}'
        ORDER BY category_id, day_start
        """
        # Try to connect and insert
        if self.connect():
            try:
                if self.use_driver:
                    # Use clickhouse_driver
                    result = self.client.query_dataframe(query)
                    df = result
                else:
                    # Use clickhouse_connect
                    df = self.client.query_df(query)
                print(f"✅ Successfully fetched data for business_id '{business_id}' from ClickHouse")
            except Exception as e:
                print(f"❌ Failed to fetch data for business_id '{business_id}': {e}")
                df = self._generate_sample_data(business_id)
        else:
            print("💡 ClickHouse not available, using sample data")
            df = self._generate_sample_data(business_id)
        return df
    
    def _generate_sample_data(self, business_id):
        """Load data from parquet file"""
        parquet_path = os.path.join(os.path.dirname(__file__), '..', '..', '..', '..', 'data', 'amazon_category_' \
        'sales_2023_2025.parquet')
        if os.path.exists(parquet_path):
            df = pd.read_parquet(parquet_path)
            print(f"📊 Loaded real data from {parquet_path} with {len(df)} rows")
            # Filter for the business_id if needed
            if 'business_id' in df.columns:
                df = df[df['business_id'] == business_id]
            # Rename columns to match expected: ds, y, category_id
            if 'day_start' in df.columns and 'total_revenue' in df.columns and 'category_id' in df.columns:
                df = df.rename(columns={'day_start': 'ds', 'total_revenue': 'y'})
                df = df[['ds', 'y', 'category_id']]  # Keep only needed columns
                print(f"✅ Data prepared with {len(df)} rows, date range: {df['ds'].min()} to {df['ds'].max()}")
                return df
            else:
                print("⚠️  Parquet file missing required columns. Falling back to sample data.")
                return self._generate_fallback_sample(business_id)
        else:
            print("⚠️  Parquet file not found. Generating sample data.")
            return self._generate_fallback_sample(business_id)
    
    def _generate_fallback_sample(self, business_id):
        """Generate sample data for testing"""
        import numpy as np
        from datetime import datetime, timedelta
        
        # Generate dates for 100 days
        start_date = datetime(2023, 1, 1)
        dates = [start_date + timedelta(days=i) for i in range(100)]
        
        # Sample categories
        categories = ['ELECTRONICS', 'FASHION', 'HOME_KITCHEN', 'GROCERY', 'SPORTS_OUTDOORS']
        
        data = []
        for cat in categories:
            for date in dates:
                # Generate some revenue data
                base_revenue = np.random.randint(500, 2000)
                trend = (date - start_date).days * 2.0  # Stronger positive trend
                noise = np.random.normal(0, 20)  # Reduced noise
                revenue = max(0, base_revenue + trend + noise)
                
                data.append({
                    'ds': date,
                    'y': revenue,
                    'category_id': cat
                })
        
        df = pd.DataFrame(data)
        print(f"📊 Generated fallback sample data with {len(df)} rows for business_id '{business_id}'")
        return df