package com.assetTracking;

public class Loan {

	private int id, employeeID, assetID;
	private java.sql.Date startDate, endDate;
	private String employeeName;
	
	public Loan(int id, int employeeID, int assetID, java.sql.Date startDate, java.sql.Date endDate, String employeeName) {
		this.id         = id;
		this.employeeID = employeeID;
		this.assetID    = assetID;
		this.startDate  = startDate;
		this.endDate    = endDate;
	}
	
	public Loan() {}

	public String getEmployeeName() {
		return this.employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmployeeID() {
		return this.employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public int getAssetID() {
		return this.assetID;
	}
	
	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}
	
	public java.sql.Date getStartDate(){
		return this.startDate;
	}
	
	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}
	
	public java.sql.Date getEndDate(){
		return this.endDate;
	}
	
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
}
