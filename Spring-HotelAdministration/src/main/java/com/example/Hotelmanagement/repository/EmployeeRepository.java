package com.example.Hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotelmanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee findByempid(Long empid);
	
}
