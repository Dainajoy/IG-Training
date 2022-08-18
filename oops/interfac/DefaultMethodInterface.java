package com.java.interfac;

interface vehicle
{
    void cleanVehicle();
    default void startVehicle(){
   System.out.println("Vehicle started");
}
}
class car implements  vehicle{
    public void cleanVehicle(){
        System.out.println("Inside car");
    }
}

public class DefaultMethodInterface {
    public static void main(String[] args) {
        car cr=new car();
        cr.startVehicle();
        cr.cleanVehicle();

    }
}
