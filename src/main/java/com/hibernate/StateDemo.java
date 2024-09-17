package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		
		//Hibernate Object States
		//1. Transient
		//2. Persistent
		//3. Detached
		//4. Removed
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student stud = new Student();
		stud.setId(101);
		stud.setName("Vipul Kumar");
		stud.setCity("New Delhi");
		stud.setCertificate(new Certificate("AWS Cloud Practicioner", "4 months"));
		//Student : Transient (Not associated with both Database & Session)
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println(stud.getName());
		
		session.save(stud);
		Student st = (Student)session.get(Student.class, 101);
        System.out.println("From database : " + st);
		//Student : Persistent (Associated with both Database & Session)
		
		stud.setName("Sunny Kumar");
		st = (Student)session.get(Student.class, 101);
        System.out.println("From database after setName() is called: " + st);
        
        session.delete(stud);
        //Student : Removed (Associated with Session but data is deleted from Database)
        session.save(stud); //after saving it again goes to persistent state
        
		tx.commit();
		
		stud.setName("Anand Kumar");
		System.out.println(stud.getName());
		
		session.close();
		//Student : Detached (Not associated with Session but data is present in Database)
		factory.close();
	}

}
