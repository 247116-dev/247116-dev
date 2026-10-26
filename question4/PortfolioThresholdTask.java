import java.util.concurrent.RecursiveAction;

public class PortfolioThresholdTask extends RecursiveAction {
    private static final int THRESHOLD = 1000;
    private double[] assetValues;
    private int start;
    private int end;
    private double riskCap;

    public PortfolioThresholdTask(double[] assetValues, int start, int end, double riskCap) {
        this.assetValues = assetValues;
        this.start = start;
        this.end = end;
        this.riskCap = riskCap;
    }

    @Override
    protected void compute() {
        if ((end - start) <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (assetValues[i] > riskCap) {
                    assetValues[i] -= assetValues[i] * 0.05; // 5% stress-test penalty
                }
            }
        } else {
            int mid = (start + end) / 2;
            PortfolioThresholdTask leftTask = new PortfolioThresholdTask(assetValues, start, mid, riskCap);
            PortfolioThresholdTask rightTask = new PortfolioThresholdTask(assetValues, mid, end, riskCap);
            invokeAll(leftTask, rightTask);
        }
    }
}
// Refactor checkpoint 1 for question4 code formatting

// Refactor checkpoint 2 for question4 code formatting

// Refactor checkpoint 3 for question4 code formatting

// Refactor checkpoint 4 for question4 code formatting

// Refactor checkpoint 5 for question4 code formatting

// Refactor checkpoint 1 for question4 code formatting

// Refactor checkpoint 2 for question4 code formatting

// Refactor checkpoint 3 for question4 code formatting

// Refactor checkpoint 4 for question4 code formatting

// Refactor checkpoint 5 for question4 code formatting
