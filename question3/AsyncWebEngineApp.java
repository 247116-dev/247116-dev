public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("Master Application Driver Active on Thread: " + Thread.currentThread().getName());

        TelemetryThread telemetryWorker = new TelemetryThread();
        telemetryWorker.setName("Telemetry-Worker");

        LogProcessorTask logTask = new LogProcessorTask();
        Thread logWorker = new Thread(logTask, "Log-Worker");

        System.out.println("Starting asynchronous background workers...");
        telemetryWorker.start();
        logWorker.start();

        System.out.println("Telemetry Worker State: " + telemetryWorker.getState());
        System.out.println("Log Worker State: " + logWorker.getState());

        try {
            telemetryWorker.join();
            logWorker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Master Driver Thread (" + Thread.currentThread().getName() + "): All background telemetry tasks terminated cleanly.");
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

// Refactor checkpoint 1 for question3 code formatting

// Refactor checkpoint 2 for question3 code formatting

// Refactor checkpoint 3 for question3 code formatting
