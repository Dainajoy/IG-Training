package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringLenGreaterThanThree {
    public static void main(String[] args) {
        List<String> stringList=new ArrayList<String>();
        stringList.add("seven") ;
        stringList.add("eight");
        stringList.add("one");
        stringList.add("four");
        stringList.add("five");
        System.out.println("Strings with length more than three:");
        stringList.stream().filter(x->x.length()>3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("Count of strings greater than three:"+
        stringList.stream().filter(x->x.length()>3).count());
    }

}
