package com.springcore.collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/springcore/collections/collectionbeans.xml");
		Emp e1 = context.getBean("emp1", Emp.class);  //also can write Emp e1 = (Emp)context.getBean("emp1")
		System.out.println("Showing employee details  :");
		System.out.println(e1.getName());
		System.out.println(e1.getPhones());
		System.out.println(e1.getAddresses());
		System.out.println(e1.getCourses());

	}

	

}
