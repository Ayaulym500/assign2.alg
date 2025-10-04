import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("TESTS Correctness");

        try {
            MaxHeap emptyHeap = new MaxHeap(5, null);
            emptyHeap.extractMax();
            System.out.println("Empty heap test failed");
        } catch (Exception e) {
            System.out.println("Empty heap test passed (" + e.getClass().getSimpleName() + ")");
        }


        MaxHeap singleHeap = new MaxHeap(3, null);
        singleHeap.insert(42);
        int singleExtracted = singleHeap.extractMax();
        if (singleExtracted == 42 && singleHeap.isEmpty()) {
            System.out.println("Single element test passed");
        } else {
            System.out.println("Single element test failed");
        }

        MaxHeap dupHeap = new MaxHeap(5, null);
        dupHeap.insert(7);
        dupHeap.insert(7);
        dupHeap.insert(7);
        boolean duplicatesOK = true;
        while (!dupHeap.isEmpty()) {
            if (dupHeap.extractMax() != 7) {
                duplicatesOK = false;
                break;
            }
        }
        if (duplicatesOK) System.out.println("Duplicate elements test passed");
        else System.out.println("Duplicate elements test failed");

        System.out.println("\n (Performance)");
        System.out.println("n,time(ms),comparisons,swaps,accesses,allocations");

        // Benchmark heap performance for different input sizes
        int[] sizes = {100, 1000, 10000, 100000};

        for (int n : sizes) {
            PerformanceTracker tracker = null;


            MaxHeap heap = new MaxHeap(Math.max(10, n), tracker);
            tracker = heap.getTracker();

            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                heap.insert(random.nextInt(1000000));
            }
            while (!heap.isEmpty()) heap.extractMax();
            long end = System.currentTimeMillis();

            System.out.printf("%d,%d,%s%n", n, (end - start), tracker.toString());
        }
    }
}
