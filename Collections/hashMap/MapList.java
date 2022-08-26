package com.java.hashMap;

import java.util.HashMap;
import java.util.Map;

public class MapList {
    public static Map<Integer,String> getMapList(){
        Map<Integer,String> map= new HashMap<Integer,String>();
        map.put(200,"sfdg");
        map.put(100,"dsfd");
        System.out.println(map);

        return map;

    }
}
