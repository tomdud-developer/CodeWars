package org.codewars.alphabetic_anagrams;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


public class AlphabeticAnagrams {

    public BigInteger listPosition(final String word) {
        if(word.length() == 1) return  BigInteger.ONE;

        //Count characters in word
        ArrayList<String> characters = new ArrayList<>();
        ArrayList<Integer> counters = new ArrayList<>();

        String[] sortedArray = word.split("");
        Arrays.sort(sortedArray);
        Arrays.stream(sortedArray).forEach(
                s -> {
                    if(!characters.contains(s)) {
                        characters.add(s);
                        counters.add(1);
                    } else {
                        int index = characters.indexOf(s);
                        counters.set(index, counters.get(index) + 1);
                    }
                }
        );

        BigInteger pk = factiorial(BigInteger.valueOf(word.length()));
        for(Integer c : counters)
            pk = pk.divide(factiorial(BigInteger.valueOf(c)));

        BigInteger pel = pk.divide(BigInteger.valueOf(word.length()));

        BigInteger result = BigInteger.ZERO;
        for(String s : sortedArray) {
            if(s.charAt(0) == word.charAt(0)) {
                break;
            } else {
                result = result.add(pel);
            }
        }


        return result.add(listPosition(word.substring(1)));
    }

     private BigInteger factiorial(BigInteger x) {
        if(x.equals(BigInteger.ZERO) || x.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else return x.multiply(factiorial(x.add(BigInteger.valueOf(-1))));
    }


}
