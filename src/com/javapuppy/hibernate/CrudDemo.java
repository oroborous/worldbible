package com.javapuppy.hibernate;

import com.javapuppy.hibernate.entity.Category;
import com.javapuppy.hibernate.entity.Npc;
import com.javapuppy.hibernate.entity.Quest;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudDemo {
    private SessionFactory factory;

    public CrudDemo() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Npc.class)
                .addAnnotatedClass(Quest.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        CrudDemo demo = new CrudDemo();

        try {


        } finally {
            demo.close();
        }
    }

    public void close() {
        factory.close();
    }


}
