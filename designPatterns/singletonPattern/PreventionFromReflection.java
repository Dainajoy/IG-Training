package com.designpatterns.singletonPattern;

import java.lang.reflect.Constructor;

class SingletonPre
{
    // public instance initialized when loading the class
    public static SingletonPre instance = new SingletonPre();
    private SingletonPre()  {
        if (instance != null) {
            throw new IllegalStateException("Do not break the singleton pattern");
        }
        System.out.println("Singleton instance is being created.");
    }
}

public class PreventionFromReflection {
    public static void main(String[] args) {
        SingletonPre instance1 = SingletonPre.instance;
        SingletonPre instance2 = null;
        try {
            Constructor[] constructors =
                    Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (SingletonPre) constructor.newInstance();
                break;

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode():- "
                + instance1.hashCode());
        System.out.println("instance2.hashCode():- "
                + instance2.hashCode());
    }

}

