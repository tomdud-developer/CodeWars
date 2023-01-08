package org.codewars.weightsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class WeightSort {
    public static String orderWeight(String strng) {
        if(strng.isEmpty()) return "";

        Long[] intArr = Arrays.stream(strng.split(" ")).filter(str -> !str.equals("")).map(s -> Long.parseLong(s)).toArray(Long[]::new);
        ArrayList<Long[]> pairs = new ArrayList<>();

        for(Long i : intArr) {
            long newWeight = Arrays.stream(String.valueOf(i).split("")).map(x -> Integer.parseInt(x)).reduce((sum, y) -> sum += y).get();
            Long[] pair = new Long[]{i, newWeight};
            pairs.add(pair);
        }

        class WeightsComparator implements Comparator<Long[]> {
            @Override
            public int compare(Long[] pair1, Long[] pair2) {
                if(pair1[1] == pair2[1]) {
                    String str1 = String.valueOf(pair1[0]);
                    String str2 = String.valueOf(pair2[0]);
                    return str1.compareTo(str2);
                } else if(pair1[1] > pair2[1])
                    return 1;
                else
                    return -1;
            }
        }

        Collections.sort(pairs, new WeightsComparator());
        String[] outArr = pairs.stream().map(v -> String.valueOf(v[0])).toArray(String[]::new);
        return String.join(" ", outArr);
    }
}