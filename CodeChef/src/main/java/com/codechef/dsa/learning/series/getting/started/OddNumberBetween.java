package com.codechef.dsa.learning.series.getting.started;

import java.util.Scanner;

public class OddNumberBetween {
    private static final Character SPACE = ' ';

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            String oddNumbers = printOddNumbers(s, e);
            System.out.println(oddNumbers);
        }
    }

    public static String printOddNumbers(int s, int e) {
        StringBuilder sb = new StringBuilder();
        for (int i = s; i <= e; i++) {
            if (i % 2 != 0) {
                sb.append(i);
                sb.append(SPACE);
            }
        }
        if (sb.charAt(sb.length() - 1) == SPACE) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
