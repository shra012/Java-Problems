package com.shrvn.leetcode.easy.array;

import java.util.*;

public class DisplayDuplicates {

    public static void main(String[] args) {
        int[] duplicates = null;
        DisplayDuplicates displayDuplicates = new DisplayDuplicates();
        int[][] inputs = {
                {1},
                {1, 2},
                {1, 2, 3, 4, 5, 7, 8, 3},
                {2, 2, 3, 4, 5, 7, 8, 3},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        for (int[] input : inputs) {
            System.out.println("Duplicates in " + Arrays.toString(input) + " are Follows");
            duplicates = displayDuplicates.findDuplicatesWithArray(input);
            System.out.println(Arrays.toString(duplicates));
            duplicates = displayDuplicates.findDuplicatesWithSet(input);
            System.out.println(Arrays.toString(duplicates));
            duplicates = displayDuplicates.findDuplicatesWithMap(input);
            System.out.println(Arrays.toString(duplicates));
        }
    }

    // Time Complexity = O(N + N * N) => O(N * N^2) => Simplified to O(N^2), Space Complexity O(N) as we use ArrayList
    public int[] findDuplicatesWithArray(int[] a) {
        int len = a.length;
        Arrays.sort(a); // Sorting the array takes O(N) Time.
        List<Integer> duplicates = new ArrayList<>();
        for (int j = 1; j < len; j++) { // At worst case takes O(N) Time
            if (a[j - 1] == a[j] && !duplicates.contains(a[j])) { // contains check takes O(N)
                duplicates.add(a[j]);
            }
        }
        // Ignore the time take for conversion of List to int[]
        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    }

    // Time Complexity = O(N), Space Complexity O(N) + O(N) = O(2N) => Simplified to O(N) as we use two Sets
    public int[] findDuplicatesWithSet(int[] a) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int element : a) { // Single loop
            if (!set.add(element)) {
                duplicates.add(element);
            }
        }
        // Ignore the time take for conversion of Set to int[]
        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    }

    // Time Complexity = O(N), Space Complexity O(N) as we use Map
    public int[] findDuplicatesWithMap(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : a) { // Single loop
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
        // Ignore the time take for conversion of map to int[]
        return map.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
