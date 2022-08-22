package com.java.priorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(35);
        pQueue.add(43);
        System.out.println(pQueue.peek());
        // Printing the top element and removing it
        System.out.println(pQueue.poll());
        System.out.println(pQueue.peek());
        Iterator<Integer> itr = pQueue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        pQueue.remove();
        pQueue.poll();
        System.out.println("Iterating the queue elements:");
        Iterator<Integer> itr2 = pQueue.iterator();
        while(itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }

}
