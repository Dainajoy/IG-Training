package com.designpatterns.singletonPattern;

public class LazyInitializationWithDoubleLocking {
    private static LazyInitializationWithDoubleLocking obj = null;

    private LazyInitializationWithDoubleLocking() {

    }

    public static LazyInitializationWithDoubleLocking getInstance() {
        if (obj == null)
            synchronized (LazyInitializationWithDoubleLocking.class) {
                if (obj == null) {
                    obj = new LazyInitializationWithDoubleLocking();
                }
            }
        return obj;
    }

    public static void main(String[] args) {
        LazyInitializationWithDoubleLocking ob=new LazyInitializationWithDoubleLocking();
        System.out.println(ob.getInstance());
    }
}