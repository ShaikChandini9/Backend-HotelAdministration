package com.example.Hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotelmanagement.model.Employee;
import com.example.Hotelmanagement.model.Issue;

public interface IssueRepository extends JpaRepository<Issue,Long> {

	Issue findByIssueid(Long issueid);
	
	List<Issue> findByEmployee(Employee employee);
}
