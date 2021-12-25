package com.shra012.cracking.coding.interview.heap;

import java.lang.reflect.Array;

/**
 * Abstract Heap Class which can be extended further to create
 * maxheap and minheap.
 *
 * @param <T> - Generic Type.
 */
public abstract class Heap<T extends Comparable<T>> {
    private static final int MAX_SIZE = 10;
    private final T[] array;
    private int count = 0;

    protected Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    @SuppressWarnings("unchecked")
    protected Heap(Class<T> clazz, int size) {
        this.array = (T[]) Array.newInstance(clazz, size);
    }

    /**
     * Current Size of the heap.
     *
     * @return - int size.
     */
    public int getSize() {
        return count;
    }

    /**
     * To check if the heap is full.
     *
     * @return true when heap is full.
     */
    public boolean isFull() {
        return count == array.length;
    }

    /**
     * Finds the value at the index
     *
     * @param index - index of the element to be returned.
     * @return - Element at the given index.
     */
    public T get(int index) {
        return array[index];
    }

    /**
     * Given a parent index computes its left child index.
     *
     * @param parentIndex - parent index.
     * @return left child index.
     */
    public int getLeftChildIndex(int parentIndex) {
        if (parentIndex < 0) {
            return -1;
        }
        int leftChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }

    /**
     * Given a parent index computes its right child index.
     *
     * @param parentIndex - parent index.
     * @return right child index.
     */
    public int getRightChildIndex(int parentIndex) {
        if (parentIndex < 0) {
            return -1;
        }
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex >= count) {
            return -1;
        }
        return rightChildIndex;
    }

    /**
     * Given a child index computes its parent index.
     *
     * @param childIndex - child index.
     * @return parent index.
     */
    public int getParentIndex(int childIndex) {
        if (childIndex <= 0 || childIndex >= count) {
            return -1;
        }
        return (childIndex - 1) / 2;
    }

    /**
     * Swap the elements at the given indices.
     *
     * @param first  - first index
     * @param second - second index
     */
    protected void swap(int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * shifts the misplaced node from top to its correct position
     * in the bottom of the heap.
     *
     * @param index - misplaced nodes index.
     */
    protected abstract void siftDown(int index);

    /**
     * shifts the misplaced node from bottom to its correct position
     * in the top of the heap.
     *
     * @param index - misplaced nodes index.
     */
    protected abstract void siftUp(int index);

    /**
     * Gets the root element of the heap.
     *
     * @return the priority element
     * @throws HeapEmptyException - if the heap is empty exception is thrown.
     */
    public T getHighestPriority() throws HeapEmptyException {
        if (count == 0) {
            throw new HeapEmptyException("There are no elements in the heap...");
        }
        return array[0];
    }

    /**
     * inserts the given value in its correct position
     * inside the binary heap.
     *
     * @param value - value to be inserted.
     * @throws HeapFullException - exception is thrown when the heap is full.
     */
    public void add(T value) throws HeapFullException {
        if (count >= array.length) {
            throw new HeapFullException("No more space to add in the heap");
        }
        array[count] = value;
        count++;
        siftUp(count - 1);
    }

    /**
     * removes and returns the highest priority element.
     *
     * @return the value of the highest priority element
     * @throws HeapEmptyException exception is thrown when heap is empty.
     */
    public T removeHighestPriority() throws HeapEmptyException {
        T first = getHighestPriority();
        array[0] = array[count - 1];
        array[count - 1] = null;
        count--;
        siftDown(0);
        return first;
    }

    /**
     * The string representation of a heap.
     *
     * @return a string which draws a heap in a tree structure.
     */
    @Override
    public String toString() {
        return this.toString(0, new StringBuilder(), true, new StringBuilder()).toString();
    }


    /**
     * recursively builds a binary tree representation of a heap.
     *
     * @param index  - current index.
     * @param prefix - prefix string builder
     * @param isTail - indicates if it is tail node.
     * @param sb     - string builder which collects all the node values.
     * @return - a binary tree representation of the heap.
     */
    @SuppressWarnings("java:S3776")
    private StringBuilder toString(int index, StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (index != -1 && index < count) {
            int rightIndex = getRightChildIndex(index);
            int leftIndex = getLeftChildIndex(index);
            if (rightIndex != -1 && rightIndex < count) {
                String joining = isTail ? "│   " : "    ";
                toString(rightIndex, new StringBuilder().append(prefix).append(joining), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(array[index]).append("\n");
            if (leftIndex != -1 && leftIndex < count) {
                String joining = isTail ? "    " : "│   ";
                toString(leftIndex, new StringBuilder().append(prefix).append(joining), true, sb);
            }
        }
        return sb;
    }
}