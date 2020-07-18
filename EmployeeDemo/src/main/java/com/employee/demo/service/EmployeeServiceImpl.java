package com.employee.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.EmployeeRepository;
import com.employee.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
	}

}
