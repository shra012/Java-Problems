package com.shra012.cracking.coding.interview.heap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    public MaxHeap(Class<T> clazz) {
        super(clazz);
    }

    public MaxHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    protected void siftDown(int index) {
        log.info("Sifting down: {}", get(index));
        int rightIndex = getRightChildIndex(index);
        int leftIndex = getLeftChildIndex(index);
        int largerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            T leftValue = get(leftIndex);
            T rightValue = get(rightIndex);
            largerIndex = (leftValue.compareTo(rightValue)) > 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            largerIndex = leftIndex;
        } else {
            largerIndex = rightIndex;
        }

        if (largerIndex == -1) {
            log.info("Stop sifting down, found position");
            return;
        }

        log.info("Larger child: {}", get(largerIndex));

        if (get(largerIndex).compareTo(get(index)) > 0) {
            swap(largerIndex, index);
            log.info("Swap : current - {} with actual {}", get(index), get(largerIndex));
            siftDown(largerIndex);
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
        if (get(index).compareTo(get(parentIndex)) > 0) {
            swap(parentIndex, index);
            log.info("Swap : current - {} with parent {}", get(index), get(parentIndex));
            siftUp(parentIndex);
        }
    }
}
