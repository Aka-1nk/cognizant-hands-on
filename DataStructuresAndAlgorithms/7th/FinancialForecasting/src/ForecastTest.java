public class ForecastTest {
    public static void main(String[] args) {
        // Test the forecasting methods
        double result = FinancialForecasting.calculateFutureValue(1000, 5, 5);
        System.out.println("Test Result: $" + result);

        // Expected: $1276.28
    }
}