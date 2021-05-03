package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");
		/*
		 * SessionFactory is an interface. SessionFactory can be created by providing
		 * Configuration object, which will contain all DB related property details
		 * pulled from either hibernate.cfg.xml
		 */
		// 1 way -
		// SessionFactory factory = new Configuration().buildSessionFactory();

		// 2 way -
		Configuration cfg = new Configuration();
		// file path is optional
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student object
		Student student = new Student();
		student.setId(103);
		student.setName("Rahul");
		student.setCity("Ranchi");
		System.out.println(student);

		// creating address object
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setStreet("Kanke");
		studentAddress.setCity("Ranchi");
		studentAddress.setOpen(true);
		studentAddress.setAddeDate(new Date());
		studentAddress.setX(123.456);

		// reading image
		FileInputStream fileInputStream = new FileInputStream("src/main/java/image.jpeg");
		byte[] data = new byte[fileInputStream.available()];
		fileInputStream.read(data);
		studentAddress.setImage(data);
		
		// getting session from factory
		Session session = factory.openSession();

		// begin transaction.
		Transaction transaction = session.beginTransaction();

		// execute save method
		session.save(student);
		session.save(studentAddress);

		// commit transaction for physical changes in DB
		transaction.commit();

		// close session
		session.close();
		System.out.println("Done....");
	}
}
