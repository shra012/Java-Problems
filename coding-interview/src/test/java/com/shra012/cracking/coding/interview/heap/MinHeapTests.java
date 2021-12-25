package com.shra012.cracking.coding.interview.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinHeapTests {
    private final MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

    @BeforeEach
    void setUp() throws HeapFullException {
        minHeap.add(9);
        minHeap.add(19);
        minHeap.add(29);
        minHeap.add(39);
        minHeap.add(49);
        minHeap.add(59);
        minHeap.add(69);
        System.out.println(minHeap);
    }

    @Test
    void shouldInsertValueIntoTheHeap() throws HeapFullException {
        Assertions.assertEquals(7, minHeap.getSize());
        minHeap.add(1);
        Assertions.assertEquals(8, minHeap.getSize());
    }

    @Test
    void shouldHaveTheSmallestValueAsThePriorityElement() throws HeapFullException, HeapEmptyException {
        minHeap.add(5);
        minHeap.add(200);
        Assertions.assertEquals(5, minHeap.getHighestPriority());
    }

    @Test
    void shouldThrowHeapFullExceptionWhenHeapIsFull() throws HeapFullException {
        minHeap.add(100);
        minHeap.add(200);
        minHeap.add(79);
        Assertions.assertThrows(HeapFullException.class, () -> minHeap.add(89));
    }

    @Test
    void shouldThrowHeapEmptyExceptionWhenHeapIsFull() {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, 1);
        Assertions.assertThrows(HeapEmptyException.class, minHeap::getHighestPriority);
    }

    @Test
    void shouldRemoveHighestPriorityElement() throws HeapEmptyException {
        Assertions.assertEquals(9, minHeap.removeHighestPriority());
        System.out.println(minHeap);
    }

    @Test
    void shouldRemoveHighestPriorityElementAndSiftDown() throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        Assertions.assertEquals(1, minHeap.removeHighestPriority());
        Assertions.assertEquals(2, minHeap.removeHighestPriority());
        Assertions.assertEquals(3, minHeap.removeHighestPriority());
    }

    @Test
    void shouldReturnFullIfTheHeapIsFull() throws HeapEmptyException, HeapFullException {
        minHeap.add(12);
        minHeap.add(24);
        minHeap.add(36);
        Assertions.assertTrue(minHeap.isFull());
        minHeap.removeHighestPriority();
        Assertions.assertFalse(minHeap.isFull());
    }

    @Test
    void shouldReturnNegativeOneIfInvalidIndexIsPassedToGetParentIndex() {
        Assertions.assertEquals(-1, minHeap.getParentIndex(-2));
    }

    @Test
    void shouldReturnNegativeOneIfInvalidIndexIsPassedToGetChildIndex() {
        Assertions.assertEquals(-1, minHeap.getLeftChildIndex(-2));
        Assertions.assertEquals(-1, minHeap.getRightChildIndex(-2));
    }
}
