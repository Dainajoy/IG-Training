package com.java.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main (String[] args) {
        Deque<Character> stack = new ArrayDeque<Character>();
        stack.push('A');
        stack.push('B');
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
