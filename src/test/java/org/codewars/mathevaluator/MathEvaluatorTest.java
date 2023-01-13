package org.codewars.mathevaluator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathEvaluatorTest {

    @Test public void testAddition() {
        assertEquals(new MathEvaluator().calculate("-1+1"), 0.0, 0.01);
    }

    @Test public void testSubtraction() {
        assertEquals(new MathEvaluator().calculate("1 - 1"), 0d, 0.01);
    }

    @Test public void testMultiplication() {
        assertEquals(new MathEvaluator().calculate("1* 1"), 1d, 0.01);
    }

    @Test public void testDivision() {
        assertEquals(new MathEvaluator().calculate("1 /1"), 1d, 0.01);
    }

    @Test public void testNegative() {
        assertEquals(new MathEvaluator().calculate("-123"), -123d, 0.01);
    }

    @Test public void testLiteral() {
        assertEquals(new MathEvaluator().calculate("123"), 123d, 0.01);
    }

    @Test public void testComplex() {
        assertEquals(new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }

    @Test public void test() {
        String str = "1";
        //System.out.println(str.contains(new C));
    }

    @Test public void isNumeric() {
        assertEquals(true, new MathEvaluator().isNumeric("1"));
        assertEquals(false, new MathEvaluator().isNumeric("16546456g"));
        assertEquals(false, new MathEvaluator().isNumeric("1-56"));
        assertEquals(true, new MathEvaluator().isNumeric("-16546456"));
    }

    @Test
    void trivialCalculate() {
        assertEquals(2.5, new MathEvaluator().trivialCalculate(1.0, "+", 1.5));
        assertEquals(350.0, new MathEvaluator().trivialCalculate(5.0, "*", 70.0));
        assertEquals(1.1, new MathEvaluator().trivialCalculate(5.5, "/", 5.0));
        assertEquals(-499.0, new MathEvaluator().trivialCalculate(1.0, "-", 500.0));
    }

    @Test
    void reverseString() {
        assertEquals("54321", new MathEvaluator().reverseString("12345"));
        assertEquals("654321", new MathEvaluator().reverseString("123456"));
        assertEquals("1", new MathEvaluator().reverseString("1"));
        assertEquals("12", new MathEvaluator().reverseString("21"));
    }

    @Test
    void stringReplacer() {
        assertEquals("abXg", new MathEvaluator().stringReplacer("abcdefg", 2, 5, "X"));
    }


    @Test
    void commonExpressionReducer() {
        assertEquals("1.0+0.4", new MathEvaluator().commonExpressionReducer("1/1+2/5", true));
    }
}