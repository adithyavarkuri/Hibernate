package com.xml.pojo;
public class MoCustomer {
	private int customerId;
	private String customerName;
	private MoVendor parentObjects;

	public MoVendor getParentObjects() {
		return parentObjects;
	}
	public void setParentObjects(MoVendor parentObjects) {
		this.parentObjects = parentObjects;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
