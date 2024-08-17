package com.xml.pojo;
public class OOAddress {
	private int addressId;
	private String city;
	private String state;
	private OOStudent oostudent;	

	
	
	public OOStudent getOostudent() {
		return oostudent;
	}
	public void setOostudent(OOStudent oostudent) {
		this.oostudent = oostudent;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
