package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		// file path is optional
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student object
		Student student = new Student();
		student.setId(101);
		student.setName("Sonali");
		student.setCity("Galudih");

		// creating certi object
		Certificate certificate = new Certificate();
		certificate.setCourse("Java");
		certificate.setDuration("2 months");
		student.setCerti(certificate);

		// creating student1 object
		Student student1 = new Student();
		student1.setId(102);
		student1.setName("Sonali");
		student1.setCity("Galudih");

		// creating certi object
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Angular");
		certificate1.setDuration("3 months");
		student1.setCerti(certificate1);
		
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		
		//object save
		session.save(student);
		session.save(student1);
		
		transaction.commit();
		session.close();
		System.out.println("Done");

	}
}
