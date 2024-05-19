package com.example.Hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Issue {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long issueid;
	private String issue;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
    private Employee employee;
	
	public Long getIssueid() {
		return issueid;
	}
	public void setIssueid(Long issueid) {
		this.issueid = issueid;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
