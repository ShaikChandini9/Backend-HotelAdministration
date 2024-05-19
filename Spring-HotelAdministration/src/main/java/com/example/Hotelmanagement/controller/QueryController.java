package com.example.Hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotelmanagement.dto.EmployeeRequest;
import com.example.Hotelmanagement.dto.IssueRequest;
import com.example.Hotelmanagement.model.Employee;
import com.example.Hotelmanagement.service.QueryService;

@RestController
@RequestMapping("/api/query")
@CrossOrigin("http://localhost:4200/")
public class QueryController {

	@Autowired
	QueryService queryservice;
	
    public QueryController(QueryService queryservice) {
        this.queryservice= queryservice;
    }

	@GetMapping(value = "/employee")
	public ResponseEntity<List<Employee>> fetchEmployee(){
		List<Employee> employee=queryservice.getAllEmployee();
		System.out.println("Employees found");
		ResponseEntity<List<Employee>> response=new ResponseEntity<>(employee, HttpStatus.OK);
		return response;
		
	}
	
	@PutMapping(value="/{issueid}/status")
	public ResponseEntity<String> updatestatus(@PathVariable Long issueid, 
			 								   @RequestParam String status){
		queryservice.updateStatus(issueid,status);
		System.out.println("Status Updated");
		return new ResponseEntity<>("Query status updated successfully", HttpStatus.OK);
	}
	
	@PostMapping(value="/addtask")
	public ResponseEntity<?> addTask(@RequestBody IssueRequest issuerequest) {
		queryservice.addTask(issuerequest);
		System.out.println("task added succesfully");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping(value="/{issueid}/assign/{employee_id}")
	public ResponseEntity<?> assigningTask(@PathVariable Long issueid,
			                             @PathVariable("employee_id") Long empid) {
		queryservice.taskassigning(issueid, empid);
		return new ResponseEntity(HttpStatus.OK);
	}
}
