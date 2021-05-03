package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		// file path is optional
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		// get-student id: 106
		//get()
		Student student = (Student) session.get(Student.class, 102);
		Student student1 = (Student) session.get(Student.class, 102);
		System.out.println(student.getCity());
		System.out.println(student1);
		
		
		//load()
		Student student2= (Student) session.load(Student.class, 102);
		Student student3= (Student) session.load(Student.class, 102);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println("Fetching done...");
	}

}
