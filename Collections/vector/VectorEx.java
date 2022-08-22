package com.java.vector;

import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        int n = 5;
        Vector<Integer>vec=new Vector<>();
        for (int i = 1; i <= n; i++)
            vec.add(i);
        System.out.println(vec);
        System.out.println("Remove 3 rd element from Vector");
        vec.remove(3);
        System.out.println(vec);
    }
}
