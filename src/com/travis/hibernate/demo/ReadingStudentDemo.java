package com.travis.hibernate.demo;

import com.travis.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadingStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            Student student = new Student("duffy", "duck", "duffy@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStu = session.get(Student.class, student.getId());
            System.out.println(myStu);
            session.getTransaction().commit();

        }
    }

}
