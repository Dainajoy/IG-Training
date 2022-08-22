package com.java.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Vicky", 10);
        map.put("Vani", 30);
        map.put("vikas", 20);
        System.out.println("Size of map is:- "
                + map.size());
        System.out.println(map);
        if (map.containsKey("Vicky")) {
            Integer a = map.get("vicky");
            System.out.println("value for key"
                    + " \"vicky\" is:- " + a);
        }
        Set<Map.Entry<String,Integer>> mapEntrySet=  map.entrySet();
        for(Map.Entry<String,Integer> em:mapEntrySet){
            System.out.println("key:"+em.getKey()+" value:"+em.getValue());
        }


    }
}
