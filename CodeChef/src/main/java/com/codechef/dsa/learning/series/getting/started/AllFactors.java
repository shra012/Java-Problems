package com.codechef.dsa.learning.series.getting.started;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllFactors {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int input = sc.nextInt();
            List<Integer> factors = factors(input);
            System.out.println(factors.size());
            Collections.sort(factors);
            print(factors);
        }
    }

    public static List<Integer> factors(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("input should be greater than zero");
        }
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(input); i++) {
            if (input % i == 0) {
                // avoiding duplicates example if input is 100 and factors (10, 10)
                if (input / i == i) {
                    factors.add(i);
                } else {
                    factors.add(input / i);
                    factors.add(i);
                }
            }
        }
        return factors;
    }

    public static void print(List<Integer> factors) {
        for (int i = 0; i < factors.size(); i++) {
            System.out.print(factors.get(i));
            if (i < factors.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
