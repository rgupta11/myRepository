## Time-based validation (backtesting)
# You simulate the past:
#   Train on data up to time T
#   Predict T+1 → T+h
#   Compare prediction vs actuals

# Step 1: Choose validation windows

#   Example (3 years of data):

#      Window   Meaning
#      Train Jan 2021 – Dec 2022
#      Validate Jan 2023
#      Horizon  30 days (monthly)

# Train → Predict next 30 days → Score
# Shift window forward → Repeat 

## Metrics that actually matter
#   - MAE (Mean Absolute Error)
#   - RMSE (Root Mean Squared Error)
#   - MAPE (Mean Absolute Percentage Error)
#   - Business-specific metrics (e.g., revenue impact)
#   - WAPE (Weighted Absolute Percentage Error) ⭐ (Recommended)
#       WAPE = sum(|actual − predicted|) / sum(actual)

## You validate like this:
# “For ELECTRONICS, how accurate was our monthly forecast total?”
# This matches business usage.   
# Aggregate predictions and actuals over the validation period.
# Compute WAPE over these aggregates.

## Concrete validation workflow (step-by-step) - (Custom)
# Step 1: Prepare historical actuals from ClickHouse

#       Example query (monthly actuals):

#       SELECT
#         category_id,
#         toStartOfMonth(day_start) AS month,
#         sum(total_revenue) AS actual_revenue
#       FROM category_sales_daily
#       WHERE business_id = 'AMAZON'
#       GROUP BY category_id, month
#       ORDER BY month;

#    Step 2: Generate historical forecasts (backtest)

#       For each validation window:

#       Train model only on data before cutoff
#       Predict next period
#       Aggregate prediction
#       Store result

## Prophet-native cross-validation (automated)
# Prophet provides built-in tooling that is correct for time series.

from prophet.diagnostics import cross_validation, performance_metrics
import joblib
import numpy as np
import matplotlib.pyplot as plt

models = joblib.load("models/prophet_AMAZON.joblib")
electronics_model = models["ELECTRONICS"]

print(electronics_model.history.shape)


## electronic model 
df_cv = cross_validation(
       electronics_model,
       horizon="30 days",
       period="30 days",
       initial="730 days"
   )
df_cv["horizon"] = df_cv["ds"] - df_cv["cutoff"]
df_perf = performance_metrics(df_cv, rolling_window=0)
    

df_cv["abs_error"] = np.abs(df_cv["y"] - df_cv["yhat"])

df_wape = (
    df_cv
    .groupby("horizon")
    .apply(lambda x: x["abs_error"].sum() / x["y"].sum())
    .reset_index(name="wape")
)

df_perf = df_perf.merge(df_wape, on="horizon", how="left")
print(df_perf[['horizon', 'mape', 'wape', 'mae', 'rmse']])

wape = np.abs(df_cv["y"] - df_cv["yhat"]).sum() / df_cv["y"].sum()
print("\nGlobal WAPE:", wape)


#Graph using matplotlib
plt.figure(figsize=(10, 6))
plt.plot(df_perf["horizon"].dt.days, df_perf["mape"], marker='o', label='MAPE')
plt.plot(df_perf["horizon"].dt.days, df_perf["wape"], marker='o', label='WAPE')
plt.xlabel("Horizon (days)")
plt.ylabel("Error")
plt.title("Forecast Error by Horizon for ELECTRONICS Category")
plt.legend()
plt.grid()
plt.show()


## Metrics that actually matter
#   - MAE (Mean Absolute Error)
#   - RMSE (Root Mean Squared Error)
#   - MAPE (Mean Absolute Percentage Error)
#   - Business-specific metrics (e.g., revenue impact)
#   - WAPE (Weighted Absolute Percentage Error) ⭐ (Recommended)
#       WAPE = sum(|actual − predicted|) / sum(actual)

## Interpretation:

# MAPE = 0.12 → 12% error
# On average, predictions are off by ~12%
# MAE tells you absolute revenue error

# Rule of thumb:

# MAPE	    Interpretation
# < 10%	    Excellent
# 10–15%	Good
# 15–25%	Usable


# Column   Meaning
# horizon  How many days into the future the forecast is
# mape     Mean Absolute Percentage Error
# mae      Mean Absolute Error (absolute ₹ / $ error)
# rmse     Root Mean Squared Error (penalizes large misses)


# Let’s summarize the MAPE range:

    # Best: ~0.43 (43%)
    # Worst: ~0.77 (77%)
    # Most values: 55%–70%


# Conclusion: Model has high error for ELECTRONICS category
# Actionable next steps:
#   - Investigate data quality
#   - Experiment with feature engineering
#   - Try alternative modeling approaches   
# 
# Is this “bad”? Context matters
# For daily ELECTRONICS sales, this is not surprising

# Electronics sales typically:
# Are volatile
# Have spikes (launches, promotions)
# Have long flat periods
# Daily forecasting is the hardest version of this problem.    




# (1096, 5)
#   0%|                                                                                                        | 0/12 [00:00<?, ?it/s]20:25:40 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:40 - cmdstanpy - INFO - Chain [1] done processing
# 20:25:40 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:40 - cmdstanpy - INFO - Chain [1] done processing
#  17%|████████████████                                                                                | 2/12 [00:00<00:00, 15.80it/s]20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
#  33%|████████████████████████████████                                                                | 4/12 [00:00<00:00, 16.59it/s]20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
#  50%|████████████████████████████████████████████████                                                | 6/12 [00:00<00:00, 16.95it/s]20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
#  67%|████████████████████████████████████████████████████████████████                                | 8/12 [00:00<00:00, 15.47it/s]20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
#  83%|███████████████████████████████████████████████████████████████████████████████▏               | 10/12 [00:00<00:00, 15.58it/s]20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] start processing
# 20:25:41 - cmdstanpy - INFO - Chain [1] done processing
# 100%|███████████████████████████████████████████████████████████████████████████████████████████████| 12/12 [00:00<00:00, 15.61it/s]
#    horizon      mape           mae          rmse
# 0   3 days  0.641055  11757.894393  13562.126195
# 1   4 days  0.501215  10685.870944  12266.260992
# 2   5 days  0.504795  11383.519351  12975.521603
# 3   6 days  0.574367  10574.259695  12331.771060
# 4   7 days  0.578839  10475.665498  12529.678333
# 5   8 days  0.714207  10012.418998  12172.490228
# 6   9 days  0.617948  10227.101610  12034.883206
# 7  10 days  0.623271  10511.328116  12062.606544
# 8  11 days  0.572164  10093.785022  11903.855415
# 9  12 days  0.597453  10384.879118  12154.915106
# 10 13 days  0.625616  10371.611484  12463.534052
# 11 14 days  0.558182  10470.396082  12320.240961
# 12 15 days  0.692601  11489.991446  13440.755877
# 13 16 days  0.667163  11587.951693  13251.069490
# 14 17 days  0.768285  11793.871128  13525.192902
# 15 18 days  0.651296  10943.841801  12454.919431
# 16 19 days  0.695777  11366.298918  12984.824532
# 17 20 days  0.615074  11068.456537  12323.871894
# 18 21 days  0.689113  11632.808533  13170.433003
# 19 22 days  0.662984  10705.177478  12169.028464
# 20 23 days  0.663526  10518.521969  12234.258923
# 21 24 days  0.514918   9952.970439  11445.628128
# 22 25 days  0.618904  10668.000323  12305.645164
# 23 26 days  0.722983  10991.022276  12611.584097
# 24 27 days  0.684451  10226.121421  12194.333795
# 25 28 days  0.586770  10298.523929  12117.151416
# 26 29 days  0.426457  10568.623586  12478.693574
# 27 30 days  0.518905  11924.775946  13322.906018
# WAPE: 0.4080325799020927


# Interpretation - perplexity
# Metric	Meaning	                            Good Threshold (Sales)
# MAPE	% error: (actual-pred)/actual × 100	<20% = Excellent, <50% = Good
# MAE	Absolute $ error	                    Absolute dollars off
# RMSE	Error standard deviation	        Sensitive to outliers
# WAPE	Weighted Absolute % Error (overall)	0.41 = 41% → DECENT


# For e-commerce Electronics forecasting:

# Horizon	    Use Case	            Actionable?
# 1-7 days	Inventory restock	    ✅ Yes (58% MAPE)
# 7-30 days	Supplier orders	        ✅ Yes (41-69% MAPE)
# >30 days	Capacity planning	    ⚠️ Marginal



# Summary of ELECTRONICS category forecast accuracy:
# WAPE: 0.408 → 40.8% error
# On average, predictions are off by ~40.8%
# This is reasonable for daily ELECTRONICS sales
# Electronics sales are volatile with spikes and flat periods
# Daily forecasting is the hardest version of this problem
# Next steps:
#   - Investigate data quality
#   - Experiment with feature engineering       