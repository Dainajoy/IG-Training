package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquaresOfDistinctElement {
    public static void main(String[] args) {
        List<Integer>intList= Arrays.asList(2,6,3,4,8,2);
        List<Integer>squaresList=intList.stream().distinct().map(i->i*i).collect(Collectors.toList());
        System.out.println("squareList:"+squaresList);
    }
}
