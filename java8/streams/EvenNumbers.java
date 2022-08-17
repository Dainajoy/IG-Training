package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(2,6,3,5,9,11,80,93,102,147);
        System.out.println("Even Numbers");
        intList.stream().filter(x->x%2==0).collect(Collectors.toList()).forEach(System.out::println);

    }
}
