package com.java.Inheritance;
interface demoInterface{
    void show();
}
class  demoClass{
    void classshow(){
        System.out.println("Inside extentedclass");
    }
}
public class MultipleInheritanceEx extends demoClass implements demoInterface {
    @Override
    public void show() {
        System.out.println("Inside child class");
    }

    public static void main(String[] args) {
        MultipleInheritanceEx inherit= new MultipleInheritanceEx();
        inherit.show();


        inherit.classshow();;
    }
}
