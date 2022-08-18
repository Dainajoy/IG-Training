package com.java8.lambdaexpression;

import java.util.ArrayList;

public class LambdaExpressionWithForEach {
    public static void main(String[] args) {
        ArrayList<String> fruitlist = new ArrayList<String>();
        fruitlist.add("Mango");
        fruitlist.add("Banana");
        fruitlist.add("Watermelon");
        fruitlist.add("Orange");
        fruitlist.forEach((ls) -> System.out.println(ls));
    }
}
