package com.spring.autowire;

public class Human {
    private Heart heart;
    public void setHeart(Heart heart) {
        this.heart = heart;
        System.out.println("Setter method is called");
    }
  public void startPumping(){
        if(heart!=null)
        heart.pump();
        else{
            System.out.println("Dead");
        }
  }

}
