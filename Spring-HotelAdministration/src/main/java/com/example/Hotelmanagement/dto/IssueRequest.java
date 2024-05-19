package com.example.Hotelmanagement.dto;

public class IssueRequest {

	private Long issueid;
	private String  issue;
	private String status;
	
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
	
	
}
