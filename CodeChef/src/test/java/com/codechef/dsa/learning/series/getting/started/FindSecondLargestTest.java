package com.codechef.dsa.learning.series.getting.started;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FindSecondLargestTest {

    @ParameterizedTest
    @CsvSource({ "10,2,15", "10,15,2", "15,2,10", "15,10,2", "2,15,10", "2,10,15" })
    void testSecondLargest(int f, int s, int t) {
        int actual = FindSecondLargest.secondLargest(10, 2, 15);
        Assertions.assertEquals(10, actual);
    }
}
