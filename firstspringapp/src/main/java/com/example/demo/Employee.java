package com.example.demo;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Iterator;

@Component
@Scope(value="prototype")
public class Employee {
	int id;
	String name;
	double salary;
	@Autowired
	Address addr;
	List<String> skills;
	
	Employee(){}
	Employee(int id, String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	Employee(int id, String name, double salary, Address addr)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.addr = addr;
	}
	
	Employee(int id, String name, double salary, Address addr, List<String> skills)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.addr = addr;
		this.skills = skills;
	}
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	public void display()
	{
		System.out.println("Showing employee details :"+id+" , "+ name+" , "+salary);
		System.out.println(addr.toString());
		System.out.println("skills =\t");
		Iterator <String> itr = skills.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
			
	}
	
	
}
