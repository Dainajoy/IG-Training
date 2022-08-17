package com.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class StringStartsWith_A {
    public static void main(String[] args) {
        List<String> stringList=new ArrayList<String>();
        stringList.add("seven") ;
        stringList.add("eight");
        stringList.add("one");
        stringList.add("Aron");
        stringList.add("four");
        stringList.add("five");
        stringList.add("amal");
        System.out.println("Count of strings starts with A:"+stringList.stream().
                map(x->x.toUpperCase()).filter(x->x.startsWith("A")).count());
    }
}
