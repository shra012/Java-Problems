package com.shrvn.leetcode.medium.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDeletionsMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        MinimumDeletionsMakeCharacterFrequenciesUnique sol = new MinimumDeletionsMakeCharacterFrequenciesUnique();
        String str = "example";

        // Stores length of str
        int N = str.length();
        System.out.println(sol.minDeletions(str));
    }

    public int solve(char[] str, int N) {
        {
            // Stores frequency of each
            // distinct character of str
            HashMap<Character, Integer> mp = new HashMap<>();

            // Store frequency of each distinct
            // character such that the largest
            // frequency is present at the top
            PriorityQueue<Integer> pq =
                    new PriorityQueue<>((x, y) ->
                            Integer.compare(y, x));

            // Stores minimum count of characters
            // required to be deleted to make
            // frequency of each character unique
            int cntChar = 0;

            // Traverse the String
            for (int i = 0; i < N; i++) {
                // Update frequency of str[i]
                if (mp.containsKey(str[i])) {
                    mp.put(str[i],
                            mp.get(str[i]) + 1);
                } else {
                    mp.put(str[i], 1);
                }
            }

            // Traverse the map
            for (Map.Entry<Character,
                    Integer> it :
                    mp.entrySet()) {
                // Insert current
                // frequency into pq
                pq.add(it.getValue());
            }

            // Traverse the priority_queue
            while (!pq.isEmpty()) {
                // Stores topmost
                // element of pq
                int frequent = pq.peek();

                // Pop the topmost element
                pq.remove();

                // If pq is empty
                if (pq.isEmpty()) {

                    // Return cntChar
                    return cntChar;
                }

                // If frequent and topmost
                // element of pq are equal
                if (frequent == pq.peek()) {
                    // If frequency of the topmost
                    // element is greater than 1
                    if (frequent > 1) {
                        // Insert the decremented
                        // value of frequent
                        pq.add(frequent - 1);
                    }

                    // Update cntChar
                    cntChar++;
                }
            }
            return cntChar;
        }
    }

    public int minDeletions(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;//count frequency
        }
        HashSet<Integer> freq = new HashSet<>();
        int del = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != 0 && freq.contains(arr[i]))//if set already contains that frequency then deletion is performed and frequency of that character will be reduced so arr[i]--,del++
            {
                arr[i]--;
                del++;
            }
            freq.add(arr[i]);
        }
        return del;
    }
}
