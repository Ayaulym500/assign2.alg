// MaxHeapTest.java
// CLI-тест: проверка корректности, производительности и метрик

import java.util.Random;

public class MaxHeapTest {
    public static void main(String[] args) {
        PerformanceTracker tracker = new PerformanceTracker();

        testSmallHeap(tracker);
        benchmark(tracker, 100);
        benchmark(tracker, 1000);
        benchmark(tracker, 10000);
        benchmark(tracker, 100000);
    }

    private static void testSmallHeap(PerformanceTracker tracker) {
        System.out.println("TEST SMALL HEAP");
        MaxHeap heap = new MaxHeap(10, tracker);

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);

        System.out.println("Peek: " + heap.peek()); // 10
        System.out.println("Extract: " + heap.extractMax()); // 10
        System.out.println("Extract: " + heap.extractMax()); // 7
        System.out.println("Extract: " + heap.extractMax()); // 5
        System.out.println("Extract: " + heap.extractMax()); // 3

        tracker.reset();
    }

    private static void benchmark(PerformanceTracker tracker, int n) {
        System.out.println("\n(" + n + " elements)");
        MaxHeap heap = new MaxHeap(n, tracker);
        Random random = new Random();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            heap.insert(random.nextInt());
        }
        for (int i = 0; i < n; i++) {
            heap.extractMax();
        }
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;
        System.out.println("Execution time: " + timeMs + " ms");
        tracker.reset();
    }
}
