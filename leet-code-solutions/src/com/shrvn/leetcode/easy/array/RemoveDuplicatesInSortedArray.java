package com.shrvn.leetcode.easy.array;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray sol = new RemoveDuplicatesInSortedArray();
        int[] input = {1, 1, 1, 2};
        System.out.println(sol.removeDuplicates(input));
        System.out.println(Arrays.toString(input));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
