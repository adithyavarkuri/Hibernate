package com.xml.pojo;
public class BomCustomer {
	private int customerId;
	private String customerName;
	private int forevenId;
	private BomVendor parentObjets;

	public BomVendor getParentObjets() {
		return parentObjets;
	}
	public void setParentObjets(BomVendor parentObjets) {
		this.parentObjets = parentObjets;
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

	public int getForevenId() {
		return forevenId;
	}
	public void setForevenId(int forevenId) {
		this.forevenId = forevenId;
	}

}
