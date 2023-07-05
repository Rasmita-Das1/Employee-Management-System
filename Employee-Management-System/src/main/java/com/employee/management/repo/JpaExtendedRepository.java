package com.employee.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management.entity.Employee;

public interface JpaExtendedRepository extends JpaRepository<Employee, Long>{

}
