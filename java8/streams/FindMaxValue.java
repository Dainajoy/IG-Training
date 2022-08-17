package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaxValue {
    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(3,6,2,8,9,567,5,2,9);
        System.out.println("Max value:"+intList.stream().sorted(Comparator.reverseOrder()).
                findFirst().get());
        System.out.println("Max value by max method:"+intList.stream().max(Integer::compare).get());
        System.out.println("Max value by max comparator method:"+intList.stream().max(Comparator.comparing(Integer::valueOf)).get());

    }
}
