package com.javapuppy.springxml;

import com.javapuppy.springxml.beans.NPC;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // load the Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from Spring container
        NPC theNpc = context.getBean("myNpc", NPC.class);

        // call getters for literal values
        System.out.println(theNpc.getFirstName());
        System.out.println(theNpc.getBio());

        // call methods on the bean
        theNpc.logChange();

        // close the context
        context.close();
    }
}
