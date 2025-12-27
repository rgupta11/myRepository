#!/bin/bash
# Script to run tests with Python 3.9 virtual environment

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"

# Activate the Python 3.9 virtual environment
source "$PROJECT_ROOT/.venv39/bin/activate"

# Run pytest
python -m pytest tests

# Deactivate the virtual environment (optional)
# deactivate