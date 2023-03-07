package org.codewars.sum_strings_as_number;


import java.util.Arrays;

public class SumStrings {

    public static String sumStrings(String str1, String str2) {
        //The idea is make traditional adding
        String[] cyphers1 = Arrays.stream(reverseString(removeTrailingZeros(str1)).split("")).filter(s -> !s.equals("")).toArray(String[]::new);
        String[] cyphers2 = Arrays.stream(reverseString(removeTrailingZeros(str2)).split("")).filter(s -> !s.equals("")).toArray(String[]::new);

        if(cyphers1.length == 0 && !(cyphers2.length == 0)) {
            return removeTrailingZeros(str2);
        } else if(cyphers2.length == 0 && !(cyphers1.length == 0)) {
            return removeTrailingZeros(str1);
        } else if(cyphers2.length == 0 && cyphers1.length == 0)
            return "";

        if(cyphers2.length > cyphers1.length) {
            String[] temp = cyphers1;
            cyphers1 = cyphers2;
            cyphers2 = temp;
        }

        //Result string builder
        StringBuilder stringBuilder = new StringBuilder("");

        int shiftValue = 0;
        for( int i = 0; i < cyphers1.length; i++) {
            int x1 = Integer.parseInt(cyphers1[i]);
            int x2 = 0;
            if(!(i >= cyphers2.length)) x2 = Integer.parseInt(cyphers2[i]);

            int result = x1 + x2 + shiftValue;
            shiftValue = 0;

            if(result - 9 > 0) {
                shiftValue = result / 10;
                result -= (shiftValue * 10);
            }
            stringBuilder.append(result);
        }

        if(shiftValue > 0) stringBuilder.append(shiftValue);

        return stringBuilder.reverse().toString();
    }


    public static String reverseString(String str) {
        String[] strs = str.split("");

        for(int i = 0; i < strs.length/2; i++) {
            String temp = strs[i];
            strs[i] = strs[strs.length - i - 1];
            strs[strs.length - i - 1] = temp;
        }

        return String.join("",strs);
    }

    public static String removeTrailingZeros(String str) {
        int index = 0;
        for (String s : str.split("")) {
            if(s.equals("0")) index++;
            else break;
        }

        return str.substring(index);
    }
}
