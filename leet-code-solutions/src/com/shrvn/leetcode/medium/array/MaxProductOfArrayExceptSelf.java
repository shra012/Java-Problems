package com.shrvn.leetcode.medium.array;

import java.util.Arrays;

public class MaxProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = new MaxProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            answer[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            answer[i] *= tmp;
            tmp *= nums[i];
        }
        return answer;
    }
}
