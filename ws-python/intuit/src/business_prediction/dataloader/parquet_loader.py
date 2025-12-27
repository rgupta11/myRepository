from clickhouse_driver import Client
import pandas as pd
import os

# python file to load data into local clickhouse from parquet files.
class ParquetLoader:
    def __init__(self, clickhouse_host='localhost', clickhouse_port=9000, user='default', password='password', database='default'):
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
                self.client = Client(host=self.clickhouse_host, port=self.clickhouse_port,
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

    def load_parquet(self, parquet_file_path, table_name, dry_run=False):
        """Load parquet file and optionally insert into ClickHouse"""
        print(f"📁 Loading parquet file: {parquet_file_path}")

        # Load the parquet file
        df = pd.read_parquet(parquet_file_path)
        print(f"✅ Loaded {len(df)} rows with {len(df.columns)} columns")
        print(f"📊 Columns: {list(df.columns)}")
        print(f"📈 Sample data:\n{df.head()}")

        if dry_run:
            print("🔍 Dry run mode - skipping ClickHouse insertion")
            return df

        # Try to connect and insert
        if self.connect():
            try:
                self.client.execute(f"INSERT INTO {table_name} VALUES", df.to_dict('records'))
                print(f"✅ Successfully inserted {len(df)} rows into table '{table_name}'")
            except Exception as e:
                print(f"❌ Failed to insert data: {e}")
        else:
            print("💡 To insert data, start ClickHouse server and run again")

        return df