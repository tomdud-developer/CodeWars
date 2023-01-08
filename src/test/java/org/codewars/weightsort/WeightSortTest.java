package org.codewars.weightsort;

import org.codewars.weightsort.WeightSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeightSortTest {


    @Test
    void orderWeight() {
        Assertions.assertEquals("100 180 90 56 65 74 68 86 99", WeightSort.orderWeight("56 65 74 100 99 68 86 180 90"));
    }

}