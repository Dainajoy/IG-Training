package com.java.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapKeySort {
    private static Map<String, Integer> sortedKey(Map<String, Integer> inptStringMap) {
        TreeMap<String,Integer>treeMap=new TreeMap<>();
        for (Map.Entry<String,Integer> mapEntry:inptStringMap.entrySet()){
            treeMap.put(mapEntry.getKey(),mapEntry.getValue());
        }
        return treeMap;
    }
    public static void main(String[] args) {
        Map<String,Integer> inptStringMap=new HashMap<>();
        inptStringMap.put("sdf",56);
        inptStringMap.put("edf",74);
        inptStringMap.put("adf",42);
        inptStringMap.put("guw",68);
       /* List sortedKeys=new ArrayList(yourMap.keySet());
        Collections.sort(sortedKeys);*/
        Map<String,Integer>resultMAp=sortedKey(inptStringMap);
        System.out.println(resultMAp);
    }


}
