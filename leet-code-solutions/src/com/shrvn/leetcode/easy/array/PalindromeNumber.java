package com.shrvn.leetcode.easy.array;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();
        System.out.println(sol.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        int result = 0;
        int i = 0;
        int original = x;
        while (x > 0) {
            result *= 10;
            result += (x % 10);
            x = x / 10;
            i++;
        }
        return result == original;
    }
}
