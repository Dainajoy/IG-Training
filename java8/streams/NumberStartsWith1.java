package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class NumberStartsWith1 {
    public static void main(String[] args) {
        List<Integer> inputList= Arrays.asList(12,6,3,5,19,11,80,193,102,147);
        System.out.println("Numbers starts with 1");
        inputList.stream().map(x->x+"").filter(i->i.startsWith("1")).forEach(System.out::println);
    }



}
