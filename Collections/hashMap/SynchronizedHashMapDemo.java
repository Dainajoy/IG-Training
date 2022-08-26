package com.java.hashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer,String> laptopmap = new HashMap<Integer,String>();
        laptopmap.put(1,"IBM");
        laptopmap.put(2,"Dell");
        laptopmap.put(3,"HCL");
        // create a synchronized map
        Map<Integer,String> syncmap = Collections.synchronizedMap(laptopmap);

        System.out.println("Synchronized map is : "+syncmap);
    }

}
