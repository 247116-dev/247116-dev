public abstract class SensorSearchEngine implements Runnable {
    protected double[] sensorData;
    protected int startIdx;
    protected int endIdx;
    protected double result;

    public SensorSearchEngine(double[] sensorData, int startIdx, int endIdx) {
        this.sensorData = sensorData;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    public abstract void processGrid();

    @Override
    public void run() {
        processGrid();
    }

    public double getResult() {
        return result;
    }
}
// Refactor checkpoint 1 for question5 code formatting

// Refactor checkpoint 2 for question5 code formatting

// Refactor checkpoint 3 for question5 code formatting

// Refactor checkpoint 4 for question5 code formatting

// Refactor checkpoint 5 for question5 code formatting

// Refactor checkpoint 1 for question5 code formatting

// Refactor checkpoint 2 for question5 code formatting

// Refactor checkpoint 3 for question5 code formatting

// Refactor checkpoint 4 for question5 code formatting

// Refactor checkpoint 5 for question5 code formatting

// Refactor checkpoint 1 for question5 code formatting

// Refactor checkpoint 2 for question5 code formatting

// Refactor checkpoint 3 for question5 code formatting
