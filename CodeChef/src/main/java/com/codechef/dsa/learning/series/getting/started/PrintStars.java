package com.codechef.dsa.learning.series.getting.started;

import java.util.Scanner;

public class PrintStars {
    public static void main(String[] args) {
        PrintStars ps = new PrintStars();
        try (Scanner sc = new Scanner(System.in)) {
            int input = sc.nextInt();
            ps.reverse(input);
            ps.forward(input);
        }
    }

    public void reverse(int input) {
        int max = input - 1;
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (j >= max) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
            max -= 1;
        }

    }

    public void forward(int input) {
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (j <= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}