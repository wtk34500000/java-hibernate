package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;


public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml") 
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {          
            
            // start a transaction
            session.beginTransaction();
            
            int studentId =1;
            
            Student myStudent = session.get(Student.class, studentId);
            
            
            myStudent.setFirstName("Scooby");
            
            session.getTransaction().commit();
            
            //NEW CODE
            session= factory.getCurrentSession();
            session.beginTransaction();
            
            //update email for all students
            session.createQuery("update student set email = 'foo@gmail.com'")
            		.executeUpdate();
            
            session.getTransaction().commit();
            
          
            
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
	}

}
