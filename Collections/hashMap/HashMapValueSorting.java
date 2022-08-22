package com.java.hashMap;

import java.util.*;

public class HashMapValueSorting {
    public static HashMap<String,Integer> sortedValue(Map<String,Integer> inptString){
        LinkedHashMap<String,Integer> sortedValuMap=new LinkedHashMap<>();
        List<Map.Entry<String,Integer>> listValue=new LinkedList<>(inptString.entrySet());
        Collections.sort(listValue, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }


        });
        for(Map.Entry<String,Integer> listEntry:listValue){
            System.out.println(listEntry.getKey()+":"+listEntry.getValue());

            sortedValuMap.put(listEntry.getKey(),listEntry.getValue());
        }
        return sortedValuMap;
    }

    public static void main(String[] args) {
        Map<String,Integer>inptStringMap=new HashMap<>();
        inptStringMap.put("sdf",56);
        inptStringMap.put("edf",74);
        inptStringMap.put("adf",42);
        inptStringMap.put("guw",68);
        Map<String,Integer>resultMAp=sortedValue(inptStringMap);
        System.out.println(resultMAp);
    }
}
