package com.springcore.collections;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

public class Emp {
	
	private String name;
	private List <Integer> phones;
	private Set <String> addresses;
	private Map <String,String> courses;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(String name, List<Integer> phones, Set<String> addresses, Map<String, String> courses) {
		this.name = name;
		this.phones = phones;
		this.addresses = addresses;
		this.courses = courses;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getPhones() {
		return phones;
	}
	public void setPhones(List<Integer> phones) {
		this.phones = phones;
	}
	public Set<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	
	
	
	

}
