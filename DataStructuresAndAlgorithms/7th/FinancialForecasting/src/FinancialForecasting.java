public class FinancialForecasting {

    /**
     * Calculate future value using recursive approach
     * @param initialValue The starting value
     * @param growthRate The growth rate (as percentage, e.g., 5 for 5%)
     * @param periods Number of periods to forecast
     * @return Future value after specified periods
     */
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        // Base case: No more periods to forecast
        if (periods == 0) {
            return initialValue;
        }

        // Recursive case: Calculate value for one period and recurse
        double growthFactor = 1 + (growthRate / 100);
        return calculateFutureValue(initialValue * growthFactor, growthRate, periods - 1);
    }

    /**
     * Alternative implementation using tail recursion
     * This is more efficient as it can be optimized by the compiler
     */
    public static double calculateFutureValueTailRecursive(double initialValue, double growthRate, int periods) {
        return tailRecursiveHelper(initialValue, growthRate, periods);
    }

    private static double tailRecursiveHelper(double currentValue, double growthRate, int remainingPeriods) {
        if (remainingPeriods == 0) {
            return currentValue;
        }
        double growthFactor = 1 + (growthRate / 100);
        return tailRecursiveHelper(currentValue * growthFactor, growthRate, remainingPeriods - 1);
    }

    /**
     * Advanced forecasting with multiple scenarios
     * Predicts future values based on historical growth rates
     */
    public static double predictFutureValue(double[] historicalValues, int periodsToPredict) {
        if (historicalValues == null || historicalValues.length < 2) {
            throw new IllegalArgumentException("Need at least 2 historical values");
        }

        // Calculate average growth rate from historical data
        double totalGrowthRate = 0;
        for (int i = 1; i < historicalValues.length; i++) {
            double growthRate = ((historicalValues[i] - historicalValues[i-1]) / historicalValues[i-1]) * 100;
            totalGrowthRate += growthRate;
        }
        double averageGrowthRate = totalGrowthRate / (historicalValues.length - 1);

        // Use recursive forecasting
        return calculateFutureValue(historicalValues[historicalValues.length - 1],
                averageGrowthRate, periodsToPredict);
    }

    /**
     * Generate forecast for multiple periods
     */
    public static double[] generateForecast(double initialValue, double growthRate, int periods) {
        double[] forecast = new double[periods + 1];
        generateForecastRecursive(initialValue, growthRate, periods, 0, forecast);
        return forecast;
    }

    private static void generateForecastRecursive(double currentValue, double growthRate,
                                                  int periods, int currentPeriod, double[] forecast) {
        // Store current value
        forecast[currentPeriod] = currentValue;

        // Base case
        if (currentPeriod == periods) {
            return;
        }

        // Recursive case
        double growthFactor = 1 + (growthRate / 100);
        generateForecastRecursive(currentValue * growthFactor, growthRate,
                periods, currentPeriod + 1, forecast);
    }

    public static void main(String[] args) {
        // Example 1: Simple future value calculation
        double initialInvestment = 1000.0;
        double annualGrowthRate = 5.0; // 5%
        int years = 10;

        System.out.println("=== Simple Future Value ===");
        System.out.printf("Initial Investment: $%.2f%n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.1f%%%n", annualGrowthRate);
        System.out.printf("Periods: %d years%n", years);

        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, years);
        System.out.printf("Future Value after %d years: $%.2f%n%n", years, futureValue);

        // Example 2: Historical data forecasting
        System.out.println("=== Historical Data Forecasting ===");
        double[] historicalData = {1000, 1020, 1040, 1060, 1080, 1110, 1130, 1150, 1180, 1200};
        System.out.println("Historical Values: " + java.util.Arrays.toString(historicalData));

        int futurePeriods = 3;
        double predictedValue = predictFutureValue(historicalData, futurePeriods);
        System.out.printf("Predicted value after %d periods: $%.2f%n%n", futurePeriods, predictedValue);

        // Example 3: Full forecast generation
        System.out.println("=== Full Forecast Generation ===");
        double[] forecast = generateForecast(initialInvestment, annualGrowthRate, years);
        System.out.println("Forecast for each year:");
        for (int i = 0; i < forecast.length; i++) {
            System.out.printf("Year %d: $%.2f%n", i, forecast[i]);
        }
    }
}