package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;


public class QueryStudentDemo {

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
            
            //query student
            
            List<Student> theStudents = session.createQuery("from studnet").getResultList();
            
            //display the students
            displayStudents(theStudents);
            
            //query student : lastname = "doe
            theStudents = session.createQuery("from student s where s.lastName ='doe'").getResultList();
            
            //display the students
            displayStudents(theStudents);
            
            //query student: last name ="doe" or fistname=daffy
            theStudents = session.createQuery("from student s where s.lastName='doe' OR s.firstName = 'daffy'").getResultList();
            
            //display the students
            displayStudents(theStudents);
            
            //query student where email like '%luv2code.com'
            theStudents = session.createQuery("from student s where s.email='%luv2code.com'").getResultList();
            
            //display students
            displayStudents(theStudents);
            
            
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
