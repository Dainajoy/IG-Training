package com.java.treeMap;

import com.java.stu.Stu;

import java.util.Comparator;
import java.util.TreeMap;

class SortbyAge implements Comparator<Stu> {


    public int compare(Stu a, Stu b)
    {
        return a.getAge()- b.getAge();
    }


}
public class TreeMapWithComparator  {
    public static void main(String[] args) {
        TreeMap<Stu, Integer> tree_map
                = new TreeMap<Stu, Integer>(
                new SortbyAge());
        tree_map.put(new Stu(111, 13, "dfg"),2);
        tree_map.put(new Stu(131, 4,"rrty"), 3);
        tree_map.put(new Stu(121, 10, "wgf"), 1);
        System.out.println(tree_map);
    }

}
