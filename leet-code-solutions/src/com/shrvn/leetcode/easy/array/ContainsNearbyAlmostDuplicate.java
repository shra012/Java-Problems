package com.shrvn.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate sol = new ContainsNearbyAlmostDuplicate();
        int[] input = {1, 5, 9, 1, 5, 9};
        sol.containsNearbyAlmostDuplicateTreeSet(input, 2, 3);
    }

    public boolean containsNearbyAlmostDuplicateHashMap(int[] nums, int k, int t) {
        if (nums == null || k < 0 || t < 0) return false;
        Map<Integer, Integer> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            long t1 = (long) t + 1;
            int bucket = (int) Math.floorDiv(current, t1);
            if (buckets.containsKey(bucket)) return true;
            else {
                buckets.put(bucket, current);
                // Cast to long as it overflows if 2147483647 - (-1) => -2147483648
                if (buckets.containsKey(bucket - 1) && current - (long) buckets.get(bucket - 1) <= t) return true;
                if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - (long) current <= t) return true;
                if (buckets.size() > k) {
                    buckets.remove((int) Math.floorDiv(nums[i - k], t1));
                }
            }
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicateTreeSet(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i] + t);
            Long ceil = set.ceiling((long) nums[i] - t);
            if (floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) {
                return true;
            } else {
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
        }
        return false;
    }
}
