package com.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.entity.Employee;
import com.employee.management.repo.JpaExtendedRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private JpaExtendedRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}

}
