package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class EmptyString {
    public static void main(String[] args) {
        List<String> stringList= Arrays.asList("ded","","ghj","sads","","","");
        System.out.println("Count of Empty String:"+
        stringList.stream().filter(x->x.isEmpty()).count());
    }
}
