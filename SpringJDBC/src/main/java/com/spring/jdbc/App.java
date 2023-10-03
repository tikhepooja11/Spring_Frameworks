package com.spring.jdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import java.util.Scanner;
import java.util.List;


/**
 * Hello world!
 * here with normal ClassPathXmlApplicationContext and .xml file we can normally access entire appliation
 * but another way is to create context using AnnotationConfigApplicationContext and replacing all objects in .xml file by creating beans in 
 * JdbcConfig.xml file
 * 
 * so comment one of the context alternately to use it.
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/studentbean.xml");
        //for implementing spring jdbc we require object of JdbcTemplate class
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        int result=0;
        int id = 0;
        String name = "";
        String city = "";
        char c='y';
    	System.out.println("Implementing springJDBC Operations");
        do
        {
            System.out.println("\n 1:INSERT \n 2:UPDATE \n 3:DELETE \n 4:Display Student \n 5:Display All Students details");
            System.out.println("\nEnter choice number which operation u want to perform");
            Scanner sc = new Scanner(System.in);
            
            int choice = sc.nextInt();
            switch(choice)
            {
            case 1 :	System.out.println("\nInsert Operation: ");
            			System.out.println("\nEnter id : ");
            			id = sc.nextInt();
            			System.out.println("\nEnter name : ");
            			name = sc.next();
            			System.out.println("\nEnter city : ");
            			city = sc.next();
            			Student s1 = new Student();
            	        s1.setId(id);
            	        s1.setName(name);
            	        s1.setCity(city);
            	        result = studentDao.insert(s1);
            	        if(result >= 1)
            	        	System.out.println("\nStudent data inserted = "+ result);
            	        else
            	        	System.out.println("\nError in adding student");
            	        break;
            	        
            case 2 :	System.out.println("\nUpdate Operatiob : ");
            			System.out.println("\nEnter the student id whose details to be updated :");
            			id = sc.nextInt();
            			System.out.println("\nEnter new name : ");
            			name = sc.next();
            			System.out.println("\nEnter new city : ");
            			city = sc.next();
            			Student s2 = new Student();
            	        s2.setId(id);
            	        s2.setName(name);
            	        s2.setCity(city);
            	        result = studentDao.update(s2);
            	        if(result >= 1)
            	        	System.out.println("\nStudent data updated = "+ result);
            	        else
            	        	System.out.println("\nError in updating student details");
            	        break;
            	        
            case 3 :	System.out.println("\nDelete Operation : ");
            			System.out.println("\nEnter student id whose details to be deleted :");
            			id = sc.nextInt();
            			result = studentDao.delete(id);
            			if(result >= 1)
            	        	System.out.println("\nStudent data deleted = "+ result);
            	        else
            	        	System.out.println("\nError in deleting student details");
            	        break;
            	        
            case 4 :	System.out.println("\nDisplay Student Operation : ");
            			System.out.println("\nEnter id");
            			id = sc.nextInt();
            			Student s = studentDao.getStudent(id);
            			System.out.println("\nStudent data displayed :" + s.toString());
            			break;
            			
            case 5 :	System.out.println("\nDisplay All Students : ");
            			List<Student> AllStudents = studentDao.getAllStudents();
            			for(Student s3: AllStudents)
            			{
            				System.out.println(s3);
            				System.out.println("\n");
            			}
						
						break;
            	        
            
            	        
            default:	System.out.println("\nWrong choice number");
            			break;
            
            			
       
            			
            }
            System.out.println("\nDo u want to continue anymore?");
			c = sc.next().charAt(0);
        }while(c!= 'n');
        
       System.out.println("\nProgram executed successfully");
            
            
    }
}
