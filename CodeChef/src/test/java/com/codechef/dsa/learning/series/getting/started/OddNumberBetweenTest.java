package com.codechef.dsa.learning.series.getting.started;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OddNumberBetweenTest {

    @Test
    void testPrintOddNumbersBetween() {
        String actual = OddNumberBetween.printOddNumbers(10, 20);
        Assertions.assertEquals("11 13 15 17 19", actual);
    }
}
