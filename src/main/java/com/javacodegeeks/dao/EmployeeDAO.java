package com.javacodegeeks.dao;

import java.util.List;

import com.javacodegeeks.model.Employee;
import com.javacodegeeks.model.Task;

public interface EmployeeDAO {

	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteEmployeeBySsn(String ssn);

	List<Employee> findAllEmployees();

	Employee findEmployeeBySsn(String ssn);
	
	List<Task> getTasksByEmployeeSsn(String ssn);
}
