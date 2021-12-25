package com.shra012.cracking.coding.interview.heap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    protected MinHeap(Class<T> clazz) {
        super(clazz);
    }

    protected MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    protected void siftDown(int index) {
        log.info("Sifting down: {}", get(index));
        int rightIndex = getRightChildIndex(index);
        int leftIndex = getLeftChildIndex(index);
        int smallerIndex = -1;
        if (rightIndex != -1 && leftIndex != -1) {
            T rightValue = get(rightIndex);
            T leftValue = get(leftIndex);
            smallerIndex = (leftValue.compareTo(rightValue) < 0) ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else {
            smallerIndex = rightIndex;
        }
        if (smallerIndex == -1) {
            log.info("Stop sifting down, found position");
            return;
        }
        log.info("Smaller child: {}", get(smallerIndex));
        if (get(smallerIndex).compareTo(get(index)) < 0) {
            swap(smallerIndex, index);
            log.info("Swap : current - {} with actual {}", get(index), get(smallerIndex));
            siftDown(smallerIndex);
        }
    }

    @Override
    protected void siftUp(int index) {
        log.info("Sifting up: {}", get(index));
        int parentIndex = getParentIndex(index);
        if (parentIndex == -1) {
            log.info("Stop sifting up, found position");
            return;
        }
        log.info("Parent : {}", get(parentIndex));
        T childValue = get(index);
        T parentValue = get(parentIndex);
        if (childValue.compareTo(parentValue) < 0) {
            swap(parentIndex, index);
            log.info("Swap : current - {} with parent {}", get(index), get(parentIndex));
            siftUp(parentIndex);
        }

    }
}
