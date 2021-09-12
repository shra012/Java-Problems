package com.shrvn.leetcode.easy.binary;


public class NumberOfOneBits {

    /**
     * O(logn) as it used n & (n - 1) to remove the right most bit to zero
     *
     * Stimulation : n = 5  101
     * n = n & (n -1)
     * n = 5 & 4 = 101 & 100 = 100   count = 1
     * n = 4 & 3 = 100 & 011 = 0 000 count = 1
     * Answer = 2
     * <p>
     * Stimulation : n = 21 10101
     * n = n & (n -1)
     * n = 21 & 20 = 10101 & 10100 = 20 10100    count = 1
     * n = 20 & 19 = 10100 & 10011 = 16 10000    count = 1
     * n = 16 & 15 = 10000 & 01111 = 0 00000     count = 1
     * Answer = 3
     * @param n - the octal literal
     * @return - hamming weight or sum of the bits.
     */
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    /**
     * O(n) solution.
     * We divide the number by 2 to find
     *
     * @param n - the octal literal
     * @return - hamming weight or sum of the bits.
     */
    public int hammingWeightBruteForce(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n % 2;
            n /= 2;
        }
        return ans;
    }

    /**
     * O(n) cool solution.
     * We divide the number by 2 to find
     *
     * @param n - the octal literal
     * @return - hamming weight or sum of the bits.
     */
    public int hammingWeightConstantTime(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        System.out.println(numberOfOneBits.hammingWeight(10));
    }
}
