package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class CountOfElements {
    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(3,6,2,8,9,567,5,2,9);
       int count= (int) intList.stream().count();
       System.out.println("Number of elements:"+count);
    }
}
