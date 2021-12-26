package com.shra012.cracking.coding.interview.heap;

/**
 * This class implements Heap Sort algorithm. It is a in-place sorting algorithm.
 * Time complexity: O(n*log(n)), Space complexity: O(1).
 * It sorts the input array in ascending order.
 * Use the sort method to sort the input array.
 */
public class HeapSort {

    /**
     * Utility class. So overriding the constructor and throwing an unsupported operation exception.
     */
    private HeapSort() {
        throw new UnsupportedOperationException("This class is not meant to be instantiated");
    }

    /**
     * Gets the parent index of the given child index.
     *
     * @param index    the child index
     * @param endIndex the end index of the array
     * @return the parent index. -1 if the index is invalid.
     */
    private static int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }
        return (index - 1) / 2;
    }

    /**
     * Gets the left index of the given parent index.
     *
     * @param index    the parent index
     * @param endIndex the end index of the array
     * @return the left index. -1 if the index is invalid.
     */
    private static int getLeftIndex(int index, int endIndex) {
        int leftIndex = (index * 2) + 1;
        if (leftIndex > endIndex || leftIndex < 0) {
            return -1;
        }
        return leftIndex;
    }

    /**
     * Gets the right index of the given parent index
     *
     * @param index    the parent index
     * @param endIndex the end index of the array
     * @return the right index. -1 if the index is invalid.
     */
    private static int getRightIndex(int index, int endIndex) {
        int rightIndex = (index * 2) + 2;
        if (rightIndex > endIndex || rightIndex < 0) {
            return -1;
        }
        return rightIndex;
    }

    /**
     * Swap the elements at the given indices
     *
     * @param array  the array
     * @param first  the first index
     * @param second the second index
     */
    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Builds array heap from the given array. The heap is built in-place.
     *
     * @param array    the array
     * @param index    the current index
     * @param endIndex the index of the last element in the array
     */
    private static void percolateDown(int[] array, int index, int endIndex) {
        int rightIndex = getRightIndex(index, endIndex);
        int leftIndex = getLeftIndex(index, endIndex);
        int largerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            largerIndex = array[leftIndex] > array[rightIndex] ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            largerIndex = leftIndex;
        } else {
            largerIndex = rightIndex;
        }

        if (largerIndex == -1) {
            return;
        }

        if (array[largerIndex] > array[index]) {
            swap(array, largerIndex, index);
            percolateDown(array, largerIndex, endIndex);
        }
    }

    /**
     * Builds array heap from the given array. The heap is built in-place.
     *
     * @param array    the array on which heap is to be built
     * @param endIndex the index of the last element in the array
     */
    private static void heapify(int[] array, int endIndex) {
        int parentIndex = getParentIndex(endIndex, endIndex);

        while (parentIndex >= 0) {
            percolateDown(array, parentIndex, endIndex);
            parentIndex--;
        }
    }

    /**
     * Sorts the given array in ascending order.
     *
     * @param array the array to be sorted
     */
    public static void sort(int[] array) {
        int endIndex = array.length - 1;
        heapify(array, endIndex);
        while (endIndex > 0) {
            swap(array, 0, endIndex);
            endIndex--;
            percolateDown(array, 0, endIndex);
        }
    }
}
