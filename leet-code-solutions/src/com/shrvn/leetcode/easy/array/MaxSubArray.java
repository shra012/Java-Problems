package com.shrvn.leetcode.easy.array;

public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray problem = new MaxSubArray();
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(problem.maxSubArraySum(input));
    }


    /**
     * Kadane's Algorithm - states that is to find the maximum sub array find the
     * max(current element or sum (max_so_far + current element))
     * and compare that with the max_so_far and update max_so_far with
     * current_max if the current_max is greater.
     *
     * @param nums - input array
     */
    public int maxSubArraySum(int[] nums) {
        int max_so_far = nums[0];
        int current_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current_max = Math.max(nums[i], (current_max + nums[i]));
            max_so_far = Math.max(max_so_far, current_max);
        }
        return max_so_far;
    }

    /**
     * Divide and conquer approach.
     *
     * @param nums - input array
     * @return - maximum value of sum of sub array elements.
     */
    public int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubArraySumRecursive(nums, 0, nums.length - 1);

    }

    /**
     * Recursion to solve the problem with divide and conquer.
     *
     * @param arr   - input array.
     * @param start - the starting index of the array.
     * @param end   - the end index of the array.
     * @return - maximum value of sum of sub array elements.
     */
    public int maxSubArraySumRecursive(int[] arr, int start, int end) {
        if (start == end)
            return arr[start];

        int mid = (start + end) / 2;
        return Math.max(
                Math.max(maxSubArraySumRecursive(arr, start, mid), maxSubArraySumRecursive(arr, mid + 1, end)),
                maxCrossingSum(arr, start, mid, end));
    }

    /**
     * Finds the sum of maximum continuous elements left side of the mid and right side of the mid
     * Example:
     * arr = {1,2,3,4}
     * mid is 1
     * left max is 2
     * right max is 4
     * sum is 6
     *
     * @param arr   - input array.
     * @param start - the starting index of the array.
     * @param mid   - the mid index of the array.
     * @param end   - the end index of the array.
     * @return sum of left and right consecutive maximums.
     */
    public int maxCrossingSum(int[] arr, int start, int mid, int end) {
        // loop left side of the mid to find continuous maximum.
        int sum = 0;
        int left_max = Integer.MIN_VALUE;
        for (int i = mid; i >= start; i--) {
            sum += arr[i];
            if (sum > left_max)
                left_max = sum;
        }

        // loop right side of the mid to find continuous maximum.
        sum = 0;
        int right_max = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= end; i++) {
            sum += arr[i];
            if (sum > right_max)
                right_max = sum;
        }
        return left_max + right_max;
    }

    public int bruteForceMaxSubArray(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Invalid Argument Array with no elements");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (nums[i] > max) {
                max = nums[i];
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


}
