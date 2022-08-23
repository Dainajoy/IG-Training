package com.spring.autowire;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

public class Body {
    public static void main(String[] args) {

        Resource r=  new ClassPathResource("beans.xml");
        BeanFactory factory=new XmlBeanFactory( r);

        Human human=factory.getBean("human",Human.class);
        human.startPumping();
    }
}
