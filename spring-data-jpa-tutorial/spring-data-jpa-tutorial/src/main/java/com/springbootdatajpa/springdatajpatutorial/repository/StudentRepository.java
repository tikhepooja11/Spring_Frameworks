package com.springbootdatajpa.springdatajpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdatajpa.springdatajpatutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	/*
	 * here already JpaRepository implements many of methods still, if we want to
	 * create our own methods we can create it by using findById, findByName by
	 * following jpa query methods
	 * 
	 * we can call those methods using rest api calls but for time saving here we
	 * are just running those methods using @Test, @SpringTest, @DataJpaTest annotation on testclass just to test our repository layer
	 * so that our data will not be affected. but here we want out data to be affected so we dont use @DataJpaTest
	 * 
	 */
}
