package com.designpatterns.singletonPattern;



import java.lang.reflect.Constructor;
class Singleton5{
    public static Singleton5 object = new Singleton5();
    private Singleton5() {
        throw new RuntimeException("Do not break the Singleton class");}
}

public class ResolvingReflectionIssue {
    public static void main(String[] args) {
        Singleton5 instance1 = Singleton5.object;
        Singleton5 instance2 = null;
        try {
            Constructor[] constructors = Singleton5.class.getDeclaredConstructors();
            for(Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (Singleton5) constructor.newInstance();
                break;}
        }catch(Exception e)
        {
            e.printStackTrace();}
        System.out.println("instance1.hashCode() " + instance1.hashCode());
        System.out.println("instance2.hashCode() " + instance2.hashCode());
    }

}


