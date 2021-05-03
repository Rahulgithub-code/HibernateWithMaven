package com.ObjectState;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
	public static void main(String[] args) {
		//Practical of Hibernate Object state.
		//1. Transient
		//2. Persistent
		//3. Detached
		//4. Removed
		System.out.println("Example : ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student = new Student();
		student.setId(1011);
		student.setName("Rahul");
		student.setCity("Ranchi");
		student.setCerti(new Certificate("Java hibernate Course", "2 Months"));
		//student object in Transient state.
		
		Session session = f.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
		session.save(student);
		// student object in Persistent state - associate with session and database
		
		student.setName("Vipul");
		
		tx.commit();
		session.close();
		student.setName("Rohit");
		System.out.println(student);
		//student object in detached state.
		f.close();
		
	}

}
