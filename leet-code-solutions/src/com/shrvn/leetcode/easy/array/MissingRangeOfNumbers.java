package com.shrvn.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingRangeOfNumbers {

    public static void main(String[] args) {
        MissingRangeOfNumbers sol = new MissingRangeOfNumbers();
        int[] arr = {2, 7, 10, 14, 16, 30, 37, 42, 46, 46, 53};
        System.out.println(sol.findMissing(arr, 11));
    }

    String findMissing(int[] arr, int n) {
        if (arr == null || n == 0 || arr.length != n) return null;
        Arrays.sort(arr);
        int ini = 0;
        ArrayList<String> result = new ArrayList<>();
        if (n == 1 && arr[0] > 0) {
            return ini + "-" + (arr[0] - 1);
        } else if (n == 1 && arr[0] == 0) {
            return "-1";
        }
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && arr[i] == arr[i + 1]) {
                continue;
            } else if (ini != arr[i]) {
                if (ini == arr[i] - 1) {
                    result.add("" + ini);
                } else {
                    result.add(ini + "-" + (arr[i] - 1));
                }
            }
            ini = arr[i] + 1;
        }
        if (result.isEmpty()) {
            result.add("" + ini);
        }
        return String.join(" ", result);
    }
}
