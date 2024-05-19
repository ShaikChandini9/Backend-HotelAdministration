package com.example.Hotelmanagement.dto;

public class EmployeeRequest {

	private Long empid;
	private String employeename;
	private String designation;
	private String assignedtask;
	private String status;
	
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAssignedtask() {
		return assignedtask;
	}
	public void setAssignedtask(String assignedtask) {
		this.assignedtask = assignedtask;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
