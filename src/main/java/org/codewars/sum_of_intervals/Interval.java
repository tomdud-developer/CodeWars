package org.codewars.sum_of_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Interval {

    public static int sumIntervals(int[][] array) {
        System.out.println(Arrays.deepToString(array));
        if(array.length == 0) return 0;
        class IntervalsComparator implements Comparator<Integer[]> {
            @Override
            public int compare(Integer[] pair1, Integer[] pair2) {
                if(pair1[0] == pair2[0]) {
                    if(pair1[1] > pair2[1])
                        return 1;
                    else
                        return -1;
                }
                else if(pair1[0] > pair2[0])
                    return 1;
                else
                    return -1;
            }
        }
        Integer[][] intervals = Stream.of(array).map(a -> IntStream.of(a).boxed().toArray(Integer[]::new)).toArray(Integer[][]::new);
        Arrays.sort(intervals, new IntervalsComparator());
        System.out.println(Arrays.deepToString(intervals));
        int distance = 0;
        int i;
        for(i = 1; i < intervals.length; i++){
            if(intervals[i-1][1] > intervals[i][0] && intervals[i-1][1] > intervals[i][1]) {
                int temp = intervals[i][1];
                intervals[i][1] = intervals[i - 1][1];
                intervals[i - 1][1] = temp;
            }
            if(intervals[i-1][1] > intervals[i][0] && intervals[i-1][1] <= intervals[i][1]) {
                intervals[i-1][1] = intervals[i][0];
            }
            //interval i-1 is properly at this moment, we can calculate distance
            distance += intervals[i-1][1] - intervals[i-1][0];
        }
        //add last distance
        distance += intervals[i-1][1] - intervals[i-1][0];

        System.out.println(Arrays.deepToString(intervals));

        return distance;
    }

    public static int sumIntervalsToSlow(int[][] intervals) {
        System.out.println(Arrays.deepToString(intervals));
        if(intervals.length == 0) return 0;
        //find max and min value
        int max = intervals[0][1];
        int min = intervals[0][0];

        for(int i = 1; i < intervals.length; i++){
            if(max < intervals[i][1]) max = intervals[i][1];
            if(min > intervals[i][0]) min = intervals[i][0];
        }

        int distance = 0;
        for(int x = min; x <= max; x++)
            for(int i = 0; i < intervals.length; i++)
                if(x >= intervals[i][0] && x < intervals[i][1]) {
                    distance += 1;
                    break;
                }

        return distance;
    }




}
