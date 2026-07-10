package com.Spring.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring.EmployeeManagementSystem.entity.Employee;
import com.Spring.EmployeeManagementSystem.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	 
	    private EmployeeRepository repository;
	    public EmployeeServiceImpl(EmployeeRepository repository){
	        this.repository=repository;
	    }
	    public Employee saveEmployee(Employee employee){
	        return repository.save(employee);
	    }
	    public List<Employee> getAllEmployees(){
	        return repository.findAll();
	    }
	    public Employee getEmployeeById(Long id){
	        return repository.findById(id).orElseThrow();
	    }
	    public Employee updateEmployee(Long id, Employee employee){
	        Employee emp=repository.findById(id).orElse(null);
	        return repository.save(emp);
	    }
	    public void deleteEmployee(Long id){
	        repository.deleteById(id);
	    }

}
