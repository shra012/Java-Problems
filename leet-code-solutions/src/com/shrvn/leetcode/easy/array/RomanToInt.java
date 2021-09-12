package com.shrvn.leetcode.easy.array;

public class RomanToInt {
    public int romanToInt(String s) {
        char[] c = s.toCharArray();
        int result = 0;
        int l = c.length;
        for (int i = 0; i < l; i++) {
            if ('I' == c[i]) {
                if (i + 1 < l && (c[i + 1] == 'V' || c[i + 1] == 'X')) {
                    result -= 1;
                } else {
                    result += 1;
                }
            }
            if ('V' == c[i]) {
                result += 5;
            }
            if ('X' == c[i]) {
                if (i + 1 < l && (c[i + 1] == 'L' || c[i + 1] == 'C')) {
                    result -= 10;
                } else {
                    result += 10;
                }
            }
            if ('L' == c[i]) {
                result += 50;
            }
            if ('C' == c[i]) {
                if (i + 1 < l && (c[i + 1] == 'D' || c[i + 1] == 'M')) {
                    result -= 100;
                } else {
                    result += 100;
                }
            }
            if ('D' == c[i]) {
                result += 500;
            }
            if ('M' == c[i]) {
                result += 1000;
            }
        }
        return result;
    }
}
