package com.java.hashMap;

import java.util.HashMap;
import java.util.Map;

public class CharacterCountUsingHashmap {
    public static void main(String[] args) {
        String inputString="ssafjakdnjduh";
        Map<Character,Integer>countMap=new HashMap<>();
        char[] charArray=inputString.toCharArray();
        for(char ch:charArray){
            if(countMap.containsKey(ch)){
                countMap.put(ch,countMap.get(ch)+1);
            }else{
                countMap.put(ch,1);
            }
        }
        System.out.println("Character with count of entries");
        for(Map.Entry<Character,Integer>hm:countMap.entrySet()){
            System.out.println(hm.getKey()+":"+hm.getValue());
        }
    }
}
