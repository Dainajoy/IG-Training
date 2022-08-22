package com.java.arrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class ArrayListWithOPerations
{
    public static void main(String args[]){
        List<String> fruitlist = (List<String>) new ArrayList<String>();
        fruitlist.add("Mango");
        fruitlist.add("Apple");
        fruitlist.add("Banana");
        fruitlist.add("Grapes");
        Iterator<String> itr=fruitlist.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        ArrayList<String> al = new ArrayList<String>();
        al.add("Strawberry");
        al.add("Cherry");
        System.out.println(" merge two list");
        fruitlist.addAll(al);
        System.out.println(fruitlist);
        System.out.println("Sorted list in increasing order");
        Collections.sort(fruitlist);
        System.out.println(fruitlist);
        System.out.println("Reverse order");
        Collections.reverse(fruitlist);
        //Collections.sort(fruitlist,Collections.reverseOrder());
        System.out.println(fruitlist);

        System.out.println(" List is empty or not :" + fruitlist.isEmpty());
        System.out.println("Element is present or not :" + fruitlist.contains("Apple"));
        System.out.println("The position of element :" + fruitlist.indexOf("Cherry"));
        System.out.println("After removing one element");
        fruitlist.remove("Cherry");
        System.out.println(fruitlist);


        // Printing array of objects
        System.out.println("Set value apple to pineApple");
        fruitlist.set(fruitlist.size()-1,"pineApple");
        System.out.println(fruitlist);
        System.out.println("Using for each");
        for (String str : fruitlist)
            System.out.print(str + " ");
        System.out.println("\nArrayList to array");
        Object[] objects = fruitlist.toArray();
        for (Object obj : objects)
            System.out.print(obj + " ");
        System.out.println();
        System.out.println(objects[3]);

    }



    }
