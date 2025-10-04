// MaxHeap.java
// Simple Max-Heap implementation with performance tracking.

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
    private int[] heap;
    private int size;
    private final PerformanceTracker tracker;

    public MaxHeap(int capacity, PerformanceTracker tracker) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        heap = new int[capacity];
        size = 0;
        this.tracker = new PerformanceTracker();
        this.tracker.onAllocation();
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        tracker.addArrayAccess(1);
        size++;
        siftUp(size - 1);
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        tracker.addArrayAccess(1);
        return heap[0];
    }

    public int extractMax() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        tracker.addArrayAccess(2);
        size--;
        siftDown(0);
        return max;
    }


    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            tracker.addComparison();
            if (heap[index] > heap[parent]) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }


    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size) {
                tracker.addComparison();
                if (heap[left] > heap[largest]) largest = left;
            }
            if (right < size) {
                tracker.addComparison();
                if (heap[right] > heap[largest]) largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        tracker.addSwap();
        tracker.addArrayAccess(4);
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
            tracker.onAllocation();
        }
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public PerformanceTracker getTracker() { return tracker; }

    public boolean isValidHeap() {
        for (int i = 0; i < size; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < size && heap[i] < heap[left]) return false;
            if (right < size && heap[i] < heap[right]) return false;
        }
        return true;
    }
}

