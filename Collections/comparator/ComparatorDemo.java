package com.java.comparator;

import com.java.stu.Stu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class NameComparator implements Comparator<Stu>{

    @Override
    public int compare(Stu o1, Stu o2) {
        return o1.name.compareTo(o2.name);
    }
}
class AgeComparator implements Comparator<Stu>{

    @Override
    public int compare(Stu o1, Stu o2) {
        return o1.getAge()-(o2.getAge());
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Stu> al=new ArrayList<Stu>();
        al.add(new Stu(105,10,"Ram"));
        al.add(new Stu(101,19,"Krish"));
        al.add(new Stu(106,4,"Dev"));

        System.out.println("Sorting By Name ");
        Collections.sort(al,new NameComparator());
        for(Stu st:al) {
            System.out.println(st.getId() + " "  + st.getAge() + " " + st.getName());
        }
        System.out.println("Sorting By Age ");
        Collections.sort(al,new AgeComparator());
        for(Stu st:al) {
            System.out.println(st.getId()+ " "  + st.getAge() + " " + st.getName());
        }
    }
}
