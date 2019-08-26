package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

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
            
            //delete the student
            session.delete(myStudent);
            
            session.getTransaction().commit();
            
            //delete student id =2
            
            session.createQuery("delete from student where id=2").executeUpdate();
     
          
            
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
	}

}
