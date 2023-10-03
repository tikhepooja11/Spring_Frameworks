package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@SpringBootApplication
public class FirstspringappApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(FirstspringappApplication.class, args);
		
		/*by using Applicationontext container
		ApplicationContext context =  new ClassPathXmlApplicationContext("employeebean.xml"); 
		Employee e1 = context.getBean(Employee.class);
		System.out.println("showing employee details  :\t"+e1);*/
		
		

		/*by using BeanFactory container*/
		Resource resource = new ClassPathResource("employeebean.xml"); //creating resource of xml file
		BeanFactory factory = new XmlBeanFactory(resource); //return bean object
		Employee e2 = (Employee)factory.getBean("emp2");
		System.out.println("\nshowing employee details emp2 :\t"+e2);
		System.out.println("\n\n");
		
		Employee e3 = (Employee) factory.getBean("emp3");
		Address addr = (Address) factory.getBean("a1");
		System.out.println("\nshowing employee details emp3 :\t"+e3+"\n\t\t\t  :\t"+addr.toString());
		System.out.println("\n\n");

		
		Employee e4 = (Employee)factory.getBean("emp4");
		System.out.println("\nshowing employee details emp4 :\t");
		e4.display();
		System.out.println("\n\n");

	}

}
