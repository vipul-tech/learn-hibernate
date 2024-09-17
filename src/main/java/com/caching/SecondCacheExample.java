package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Student s1 = session1.get(Student.class, 102);
		System.out.println(s1);
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		Student s2 = session2.get(Student.class, 102);
		System.out.println(s2);
		session2.close();
		sessionFactory.close();
	}

}
