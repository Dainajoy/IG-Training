package com.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class DistinctSalary {
    public static void main(String[] args) {
        List<Integer>salaryList=new ArrayList<>();
        salaryList.add(67000);
        salaryList.add(50000);
        salaryList.add(75329);
        salaryList.add(67000);
        salaryList.add(50000);
        salaryList.stream().distinct().forEach(System.out::println);
    }
}
