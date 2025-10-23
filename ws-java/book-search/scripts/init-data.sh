#!/bin/bash

# Wait for PostgreSQL to be ready
echo "Waiting for PostgreSQL to be ready..."
until pg_isready -h library-db -p 5432 -U admin; do
  echo "PostgreSQL is not ready yet. Waiting..."
  sleep 2
done

echo "PostgreSQL is ready! Starting data import..."

# Set Java environment
export JAVA_HOME=/opt/java/openjdk
export PATH=$JAVA_HOME/bin:$PATH
export CSV_PATH=/app/resources/books.csv

# Navigate to the project directory
cd /app

# Run the data import
echo "Executing DBImporter..."
java -cp /app/app.jar com.h2.utils.DBImporter

if [ $? -eq 0 ]; then
    echo "Data import completed successfully!"
else
    echo "Data import failed!"
    exit 1
fi
