package com.shrvn.leetcode.easy.array;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] input = {0,1};
        System.out.println(solution.missingNumber(input));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int j = nums[0];
        for(int i = 0; i < nums.length; i++, j++){
            if(j != nums[i]){
                return j;
            }
        }
        return j;
    }
}
