package com.Spring.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
