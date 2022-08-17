package com.java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortValuesInList {
    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(36,6,2,8,9,567,5);
        System.out.println("Increasing Order:");
        intList.stream().sorted().forEach(System.out::println);
        System.out.println("Reverse Order Sort");
        intList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
