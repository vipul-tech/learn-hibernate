package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstCacheExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student s1 = session.get(Student.class, 101);
		System.out.println(s1);
		
		System.out.println(session.contains(s1));
		System.out.println("Working something....");
		
		Student s2 = session.get(Student.class, 101);
		System.out.println(s2);
		System.out.println(session.contains(s2));
		
		session.close();
		sessionFactory.close();
	}

}
