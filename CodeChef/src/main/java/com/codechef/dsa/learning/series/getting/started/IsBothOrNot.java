package com.codechef.dsa.learning.series.getting.started;

import java.util.Scanner;

public class IsBothOrNot {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int input = sc.nextInt();
            String result = isBothORNone(input);
            System.out.println(result);
        }
    }

    public static String isBothORNone(int input) {
        String result = null;
        if (input % 5 == 0 && input % 11 == 0) {
            result = "BOTH";
        } else if (input % 5 == 0 || input % 11 == 0) {
            result = "ONE";
        } else {
            result = "NONE";
        }
        return result;
    }
}
