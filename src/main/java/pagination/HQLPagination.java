package pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLPagination {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Query<Student> query = session.createQuery("from Student", Student.class);
		
        //implementing pagination using hibernate
        query.setFirstResult(3);
        query.setMaxResults(2);
		
		List<Student> students = query.list();
		
		for(Student student : students) {
			System.out.println(student.getId() + " : " + student.getName() + " : " + student.getCity());
		}
        
        session.close();
        factory.close();
	}

}
