public class ParallelMaxSearch extends SensorSearchEngine {

    public ParallelMaxSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
        this.result = Double.MIN_VALUE;
    }

    @Override
    public void processGrid() {
        double max = Double.MIN_VALUE;
        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] > max) {
                max = sensorData[i];
            }
        }
        this.result = max;
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
