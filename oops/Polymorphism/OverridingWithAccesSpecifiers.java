package com.java.Polymorphism;

class VisibilityLess{
    protected void dis(){
        System.out.println("Inside protected");
    }
}
class VisibilityMore extends VisibilityLess{
    public void dis(){
        System.out.println("Inside Public");
    }

}
public class OverridingWithAccesSpecifiers {
    public static void main(String[] args) {
        VisibilityMore visi=new VisibilityMore();
        visi.dis();
    }

}
