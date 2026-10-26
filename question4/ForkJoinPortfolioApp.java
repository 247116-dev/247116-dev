import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int datasetSize = 10000;
        double[] assets = new double[datasetSize];
        Random random = new Random(42);

        for (int i = 0; i < datasetSize; i++) {
            assets[i] = 100 + random.nextDouble() * 900;
        }

        ForkJoinPool pool = new ForkJoinPool();

        // 1. Calculate Initial Cumulative Risk Parallelly
        long startTime = System.nanoTime();
        ParallelRiskCalculator initialRiskTask = new ParallelRiskCalculator(assets, 0, datasetSize);
        double totalRiskBefore = pool.invoke(initialRiskTask);
        long endTime = System.nanoTime();
        double parallelDurationMs = (endTime - startTime) / 1e6;

        System.out.printf("Total Cumulative Risk (Initial): $%.2f%n", totalRiskBefore);
        System.out.printf("Fork/Join Calculation Execution Time: %.3f ms%n", parallelDurationMs);

        // 2. Apply Stress-test Penalty (Threshold Task)
        double riskCap = 500.00;
        PortfolioThresholdTask stressTestTask = new PortfolioThresholdTask(assets, 0, datasetSize, riskCap);
        pool.invoke(stressTestTask);

        // 3. Recalculate Risk After Penalty
        ParallelRiskCalculator postRiskTask = new ParallelRiskCalculator(assets, 0, datasetSize);
        double totalRiskAfter = pool.invoke(postRiskTask);

        System.out.printf("Total Cumulative Risk (Post-Stress Test Penalty): $%.2f%n", totalRiskAfter);
    }
}
// Refactor checkpoint 1 for question4 code formatting
