package com.example.Hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotelmanagement.dto.EmployeeRequest;
import com.example.Hotelmanagement.dto.IssueRequest;
import com.example.Hotelmanagement.model.Employee;
import com.example.Hotelmanagement.model.Issue;
import com.example.Hotelmanagement.repository.EmployeeRepository;
import com.example.Hotelmanagement.repository.IssueRepository;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@Transactional
public class QueryService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository employeerepo;
	
	@Autowired
	IssueRepository issuerepo;
	
	public List<Employee> getAllEmployee() {
		
		List<Employee> queryList=employeerepo.findAll();
		List<EmployeeRequest> queryrequestList = new ArrayList<EmployeeRequest>();
		Employee query=new Employee();
		EmployeeRequest queryrequest=new EmployeeRequest();
		queryrequest.setEmpid(query.getEmpid());
		queryrequest.setEmployeename(query.getEmployeename());
		queryrequest.setDesignation(query.getDesignation());
		queryrequestList.add(queryrequest);
		queryList.add(query);
		logger.info("employee details are : {}", queryList);
		return queryList;
		
	}
	
	public void addTask(IssueRequest issuerequest) {
		
		Issue issue=new Issue();
		issue.setIssue(issuerequest.getIssue());
		issue.setStatus(issuerequest.getStatus());
		issuerepo.save(issue);
	}
	
	@Transactional
	public void updateStatus(Long issueid,String Status) {
		Issue issue=issuerepo.findByIssueid(issueid);
		if(issue==null) {
			throw new RuntimeException("Query not found with id: " + issueid);
		}
		issue.setStatus(Status);
		issuerepo.save(issue);
		
	}
	
	public Issue taskassigning(Long issueid,Long employeeid) {
		 
		Issue issue=issuerepo.findByIssueid(issueid);
		if(issue!=null) {
			Employee employee=employeerepo.findByempid(employeeid);
			employee.setEmpid(employeeid);
			issue.setEmployee(employee);
			employee.setAssignedtask(issue.getIssue());
			employeerepo.save(employee);
			return issuerepo.save(issue);
		}
		return null;
	}
}
