package com.travis.hibernate.demo;

import com.travis.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            Student one = new Student("pall", "wall", "pall@gmail.com");
            Student two = new Student("dearom", "fox", "fox@gmail.com");
            Student three = new Student("buddy", "shild", "shild@gmail.com");
            session.beginTransaction();
            session.save(one);
            session.save(two);
            session.save(three);
            session.getTransaction().commit();
        }
    }
}
