package com.shrvn.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {


    public int[] bruteForceTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] bestSolutionTwoSum(int[] nums, int target) {
        Map<Integer , Integer> store = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(store.containsKey(compliment) && store.get(compliment) != i){
                return new int[] {i, store.get(compliment)};
            }
            store.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int [] nums = {2,7,5,3,4};
        int target = 6;

        TwoSums twoSums = new TwoSums();
        int[] result = twoSums.bestSolutionTwoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
