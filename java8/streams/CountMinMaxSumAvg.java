package com.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class CountMinMaxSumAvg {
    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(2,6,3,4,8);
        IntSummaryStatistics summaryStat=intList.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(""+summaryStat);
    }
}
