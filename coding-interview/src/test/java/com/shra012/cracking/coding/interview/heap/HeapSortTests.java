package com.shra012.cracking.coding.interview.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

class HeapSortTests {

    @Test
    void shouldSortArray() {
        int[] array = new int[1_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        int[] expected = Arrays.copyOf(array, array.length);
        Instant start = Instant.now();
        HeapSort.sort(array);
        Instant end = Instant.now();
        System.out.println("Time taken: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");
        Instant start1 = Instant.now();
        Arrays.sort(expected);
        Instant end1 = Instant.now();
        System.out.println("Time taken: " + (end1.toEpochMilli() - start1.toEpochMilli()) + " ms");
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void shouldNotFailWhenEmptyArrayIsPassed(){
        int[] array = new int[0];
        HeapSort.sort(array);
        Assertions.assertArrayEquals(new int[0], array);
    }

    @Test
    @SuppressWarnings("java:S5778")
    void shouldThrowExceptionWhenClassIsInitialized() {
        Constructor<?> constructor = Arrays.stream(HeapSort.class.getDeclaredConstructors()).findFirst().orElse(null);
        if(Objects.nonNull(constructor)){
            constructor.setAccessible(true);
            Assertions.assertThrows(UnsupportedOperationException.class, () -> {
                try{
                    constructor.newInstance();
                }catch (InvocationTargetException e){
                    throw e.getCause();
                }
            });
        }else {
            Assertions.fail();
        }
    }
}
