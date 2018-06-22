package com.assetTracking;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class Asset {

	
	private int id;
	private String serialNumber, vendor, notes;
	private java.sql.Date disposalDate;
	
	public Asset(int id, String serialNumber, String vendor, java.sql.Date disposalDate, String notes) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.vendor = vendor;
		this.disposalDate = disposalDate;
		this.notes = notes;
	}
	public Asset() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public java.sql.Date getDisposalDate() {
		return disposalDate;
	}
	public void setDisposalDate(java.sql.Date disposalDate) {
		this.disposalDate = disposalDate;
	}
	
	
}
