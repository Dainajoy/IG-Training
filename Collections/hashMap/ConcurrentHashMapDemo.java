package com.java.hashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap
                = new ConcurrentHashMap<>();
        concurrentHashMap.put(234,"Dev");
        concurrentHashMap.put(123,"Ram");
        concurrentHashMap.put(238,"Abel");
        concurrentHashMap.putIfAbsent(101, "Kim");
        for(Map.Entry<Integer,String> entrySet:concurrentHashMap.entrySet()){
            System.out.println(entrySet.getKey()+":"+entrySet.getValue());

        }
        concurrentHashMap.replace(101, "Kim", "Oliver");
        System.out.println("**********After Replacement*****");
        for(Map.Entry<Integer,String> entrySet:concurrentHashMap.entrySet()){
            System.out.println(entrySet.getKey()+":"+entrySet.getValue());

        }
        concurrentHashMap.remove(101, "Oliver");
        System.out.println("***After remove******");
        for(Map.Entry<Integer,String> entrySet:concurrentHashMap.entrySet()){
            System.out.println(entrySet.getKey()+":"+entrySet.getValue());

        }
        System.out.println("****************Copy one hashmap value to another****");
        ConcurrentHashMap<Integer, String> new_concurrentHashMap
                = new ConcurrentHashMap<>();


        new_concurrentHashMap.putAll(concurrentHashMap);
        System.out.println(new_concurrentHashMap);
        System.out.println("***After clear***");
        concurrentHashMap.clear();
        System.out.println(concurrentHashMap);
    }
}
