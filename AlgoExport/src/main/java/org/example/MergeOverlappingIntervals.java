package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Note that [1,5] and [6,7] are not overlapping whereas [1,6] and [6,7] are overlapping.
 * input = [[1,2], [3,5], [4,7], [6,8], [9,10]]
 * output [[1,2], [3,8], [9,10]]
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        MergeOverlappingIntervals main = new MergeOverlappingIntervals();
        //int[][] input = {{1, 2},  {3, 8}, {9, 10}};
        //int[][] input = {{1, 5},  {2, 4}, {6, 7}};
        int[][] input = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        //int[][] input = {{-5, -4}, {-4, -3}, {-3, -2}, {-2, 1}, {-1, 0}};
        //int[][] input = {{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        var arr = main.mergeOverlappingIntervals(input);
        System.out.println(Arrays.deepToString(arr));
    }

    static class Intervals {
        int first;
        int second;
        public Intervals(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        var sorted = Arrays.stream(intervals)
                .map(i -> new Intervals(i[0], i[1]))
                .sorted(Comparator.comparingInt(a -> a.first))
                .toList();
        var merged = new ArrayList<Intervals>();
        var current = sorted.get(0);
        merged.add(current);
        for(int i = 1; i < sorted.size(); i++){
            var next = sorted.get(i);
            if(current.second >= next.first) {
                current.second = Integer.max(current.second, next.second);
            } else {
                current = next;
                merged.add(current);
            }
        }
        return merged.stream().map(in -> new int[]{in.first,in.second}).toArray(int[][]::new);
    }
}
