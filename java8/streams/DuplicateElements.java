package com.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void main(String[] args) {
        List<Integer> inputList= Arrays.asList(2,8,3,6,4,8,6,6,6);
        System.out.println("Duplicate elements");
        Set<Integer> intSet=new HashSet<>();
        //inputList.stream().filter(x->!intSet.add(x)).collect(Collectors.toSet()).forEach(System.out::println);
        inputList.stream().filter(i->Collections.frequency(inputList,i)>1).collect(Collectors.toSet()).
                forEach(System.out::println);
    }
}
