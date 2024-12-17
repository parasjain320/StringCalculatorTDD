package com.stringcalculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.stringcalculator.StringCalculate;

public class StringCalculatorTest {

    private final StringCalculate calculator = new StringCalculate();

    // Input: “”, Output: 0
    @Test
    public void testAddEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    //Input: “1”, Output: 1
    @Test
    public void testAddSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    //Input: “1,5”, Output: 6
    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

    //Allow the add method to handle any amount of numbers
    @Test
    public void testAddMultipleNumbers() {
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    //Allow the add method to handle new lines between numbers (instead of commas). ("1\n2,3" should return 6)
    @Test
    public void testAddWithNewLine() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    //"//;\n1;2" where the delimiter is ";" should return 3.
    @Test
    public void testAddWithCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    // Calling add with a negative number will throw an exception
    @Test
    public void testAddWithNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertTrue(exception.getMessage().contains("Negative numbers not allowed: [-2, -4]"));
    }
}
