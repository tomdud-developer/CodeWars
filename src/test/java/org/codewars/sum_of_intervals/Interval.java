package org.codewars.sum_of_intervals;



import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


    @Test
    public void shouldHandleEmptyIntervals() {
        assertEquals(0, sumIntervals(new int[][]{}));
        assertEquals(0, sumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));
    }

    @Test
    public void shouldAddDisjoinedIntervals() {
        assertEquals(9, sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
        assertEquals(11, sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
        assertEquals(7, sumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
        assertEquals(78, sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
    }

    @Test
    public void shouldHandleLargeIntervals() {
        assertEquals(2_000_000_000, sumIntervals(new int[][]{{-1_000_000_000, 1_000_000_000}}));
        assertEquals(100_000_030, sumIntervals(new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}}));
    }

    @Test
    public void shouldAddAdjacentIntervals() {
        assertEquals(54, sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
        assertEquals(23, sumIntervals(new int[][]{{-2, -1}, {-1, 0}, {0, 21}}));
    }

    @Test
    public void shouldAddOverlappingIntervals() {
        assertEquals(7, sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
        assertEquals(6, sumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
        assertEquals(19, sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
    }

    @Test
    public void shouldHandleMixedIntervals() {
        assertEquals(13, sumIntervals(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}));
        assertEquals(1234, sumIntervals(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));
        assertEquals(158, sumIntervals(new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},}));
    }

}
