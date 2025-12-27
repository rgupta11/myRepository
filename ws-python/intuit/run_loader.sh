#!/bin/bash
# Script to run the parquet loader with correct environment

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"

# Run loader.py with correct Python and path
cd "$SCRIPT_DIR"
PYTHONPATH=src "$PROJECT_ROOT/.venv39/bin/python" src/business_prediction/loader.py