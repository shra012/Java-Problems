package com.shrvn.leetcode.easy.dynamicprogramming;

/**
 * Question Provider : Codility
 * <p>
 * A zero-indexed array 'a' consisting of 'n' integers is given.
 * The elements of array 'a' together represent a chain,
 * and each element represents the strength of each link in the chain.
 * We want to divide this chain into three smaller chains.
 * <p>
 * All we can do is to break the chain in exactly two non-adjacent positions.
 * More precisely, we should break links P, Q (0 < P < Q < N - 1, Q - P > 1),
 * resulting in three chains [0, P - 1], [P + 1, Q - 1], [Q + 1, N - 1].
 * The total cost of this operation is equal to a[P] + a[Q].
 * <p>
 * For example, consider array 'a' such that:
 * <p>
 * a[0] = 5
 * a[1] = 2
 * a[2] = 4
 * a[3] = 6
 * a[4] = 3
 * a[5] = 7
 * <p>
 * <p>
 * We can choose to break the following links:
 * <p>
 * (1, 3): total cost is 2 + 6 = 8
 * (1, 4): total cost is 2 + 3 = 5
 * (2, 4): total cost is 4 + 3 = 7
 * <p>
 * Write a function:
 * that, given a zero-indexed array 'a' of 'n' integers, returns the minimal cost of dividing chain into three pieces.
 * <p>
 * For example, given:
 * <p>
 * a[0] = 5
 * a[1] = 2
 * a[2] = 4
 * a[3] = 6
 * a[4] = 3
 * a[5] = 7
 * <p>
 * <p>
 * the function should return 5, as explained above.
 * <p>
 * Assume that:
 * <p>
 * 'n' is an integer within the range [ 5.. 100,000];
 * each element of array 'a' is an integer within the range [ 1.. 1,000,000,000].
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N),
 * beyond input storage (not counting the storage required for input arguments).
 * <p>
 * Elements of input arrays can be modified.
 */
public class WeakestChainLinks {
    public static void main(String[] args) {
        WeakestChainLinks sol = new WeakestChainLinks();
        //int[] input = {2, 5, 6, 6, 2, 1, 2, 9, 4, 6, 4, 7}; // expected Answer 4
        int[] input = {5, 2, 4, 6, 3, 7}; // expected Answer 5
        System.out.println(sol.weakestChainLinks(input));
    }

    /**
     * Finds the minimum chain sub chain where 0 < P < Q < n -1 && Q - P > 1
     * So it forms an array [0, P - 1], [P + 1, Q - 1], [Q + 1, N - 1]
     * cost = A[P] + A[Q]
     * Array = [5, 2, 4, 6,3, 7]
     * Possibility P = 1 Q = 3
     * - (1, 3): total cost is 2 + 6 = 8
     * Possibility P = 1 Q = 4
     * - (1, 4): total cost is 2 + 3 = 5
     * Possibility P = 2 Q = 4
     * - (2, 4): total cost is 4 + 3 = 7
     *
     * @param a - array - input
     * @return - the weakest possible link ie a[P] + a[Q]
     */
    public int weakestChainLinks(int[] a) {
        int answer = Integer.MAX_VALUE;
        int min = a[1];
        for (int i = 3; i < a.length - 1; i++) {
            min = Math.min(min, a[i - 2]);
            answer = Math.min(a[i] + min, answer);
        }
        return answer;
    }

}
