package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringWithComma {
    public static void main(String[] args) {
        List<String> inputString= Arrays.asList("Hai","World","Hello");
        String joinedString=inputString.stream().map(i->i.toUpperCase()).collect(Collectors.joining(","));
        System.out.println("Joined String:"+joinedString);

    }
}
