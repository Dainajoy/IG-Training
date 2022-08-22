package com.java.treeMap;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> lhm
                = new TreeMap<Integer, String>();
        lhm.put(23,"dsf");
        lhm.put(12,"sdd");
        lhm.put(54,"easd");
        lhm.put(10,"lkm");
        System.out.println(lhm);
    }
}
