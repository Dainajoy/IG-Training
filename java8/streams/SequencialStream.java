package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class SequencialStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello ","w","o","r","l","d");
        list.stream().forEach(System.out::print);
    }
}
