package org.codewars.alphabetic_anagrams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class AlphabeticAnagramsTest {

    @Test
    void listPosition() {
        AlphabeticAnagrams alphabeticAnagrams = new AlphabeticAnagrams();

        Assertions.assertEquals(BigInteger.valueOf(10743), alphabeticAnagrams.listPosition("BOOKKEEPER"));
        //Position for 'IMMUNOELECTROPHORETICALLY' incorrect expected:<718393983731145698173> but was:<371258247204862>
        Assertions.assertEquals(new BigInteger("718393983731145698173"), alphabeticAnagrams.listPosition("IMMUNOELECTROPHORETICALLY"));
    }
}