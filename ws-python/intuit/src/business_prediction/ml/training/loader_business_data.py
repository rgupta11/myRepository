import clickhouse_connect
import pandas as pd
from clickhouse_driver import Client


class loader_business_data:
    
    def __init__(self, clickhouse_host='localhost', clickhouse_port=8123, user='default', password='', database='default'):
        self.clickhouse_host = clickhouse_host
        self.clickhouse_port = clickhouse_port
        self.user = user
        self.password = password
        self.database = database
        self.client = None

    def connect(self):
        """Connect to ClickHouse if not already connected"""
        if self.client is None:
            try:
                self.client = clickhouse_connect.get_client(host=self.clickhouse_host, port=self.clickhouse_port,
                                   user=self.user, password=self.password, database=self.database)
                # Test the connection
                self.client.execute("SELECT 1")
                print(f"✅ Connected to ClickHouse at {self.clickhouse_host}:{self.clickhouse_port}")
                return True
            except Exception as e:
                print(f"❌ Failed to connect to ClickHouse: {e}")
                print("💡 ClickHouse is not running. Data will be loaded but not inserted.")
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
                df = self.client.query_df(query)
                print(f"✅ Successfully fetched data for business_id '{business_id}'")
            except Exception as e:
                print(f"❌ Failed to fetch data for business_id '{business_id}': {e}")
                df = self._generate_sample_data(business_id)
        else:
            print("💡 ClickHouse not available, using sample data")
            df = self._generate_sample_data(business_id)
        return df
    
    def _generate_sample_data(self, business_id):
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
                base_revenue = np.random.randint(100, 1000)
                trend = (date - start_date).days * 0.1
                noise = np.random.normal(0, 50)
                revenue = max(0, base_revenue + trend + noise)
                
                data.append({
                    'ds': date,
                    'y': revenue,
                    'category_id': cat
                })
        
        df = pd.DataFrame(data)
        print(f"📊 Generated sample data with {len(df)} rows for business_id '{business_id}'")
        return df