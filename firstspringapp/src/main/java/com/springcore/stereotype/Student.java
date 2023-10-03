package com.springcore.stereotype;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;


import java.util.List;

@Component("stud_obj")
@Scope("prototype")
public class Student {

	@Value("101")     //used to set values to property of an object
	private int id;
	@Value("Pooja Tikhe")
	private String name;
	@Value("10")
	private int age;
	@Value("#{addr_list}")  //"addr_list" - id of collection
	private List <String> address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	
}
