package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/ormconfig.xml");
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
            	        s1.setStudentId(id);
            	        s1.setStudentName(name);
            	        s1.setStudentCity(city);
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
            	        s2.setStudentId(id);
            	        s2.setStudentName(name);
            	        s2.setStudentCity(city);
            	        studentDao.update(s2);
            	        break;
            	        
            case 3 :	System.out.println("\nDelete Operation : ");
            			System.out.println("\nEnter student id whose details to be deleted :");
            			id = sc.nextInt();
            			studentDao.delete(id);
            			
            	        break;
            	        
            case 4 :	System.out.println("\nDisplay Student Operation : ");
            			System.out.println("\nEnter id");
            			id = sc.nextInt();
            			Student s = studentDao.getStudent(id);
            			System.out.println("\nStudent data displayed :" + s.toString());
            			break;
            			
            case 5 :	System.out.println("\nDisplay All Students : ");
            			List<Student> AllStudents = studentDao.allStudents();
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
