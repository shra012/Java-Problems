package com.codechef.dsa.learning.series.getting.started;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsBothOrNotTest {
    @Test
    void shouldReturnBothWhenDivisibleByBoth() {
        String result = IsBothOrNot.isBothORNone(110);
        Assertions.assertEquals("BOTH", result);
    }

    @Test
    void shouldReturnOneWhenDivisibleByFive() {
        String result = IsBothOrNot.isBothORNone(25);
        Assertions.assertEquals("ONE", result);
    }

    @Test
    void shouldReturnOneWhenDivisibleByEleven() {
        String result = IsBothOrNot.isBothORNone(121);
        Assertions.assertEquals("ONE", result);
    }

    @Test
    void shouldReturnNoneWhenNotDivisibleByElevenAndFive() {
        String result = IsBothOrNot.isBothORNone(12);
        Assertions.assertEquals("NONE", result);
    }
}
