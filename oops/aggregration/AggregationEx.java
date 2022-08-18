package com.java.aggregration;

class Square{
    int square(int n){
        return n*n;
    }
}
public class AggregationEx  extends Square{
Square cu;//Aggregation

    double pi=3.14;

    double area(int radius) {
        cu = new Square();
        int rsquare = cu.square(radius);//code reusability (i.e. delegates the method call).
        return pi * rsquare;
    }
        public static void main(String args[]){
            AggregationEx c=new AggregationEx();
            double result=c.area(5);
            System.out.println(result);
        }
    }
