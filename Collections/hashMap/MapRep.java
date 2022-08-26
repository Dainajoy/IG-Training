package com.java.hashMap;

import java.util.Map;

public class MapRep {
    public static void main(String[] args) {
        System.out.println(MapList.getMapList());
        Map<Integer,String> mapList=MapList.getMapList();
        System.out.println(mapList.replace(200,"eee"));
        System.out.println(mapList);
    }

}
