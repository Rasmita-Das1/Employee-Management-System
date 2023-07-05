package com.employee.management.service;

import java.util.List;

import com.employee.management.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long id);
	
	Employee saveEmployee(Employee employee);
	   
	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

}
