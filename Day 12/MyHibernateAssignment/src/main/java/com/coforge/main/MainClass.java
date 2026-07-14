package com.coforge.main;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Course;
import com.coforge.model.Student;

public class MainClass {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Course java = new Course(101, "Java");
		Course spring = new Course(102, "Spring Boot");
		Course hibernate = new Course(103, "Hibernate");
		Course angular = new Course(104, "Angular");
		
		Student john = new Student(1, "John");
		Student priya = new Student(2, "Priya");
		Student david = new Student(3, "David");
		
		john.setCourses(Arrays.asList(java, spring));

		priya.setCourses(Arrays.asList(java, hibernate));

		david.setCourses(Arrays.asList(java, spring, angular));
		
		session.save(java);
		session.save(spring);
		session.save(hibernate);
		session.save(angular);

		session.save(john);
		session.save(priya);
		session.save(david);
		
		
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println("Many-To-Many Mapping Completed Successfully.");
	}

}
