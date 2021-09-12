package com.codechef.dsa.learning.series.getting.started;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AllFactorsTest {
    @Test
    void testFactors() {
        List<Integer> factors = AllFactors.factors(100);
        Collections.sort(factors);
        assertEquals(Arrays.asList(1, 2, 4, 5, 20, 25, 50, 100), factors);
    }
}
