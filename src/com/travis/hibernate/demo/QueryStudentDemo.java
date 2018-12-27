package com.travis.hibernate.demo;

import com.travis.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try (factory) {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
//            students.forEach(System.out::println);

            students = session.createQuery("from Student s where s.lastName='fox'").getResultList();
//            students.forEach(System.out::println);


            students = session.createQuery("from Student s where s.lastName='fox' or s.firstName='pall'").getResultList();
            students = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
            students.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }

}
