package com.employee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.entity.Employee;
import com.employee.demo.exception.GlobalNotFoundException;
import com.employee.demo.service.EmployeeService;


@RestController
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addUser(@RequestBody Employee employee) {
		Employee savedEmployee =employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}

	@GetMapping("/employeeById/{id}")
	public ResponseEntity<Employee> getUser(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployee(id);
		if(employee==null) {
			throw new GlobalNotFoundException("Employye not found with id"+ id);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getUsers() {
		List<Employee> employees = employeeService.getEmployees();
		if(employees==null) {
			throw new GlobalNotFoundException("Employees not exists");
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
