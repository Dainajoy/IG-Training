package com.java8.lambdaexpression;


interface Sayable{
    public String say(String name);
}

public class LambdaExpressionWithSingleParameter{
    public static void main(String[] args) {

        // Lambda expression with single parameter.
        Sayable s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("Sam"));

        // You can omit function parentheses
        Sayable s2= name ->{
            return "Hello, "+name;
        };
        System.out.println(s2.say("Ram"));
    }
}