package com.nativesql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class NativeSQLQueryExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String query = "SELECT * FROM student";
		Query nq = session.createSQLQuery(query);
		List<Object[]> list = nq.list();
		for(Object[] student : list) {
			System.out.println(Arrays.toString(student));
			System.out.println(student[3] + " " + student[4]);
		}
		
		session.close();
		sessionFactory.close();
	}

}
