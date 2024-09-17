package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student s1 = new Student();
		s1.setId(1001);
		s1.setName("Priya Rai");
		s1.setCity("Ranchi");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Spring Boot");
		certificate1.setDuration("4 months");
		
		s1.setCertificate(certificate1);
		
		Student s2 = new Student();
		s2.setId(1002);
		s2.setName("Saurabh Roy");
		s2.setCity("Patna");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Hibernate");
		certificate2.setDuration("2 months");
		
		s2.setCertificate(certificate2);
		
		Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(s1);
        session.save(s2);
        
        tx.commit();
        session.close();
		factory.close();
	}

}
