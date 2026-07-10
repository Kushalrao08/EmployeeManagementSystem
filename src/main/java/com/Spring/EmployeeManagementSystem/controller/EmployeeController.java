package com.Spring.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.EmployeeManagementSystem.entity.Employee;
import com.Spring.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 private EmployeeService service;

	    public EmployeeController(EmployeeService service){
	        this.service=service;
	    }

	    @PostMapping("/add")
	    public Employee addEmployee(@RequestBody Employee employee){
	        return service.saveEmployee(employee);
	    }

	    @GetMapping("/fetch")
	    public List<Employee> getAllEmployees(){
	        return service.getAllEmployees();
	    }

	    @GetMapping("/fetch/{id}")
	    public Employee getEmployee(@PathVariable Long id){
	        return service.getEmployeeById(id);
	    }

	    @PutMapping("/update/{id}")
	    public Employee updateEmployee(@PathVariable Long id,
	                                   @RequestBody Employee employee){
	        return service.updateEmployee(id, employee);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable Long id){
	        service.deleteEmployee(id);
	        return "Employee Deleted Successfully";
	    }

}
