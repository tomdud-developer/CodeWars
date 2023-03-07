package org.codewars.sum_strings_as_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SumStringsTest {

    @Test
    void sumStrings() {
        Assertions.assertEquals("3", SumStrings.sumStrings("1", "2"));
    }


    @Test
    void sumStrings2() {
        Assertions.assertEquals("18", SumStrings.sumStrings("12", "6"));
    }


    @Test
    void sumStrings3() {
        Assertions.assertEquals("24", SumStrings.sumStrings("18", "6"));
    }

    @Test
    void sumStrings4() {
        assertEquals("579", SumStrings.sumStrings("123", "456"));
    }

    @Test
    void sumStrings5() {
        assertEquals("8670", SumStrings.sumStrings("00103", "08567"));
    }

    @Test
    void sumStringsEmpty() {
        assertEquals("", SumStrings.sumStrings("", ""));
    }

    /*
    Incorrect answer for inputs:
a="0561704787871485377"
b="0218740008352274447661486412037"
 ==> expected: <218740008352836152449357897414> but was: <0218740008352836152449357897414>
     */
    @Test
    void sumStrings6() {
        assertEquals("218740008352836152449357897414", SumStrings.sumStrings("0561704787871485377", "0218740008352274447661486412037"));
    }

    @Test
    void reverseString() {
        Assertions.assertEquals("abcdef", SumStrings.reverseString("fedcba"));
        Assertions.assertEquals("abcdefg", SumStrings.reverseString("gfedcba"));
        Assertions.assertEquals("12", SumStrings.reverseString("21"));
    }

    @Test
    void removeTrailingZerosTest() {
        Assertions.assertEquals("103", SumStrings.removeTrailingZeros("00103"));
        Assertions.assertEquals("8567", SumStrings.removeTrailingZeros("08567"));
        Assertions.assertEquals("123", SumStrings.removeTrailingZeros("00123"));
    }


}