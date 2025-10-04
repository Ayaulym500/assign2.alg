

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long allocations = 0;

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess(long n) { arrayAccesses += n; }
    public void onAllocation() { allocations++; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        allocations = 0;
    }

    @Override
    public String toString() {
        return "Comparisons=" + comparisons +
                ", Swaps=" + swaps +
                ", ArrayAccesses=" + arrayAccesses +
                ", Allocations=" + allocations;
    }
}

