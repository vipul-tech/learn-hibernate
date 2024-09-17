package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLExample {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		String query = "from Student as s where s.city=:x and s.name=:n";
		Query<Student> q = session.createQuery(query, Student.class);
		q.setParameter("x", "New Delhi");
		q.setParameter("n", "Sunny Kumar");
		
		List<Student> students = q.list();
		
		for(Student student : students) {
			System.out.println(student.getName() + " : " + student.getCity() + " : " + student.getCertificate().getCourse());
		}
		
		System.out.println("----------------------");
		
		Transaction tx = session.beginTransaction();
		
		Query<Student> q2 = session.createQuery("delete from Student as s where city=:c", Student.class);
		q2.setParameter("c", "Pune");
		int result = q2.executeUpdate();
		System.out.println("Deleted : " + result);
		
		Query<Student> q3 = session.createQuery("update Student set city=:c where certificate.duration=:cr", Student.class);
		q3.setParameter("c", "Kolkata");
		q3.setParameter("cr", "3 months");
		int result2 = q3.executeUpdate();
		System.out.println(result2 + " objects updated");
		
		//joining of tables
		Query q4 = session.createQuery("SELECT a.authorId, a.authorName, b.title FROM Author as a INNER JOIN a.books as b");
		
		List<Object[]> objList = q4.getResultList();
		
		for(Object[] arr : objList) {
			System.out.println(Arrays.toString(arr));
		}
		
		tx.commit();
		
		session.close();
		factory.close();
	}

}
