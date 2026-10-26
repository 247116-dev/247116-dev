public class TelemetryThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] System CPU & Memory Health Metrics Capture Iteration: " + i);
            try {
                Thread.sleep(800); // 800ms pause
            } catch (InterruptedException e) {
                System.err.println("Telemetry Worker Interrupted: " + e.getMessage());
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Metrics Worker Clean-up complete.");
    }
}
// Refactor checkpoint 1 for question3 code formatting

// Refactor checkpoint 2 for question3 code formatting

// Refactor checkpoint 3 for question3 code formatting
