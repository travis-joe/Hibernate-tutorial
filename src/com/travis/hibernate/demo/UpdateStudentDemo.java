package com.travis.hibernate.demo;

import com.travis.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int studentId = 1;
            Student student = session.get(Student.class, studentId);
            student.setFirstName("qzy");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='foo@gamil.com'").executeUpdate();
            session.getTransaction().commit();
        }
    }

}
