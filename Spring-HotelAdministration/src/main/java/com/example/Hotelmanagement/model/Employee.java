package com.example.Hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long empid;
	private String employeename;
	private String designation;
	private String assignedtask;
	
	@OneToMany(mappedBy = "employee")
    private List<Issue> issue;
	
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
	public List<Issue> getIssue() {
		return issue;
	}
	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}
	
	
	
}
