public class CacheLocalityBenchmark {
    private static final int SIZE = 2000;
    private static final double[][] matrix = new double[SIZE][SIZE];
    private static final int ITERATIONS = 10;

    public static double traverseRowMajor() {
        double sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static double traverseColumnMajor() {
        double sum = 0;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Initialize Matrix
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = 1.0;
            }
        }

        // Warm-up JVM execution paths
        for (int i = 0; i < 3; i++) {
            traverseRowMajor();
            traverseColumnMajor();
        }

        // Measure Row-Major Traversal
        long startRow = System.nanoTime();
        for (int k = 0; k < ITERATIONS; k++) {
            traverseRowMajor();
        }
        long endRow = System.nanoTime();
        double rowTimeMs = ((endRow - startRow) / 1e6) / ITERATIONS;

        // Measure Column-Major Traversal
        long startCol = System.nanoTime();
        for (int k = 0; k < ITERATIONS; k++) {
            traverseColumnMajor();
        }
        long endCol = System.nanoTime();
        double colTimeMs = ((endCol - startCol) / 1e6) / ITERATIONS;

        double speedup = colTimeMs / rowTimeMs;

        System.out.println("=== CPU CACHE LOCALITY PROFILING RESULTS ===");
        System.out.printf("Row-Major Traversal Avg Time   : %.4f ms%n", rowTimeMs);
        System.out.printf("Column-Major Traversal Avg Time: %.4f ms%n", colTimeMs);
        System.out.printf("Speedup Ratio (Row over Column) : %.2fx faster%n", speedup);

        printExecutionReportExplanation();
    }

    private static void printExecutionReportExplanation() {
        System.out.println("\n--- WRITTEN REPORT EXPLANATION ---");
        System.out.println("Java arrays are stored in memory in Row-Major order. Modern CPU microarchitectures load contiguous memory blocks into Level 1/2/3 cache lines (typically 64 bytes).");
        System.out.println("1. Row-Major Traversal (i, j) accesses adjacent memory addresses (Stride-1 access). When element [i][j] is fetched, the CPU cache controller automatically prefetches adjacent contiguous elements [i][j+1], [i][j+2], yielding a high L1/L2 cache hit rate.");
        System.out.println("2. Column-Major Traversal (j, i) accesses elements separated by 2000 double elements (16,000 bytes offset, non-contiguous stride). This causes spatial locality invalidation, generating constant L1/L2 cache misses, memory bus stalls, and frequent main memory roundtrips, significantly degrading performance.");
    }
}