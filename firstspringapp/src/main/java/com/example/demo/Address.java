package com.example.demo;
import org.springframework.stereotype.Component;

@Component
public class Address {
	
	String city;
	String state;
	String country;
	int pincode;
	
	public Address(String city, String state, String country, int pincode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
}
