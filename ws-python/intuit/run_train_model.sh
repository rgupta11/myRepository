#!/bin/bash
# Script to train the business prediction model

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"

# Activate the Python 3.9 virtual environment
source "$PROJECT_ROOT/.venv39/bin/activate"

# Run the training script
python src/business_prediction/ml/training/model_training.py

# Deactivate the virtual environment (optional)
# deactivate