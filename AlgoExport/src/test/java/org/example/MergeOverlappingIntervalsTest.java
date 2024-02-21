package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
class MergeOverlappingIntervalsTest {
    /**
     * Create the test class
     */
    private final MergeOverlappingIntervals classUnderTest = new MergeOverlappingIntervals();

    /**
     * Rigourous Test :-)
     */
    @ParameterizedTest
    @MethodSource("inputIntervals")
    public void testMergedResult(int[][] input, int[][] expectedResult) {
        var actualResult = classUnderTest.mergeOverlappingIntervals(input);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> inputIntervals() {
        int[][] input1 = {{1, 2}, {3, 8}, {9, 10}};
        int[][] result1 = {{1, 2}, {3, 8}, {9, 10}};
        int[][] input2 = {{1, 5}, {2, 4}, {5, 7}};
        int[][] result2 = {{1, 7}};
        int[][] input3 = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        int[][] result3 = {{1, 2}, {3, 8}, {9, 10}};
        int[][] input4 = {{-5, -4}, {-4, -3}, {-3, -2}, {-2, -1}, {-1, 0}};
        int[][] result4 = {{-5, 0}};
        int[][] input5 = {{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        int[][] result5 = {{1, 10}};
        return Stream.of(Arguments.of(input1, result1),
                Arguments.of(input2, result2),
                Arguments.of(input3, result3),
                Arguments.of(input4, result4),
                Arguments.of(input5, result5));
    }
}
