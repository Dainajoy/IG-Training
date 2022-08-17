package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStringsMoreThanTwoCharacter {
    public static void main(String[] args) {
        List<String>stringInput= Arrays.asList("Book","Note","Paper","An","On","dsf");
        stringInput.stream().filter(x->x.length()>2).collect(Collectors.toList()).
                forEach(System.out::println);

    }
}
