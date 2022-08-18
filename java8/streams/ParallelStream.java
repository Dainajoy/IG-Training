package com.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello ","w","o","r","l","d");
        list.parallelStream().forEach(System.out::print);
    }
}
