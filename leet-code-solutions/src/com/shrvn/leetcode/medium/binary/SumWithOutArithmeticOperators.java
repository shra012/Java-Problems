package com.shrvn.leetcode.medium.binary;

/**
 * Sum two numbers with ou using Arithmetic Operators + - ++ and --
 * <br/>
 * <a href="https://en.wikipedia.org/wiki/Adder_%28electronics%29#Half_adder">Half Adder</a> Algorithm :
 * <br/>
 * sum = a ^ b
 * carry = a & b
 * return carry == 0 ? sum : add(sum, carry << 1)
 * <br/>
 * 1 Pass a = 10 , b = 2
 * sum = 10 ^ 2 = 1010 ^ 0010 = 1000 = 8
 * carry = 10 & 2 = 1010 & 0010 = 0010 = 2
 * 2 Pass a = 8 , b = 4
 * sum = 8 ^ 4 = 1000 ^ 0100 = 1100 = 12
 * carry = 8 & 4 = 1000 & 0100 = 0000 = 0
 * <br/>
 * Answer is 12
 */
public class SumWithOutArithmeticOperators {
    public static void main(String[] args) {
        SumWithOutArithmeticOperators sum = new SumWithOutArithmeticOperators();
        int a = 10; // 1010
        int b = 2; // 0010
        System.out.println(sum.add(a, b));
    }

    /**
     * Sum two numbers with ou using Arithmetic Operators + - ++ and --
     *
     * @param a first number to add
     * @param b second number to add
     * @return - Sum of the two inputs.
     */
    public int add(int a, int b) {
        int sum = a ^ b;
        int carry = a & b;
        return carry == 0 ? sum : add(sum, carry << 1);
    }
}
