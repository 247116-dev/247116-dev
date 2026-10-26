import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        int arraySize = 50000;
        double[] sensorTelemetry = new double[arraySize];
        Random rand = new Random(12345);

        for (int i = 0; i < arraySize; i++) {
            sensorTelemetry[i] = -20.0 + (rand.nextDouble() * 120.0); // Temperature/Vibration values
        }

        int numThreads = 4;
        int chunkSize = arraySize / numThreads;

        ParallelMinSearch[] minTasks = new ParallelMinSearch[numThreads];
        ParallelMaxSearch[] maxTasks = new ParallelMaxSearch[numThreads];
        Thread[] minThreads = new Thread[numThreads];
        Thread[] maxThreads = new Thread[numThreads];

        long startTime = System.nanoTime();

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? arraySize : start + chunkSize;

            minTasks[i] = new ParallelMinSearch(sensorTelemetry, start, end);
            maxTasks[i] = new ParallelMaxSearch(sensorTelemetry, start, end);

            minThreads[i] = new Thread(minTasks[i]);
            maxThreads[i] = new Thread(maxTasks[i]);

            minThreads[i].start();
            maxThreads[i].start();
        }

        double globalMin = Double.MAX_VALUE;
        double globalMax = Double.MIN_VALUE;

        for (int i = 0; i < numThreads; i++) {
            minThreads[i].join();
            maxThreads[i].join();
            globalMin = Math.min(globalMin, minTasks[i].getResult());
            globalMax = Math.max(globalMax, maxTasks[i].getResult());
        }

        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1e6;

        System.out.println("=== IOT SENSOR GRID PARALLEL REDUCTION RESULTS ===");
        System.out.printf("Global Minimum Recorded Sensor Value: %.2f%n", globalMin);
        System.out.printf("Global Peak Anomaly Recorded Sensor Value: %.2f%n", globalMax);
        System.out.printf("Total Parallel Reduction Execution Time: %.3f ms%n", executionTimeMs);
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
