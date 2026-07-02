package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals("5 + 3 should equal 8", 8, calculator.add(5, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals("10 - 4 should equal 6", 6, calculator.subtract(10, 4));
    }

    @Test
    public void testMultiply() {
        assertEquals("7 * 6 should equal 42", 42, calculator.multiply(7, 6));
    }

    @Test
    public void testDivide() {
        assertEquals("15 / 3 should equal 5", 5, calculator.divide(15, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);  // Should throw exception
    }
}