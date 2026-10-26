import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InventoryCatalogManager {
    private static final int NUM_THREADS = 10;
    private static final int OPS_PER_THREAD = 50000;
    private static final int TOTAL_OPERATIONS = NUM_THREADS * OPS_PER_THREAD;

    public static void benchmarkSynchronizedMap() throws InterruptedException {
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 100; i++) {
            syncMap.put("PROD_" + i, 1000);
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(() -> {
                for (int j = 0; j < OPS_PER_THREAD; j++) {
                    String key = "PROD_" + (j % 100);
                    Integer currentVal = syncMap.get(key);
                    if (currentVal != null) {
                        syncMap.put(key, currentVal + 1);
                    }
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.nanoTime();

        double durationSeconds = (endTime - startTime) / 1e9;
        double throughput = TOTAL_OPERATIONS / durationSeconds;

        System.out.println("--- Coarse-Grained Locking (Collections.synchronizedMap) ---");
        System.out.printf("Execution Time: %.4f seconds%n", durationSeconds);
        System.out.printf("Throughput: %.2f ops/sec%n%n", throughput);
    }

    public static void benchmarkConcurrentMap() throws InterruptedException {
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            concurrentMap.put("PROD_" + i, 1000);
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(() -> {
                for (int j = 0; j < OPS_PER_THREAD; j++) {
                    String key = "PROD_" + (j % 100);
                    concurrentMap.computeIfPresent(key, (k, v) -> v + 1);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.nanoTime();

        double durationSeconds = (endTime - startTime) / 1e9;
        double throughput = TOTAL_OPERATIONS / durationSeconds;

        System.out.println("--- Fine-Grained Bucket Locking (ConcurrentHashMap) ---");
        System.out.printf("Execution Time: %.4f seconds%n", durationSeconds);
        System.out.printf("Throughput: %.2f ops/sec%n%n", throughput);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting High-Throughput E-Commerce Catalog Benchmarking...\n");
        benchmarkSynchronizedMap();
        benchmarkConcurrentMap();
    }
}
// Refactor checkpoint 1 for question6 code formatting

// Refactor checkpoint 2 for question6 code formatting

// Refactor checkpoint 3 for question6 code formatting

// Refactor checkpoint 4 for question6 code formatting

// Refactor checkpoint 5 for question6 code formatting

// Refactor checkpoint 1 for question6 code formatting

// Refactor checkpoint 2 for question6 code formatting

// Refactor checkpoint 3 for question6 code formatting

// Refactor checkpoint 4 for question6 code formatting

// Refactor checkpoint 5 for question6 code formatting

// Refactor checkpoint 1 for question6 code formatting

// Refactor checkpoint 2 for question6 code formatting
