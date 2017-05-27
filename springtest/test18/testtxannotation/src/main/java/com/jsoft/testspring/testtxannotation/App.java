package com.jsoft.testspring.testtxannotation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------");
		studentDAO.create("Zara", 11, 99, 2010);
		studentDAO.create("Nuha", 20, 97, 2010);
		studentDAO.create("Ayan", 25, 100, 2011);
		System.out.println("------Listing Multiple Records--------");
		List<StudentMarks> students = studentDAO.listStudents();
		for (StudentMarks record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Age : " + record.getAge());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
		System.out.println("----Updating Record with ID = 2 -----");
		studentDAO.update(2,"Nuha", 20,99,2011);
		System.out.println("----Listing Record with ID = 2 -----");
		StudentMarks student = studentDAO.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.print(", Age : " + student.getAge());
		System.out.print(", Year : " + student.getYear());
		System.out.println(", Age : " + student.getAge());
		System.out.println("----Delete Record with ID = 2 -----");
		studentDAO.delete(2);
	}
}
