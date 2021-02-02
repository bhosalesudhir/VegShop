package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // mandatory
public class Address {

	@Column(name = "City", length = 15)
	private String City;
	@Column(name = "State", length = 15)
	private String State;
	@Column(name = "PinCode", length = 6)
	private String PinCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String city, String state, String pinCode) {
		super();
		City = city;
		State = state;
		PinCode = pinCode;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [City=" + City + ", State=" + State + ", PinCode=" + PinCode + "]";
	}

}
