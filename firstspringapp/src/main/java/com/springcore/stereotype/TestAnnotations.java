package com.springcore.stereotype;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/*
 * 1)@Component annotation
 * used to create objects automatically without creating objects through <bean> tag using xml.
 * we just need to add <context:component-scan base-package="com.springcore.stereotype.annotations"/> tag in .xml file so that
 * it will scan all classes in this packages also in its subpackages.
 * 
 * @Component will create object same as classname on which @component is written without using camelcase syntax.
 * but we can give userdefined name instead of classname for an object.
 * To do this 2 changes required - @Component("stud_obj") & Student s1=context.getBean("stud_obj",Student.class)
 * 
 * 2)@Value annotation
 * for setting values to instance variables object formed by @Component we have to write @Value annotation on those instance variables whose values to be set.
 * 
 * 3)creating Standalone collection in .xml file and setting its values using @Value annotation
 * 
 */

public class TestAnnotations {

	public static void main(String[] args) {
		
		ApplicationContext context =  new ClassPathXmlApplicationContext("com/springcore/stereotype/annotations.xml"); 
		Student s1 = context.getBean("stud_obj",Student.class);  //if @Component() is without obj name then getBean("student",Student.class)
		System.out.println(s1);
		System.out.println("Address"+ s1.getAddress());
		
		//USING PROTOTYPE SCOPE
		Student s2 = context.getBean("stud_obj",Student.class);
		System.out.println("Use of Prototype scope i.e creating 2 objects of same class\t : \t"+ s1.hashCode() +"\t"+ s2.hashCode()); //both values would be same as bydefault scope is singleton
		//so we need to give scope as prototype. after specifyting scope it will print different hashcodes i.e. 2 objects of same class
		
		//Using prototype scope in bean tag
		Teacher t1 = context.getBean("teacher1",Teacher.class);
		Teacher t2 = context.getBean("teacher1",Teacher.class);
		System.out.println("Use of Prototype scope i.e creating 2 objects of same class\t : \t"+ t1.hashCode() +"\t"+ t2.hashCode()); //both values would be same as bydefault scope is singleton

		SpelExpressionParser temp = new SpelExpressionParser();
		Expression expression = temp.parseExpression("22+44");
		System.out.println(expression.getValue());
		
		
		
	}

}
