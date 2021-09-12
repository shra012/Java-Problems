package com.shrvn.manning.classic.problems.small;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci method = new Fibonacci();
        System.out.println(method.fibonacci(100));
    }

    public int fibonacci(int n) {
        return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
}
