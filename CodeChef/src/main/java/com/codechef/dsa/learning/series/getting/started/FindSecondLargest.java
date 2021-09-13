package com.codechef.dsa.learning.series.getting.started;

import java.util.Scanner;

public class FindSecondLargest {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            System.out.println(secondLargest(f, s, t));
        }
    }

    public static int secondLargest(int f, int s, int t) {
        if (f > s && f > t) {
            if (s > t) {
                return s;
            } else {
                return t;
            }
        } else if (s > f && s > t) {
            if (f > t) {
                return f;
            } else {
                return t;
            }
        } else {
            if (f > s) {
                return f;
            } else {
                return s;
            }
        }
    }
}
