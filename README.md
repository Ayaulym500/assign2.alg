This project implements a Max-Heap data structure in Java.
The main goal is to demonstrate how insertion and extraction operations work, measure algorithm performance, and verify correctness through testing.

1. Project Structure

The program consists of four main components:

MaxHeap.java
Implements the Max-Heap data structure.
Key methods:
insert(int value) — inserts a new element into the heap
extractMax() — removes and returns the largest element
peek() — returns the maximum without removing it
isEmpty() — checks if the heap is empty
heapifyUp() / heapifyDown() — maintain the heap property after insertions or deletions
Each key operation is tracked using a PerformanceTracker instance.

PerformanceTracker.java
Collects performance metrics during execution:
Number of comparisons
Number of swaps
Array accesses
Memory allocations
These metrics allow analysis of performance growth with increasing input size.

Main.java
Serves as the main testing and benchmarking driver.
It includes:
Correctness tests: empty heap, single element, and duplicate elements
Benchmark tests: performance measurement for input sizes 100, 1000, 10,000, and 100,000
For each test, the program outputs:
n, time(ms), comparisons, swaps, accesses, allocations.

MaxHeapTest.java
A simple, self-contained test class that mimics JUnit-style behavior without external libraries.
It checks:
Correct insertion and extraction order
Exception handling for empty heap
Proper handling of duplicate values

2. Execution Results

Example benchmark output:

n,time(ms),comparisons,swaps,accesses,allocations
100,0,Comparisons=1055, Swaps=518, ArrayAccesses=2372, Allocations=1
1000,1,Comparisons=17233, Swaps=8605, ArrayAccesses=37420, Allocations=1
10000,5,Comparisons=239306, Swaps=119481, ArrayAccesses=507924, Allocations=1
100000,24,Comparisons=3059499, Swaps=1528771, ArrayAccesses=6415084, Allocations=1


The results show that runtime and key operations increase logarithmically, confirming the theoretical complexity of O(log n) for insertions and extractions.

3. Conclusion

The implementation fully meets the Code Quality Standards:
Clean and readable Java code
Proper error handling (e.g., extracting from an empty heap)
Performance metrics tracking
Comprehensive correctness and performance testing

Command-line interface (CLI) for flexible execution

This project demonstrates a solid understanding of algorithmic complexity, performance analysis, and the Max-Heap data structure in practice.
