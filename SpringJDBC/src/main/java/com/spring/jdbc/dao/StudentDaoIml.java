package com.spring.jdbc.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

import com.spring.jdbc.entities.Student;

public class StudentDaoIml implements StudentDao{

	private JdbcTemplate  jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(Student student) {
		String query = "insert into student (id,name,city) values (?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(),student.getCity() );
		return r;
	}
	public int update(Student student)
	{
		String query = "update student set name=? , city = ? where id = ?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}
	public int delete(int studentId) {
		String query = "delete from student where id = ?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}
	public Student getStudent(int studentId) {
		String query = "select * from student where id = ?";
		RowMapper <Student> rowMapperobj = new RowMapperImpl();
		Student s = this.jdbcTemplate.queryForObject(query, rowMapperobj, studentId);
		
		return s;
	}
	public  List <Student> getAllStudents() {
		String query = "select * from student";
		RowMapper <Student> rowMapperobj = new RowMapperImpl();
		List <Student> students = this.jdbcTemplate.query(query,rowMapperobj);
		return students;
	}

}
