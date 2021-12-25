package com.shra012.cracking.coding.interview.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxHeapTests {
    private final MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);

    @BeforeEach
    void setUp() throws HeapFullException {
        maxHeap.add(9);
        maxHeap.add(19);
        maxHeap.add(29);
        maxHeap.add(39);
        maxHeap.add(49);
        maxHeap.add(59);
        maxHeap.add(69);
        System.out.println(maxHeap);
    }

    @Test
    void shouldInsertValueIntoTheHeap() throws HeapFullException {
        Assertions.assertEquals(7, maxHeap.getSize());
        maxHeap.add(100);
        Assertions.assertEquals(8, maxHeap.getSize());
    }

    @Test
    void shouldHaveTheLargestValueAsThePriorityElement() throws HeapFullException, HeapEmptyException {
        maxHeap.add(200);
        maxHeap.add(79);
        Assertions.assertEquals(200, maxHeap.getHighestPriority());
    }

    @Test
    void shouldThrowHeapFullExceptionWhenHeapIsFull() throws HeapFullException {
        maxHeap.add(100);
        maxHeap.add(200);
        maxHeap.add(79);
        Assertions.assertThrows(HeapFullException.class, () -> maxHeap.add(89));
    }

    @Test
    void shouldThrowHeapEmptyExceptionWhenHeapIsFull() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class, 1);
        Assertions.assertThrows(HeapEmptyException.class, maxHeap::getHighestPriority);
    }

    @Test
    void shouldRemoveHighestPriorityElement() throws HeapEmptyException {
        Assertions.assertEquals(69, maxHeap.removeHighestPriority());
        System.out.println(maxHeap);
    }

    @Test
    void shouldRemoveHighestPriorityElementAndSiftDown() throws HeapFullException, HeapEmptyException {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        Assertions.assertEquals(3, maxHeap.removeHighestPriority());
        Assertions.assertEquals(2, maxHeap.removeHighestPriority());
        Assertions.assertEquals(1, maxHeap.removeHighestPriority());
    }

    @Test
    void shouldReturnFullIfTheHeapIsFull() throws HeapEmptyException, HeapFullException {
        maxHeap.add(12);
        maxHeap.add(24);
        maxHeap.add(36);
        Assertions.assertTrue(maxHeap.isFull());
        maxHeap.removeHighestPriority();
        Assertions.assertFalse(maxHeap.isFull());
    }

    @Test
    void shouldReturnNegativeOneIfInvalidIndexIsPassedToGetParentIndex() {
        Assertions.assertEquals(-1, maxHeap.getParentIndex(-2));
    }

    @Test
    void shouldReturnNegativeOneIfInvalidIndexIsPassedToGetChildIndex() {
        Assertions.assertEquals(-1, maxHeap.getLeftChildIndex(-2));
        Assertions.assertEquals(-1, maxHeap.getRightChildIndex(-2));
    }
}
