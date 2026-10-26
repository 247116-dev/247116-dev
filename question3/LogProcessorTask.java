public class LogProcessorTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Batch Log Analysis Iteration: " + i);
            try {
                Thread.sleep(1000); // 1000ms pause
            } catch (InterruptedException e) {
                System.err.println("Log Processor Interrupted: " + e.getMessage());
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Batch Log Analysis Task Clean-up complete.");
    }
}
// Refactor checkpoint 1 for question3 code formatting

// Refactor checkpoint 2 for question3 code formatting

// Refactor checkpoint 3 for question3 code formatting

// Refactor checkpoint 4 for question3 code formatting

// Refactor checkpoint 5 for question3 code formatting

// Refactor checkpoint 1 for question3 code formatting

// Refactor checkpoint 2 for question3 code formatting

// Refactor checkpoint 3 for question3 code formatting

// Refactor checkpoint 4 for question3 code formatting

// Refactor checkpoint 5 for question3 code formatting
