package com.cts.demo.application;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cts.demo.domain.Student;



public class StudentMain {

	public static void main(String[] args) {
		
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		Scanner scanner=new Scanner(System.in);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student student=new Student();
		System.out.println("Enter the id");
		student.setRoll(scanner.nextInt());
		System.out.println("Enter the name");
		student.setName(scanner.next());
		System.out.println("Enter the marks");
		student.setMarks(scanner.nextInt());
		session.save(student);
		transaction.commit();
		session.close();
		
	}

}
