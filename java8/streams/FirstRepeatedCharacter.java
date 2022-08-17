package com.java8.streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        String inputStr="sdnkjwhdbcsnm";
        Character repeatedChar=inputStr.chars().
                mapToObj(i->Character.toLowerCase(Character.valueOf((char)i)))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1).findFirst().get().getKey();
        System.out.println("First Repeated character:"+repeatedChar);
    }
}
