package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveEmptyString {
    public static void main(String[] args) {
        List<String>stringInput= Arrays.asList("","ram","","joe","yam","");
        List<String>withoutEmpty=stringInput.stream().
                filter(x->!x.isEmpty()).collect(Collectors.toList());
        System.out.println(withoutEmpty);


    }
}
