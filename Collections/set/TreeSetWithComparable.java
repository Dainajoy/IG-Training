package com.java.set;

import java.util.TreeSet;

class Student implements Comparable<Student> {
    Integer marks;

    Student(Integer marks) {
        this.marks = marks;
    }


    public String toString() {
        return (" " + this.marks);
    }

    // Override compareTo method to sort LinkedHashSet in ascending order
    public int compareTo(Student stu) {
        return this.marks.compareTo(stu.marks);
    }
}
public class TreeSetWithComparable {
    public static void main(String[] args)
    {

        // New TreeSet
        TreeSet<Student> set = new TreeSet<>();

        // Adding elements to the set
        set.add(new Student(500));
        set.add(new Student(300));
        set.add(new Student(400));
        set.add(new Student(100));
        set.add(new Student(200));

        // Print TreeSet sorted in ascending order
        System.out.println("Sort elements in ascending order : " + set);

    }
}
