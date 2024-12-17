package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculate {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                negatives.add(number);
            }
            sum += number;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                "Negative numbers not allowed: " + negatives.toString()
            );
        }

        return sum;
    }
}
