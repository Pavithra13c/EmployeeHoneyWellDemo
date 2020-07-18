package com.employee.demo.service;

import java.util.List;

import com.employee.demo.entity.Employee;

public interface EmployeeService {

	public Employee getEmployee(int id);

	public Employee saveEmployee(Employee employee);

	public List<Employee> getEmployees();
	
	public void deleteEmployee(int id);
}
