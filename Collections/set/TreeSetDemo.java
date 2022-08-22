package com.java.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> al=new TreeSet<String>();
        al.add("eee");
        al.add("ddd");
        al.add("sss");
        al.add("weew");
        al.add("aaa");
        //Traversing elements
        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("Head Set: "+al.headSet("ddd", true));

        System.out.println("SubSet: "+al.subSet("ddd", false, "sss", true));
        System.out.println("TailSet: "+al.tailSet("sss", false));
        System.out.println("Traversing element through Iterator in descending order");
        Iterator i=al.descendingIterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        System.out.println("Retrieve and remove first and last element");
        System.out.println("Lowest Value: "+al.pollFirst());
        System.out.println("Highest Value: "+al.pollLast());
        System.out.println(al);

    }

}
