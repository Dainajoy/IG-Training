package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class FindFirstElement {
    public static void main(String[] args) {
        List<Integer>inptList= Arrays.asList(9,3,6,8,298);
        System.out.println("Find first element:");
        int firstElement=inptList.stream().findFirst().get();
        System.out.println(firstElement);
    }
}
