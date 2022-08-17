package com.java8.streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String inputStr="sdnkjwhdbcnm";
        char[] ch=inputStr.toCharArray();
        Map<Character,Integer> countMap=new LinkedHashMap<Character,Integer>();
        for (Character c:ch){
            countMap.put(c,countMap.containsKey(c)?countMap.get(c)+1:1);
        }
        System.out.println("First non repeated character:"
        +countMap.entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey());
        Character result = inputStr.chars().
                mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))).
                collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1L).
                map(entry -> entry.getKey()).findFirst().get();
        System.out.println("First Non repeated:"+result);
    }
}
