package com.shrvn.leetcode.easy.binary;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        System.out.println(Integer.toBinaryString(solution.reverseBits(3)));
    }

    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 31; i >= 0 && n != 0; i++) {
            reverse += (n & 1) << i;
            n >>= 1;
        }
        return  reverse;
    }
}
