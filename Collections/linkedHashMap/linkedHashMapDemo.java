package com.java.linkedHashMap;

import java.util.LinkedHashMap;

public class linkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lhm
                = new LinkedHashMap<Integer, String>();
        lhm.put(23,"dsf");
        lhm.put(12,"sdd");
        lhm.put(54,"easd");
        lhm.put(10,"lkm");
        System.out.println(lhm);
    }
}
