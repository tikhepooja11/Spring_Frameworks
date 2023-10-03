package com.spring.jdbc;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoIml;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

@Configuration
public class JdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("pooja");
		return ds;
		
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate(){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean("studentDao")
	public StudentDao getStudentDao()
	{
		StudentDaoIml studentDao = new StudentDaoIml();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}
	
	

}
