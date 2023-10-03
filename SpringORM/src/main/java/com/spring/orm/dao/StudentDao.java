package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate; //to autoimport ctrl+shift+o
	
	@Transactional
	public int insert(Student student) {
		
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}

	//get single object from database
	public Student getStudent(int stud_Id)
	{
		Student s = this.hibernateTemplate.get(Student.class, stud_Id);
		return s ;
	}
	
	//get All students
	public List <Student> allStudents(){
		List<Student> stud_list = this.hibernateTemplate.loadAll(Student.class);
		return stud_list;
	}
	
	//update student
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
		
	}
	
	//delete student
	@Transactional    //while writing into database we need transactional annotation but not required while reading data
	public void delete(int stud_Id)
	{
		Student s2 = this.hibernateTemplate.get(Student.class, stud_Id); //first load the student with this stud_Id
		this.hibernateTemplate.delete(s2);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
