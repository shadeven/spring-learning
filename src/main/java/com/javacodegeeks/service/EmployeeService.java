package com.javacodegeeks.service;

import java.util.List;

import com.javacodegeeks.model.Employee;
import com.javacodegeeks.model.Task;

public interface EmployeeService {
	
	Employee findById(int id);
    
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
 
    List<Employee> findAllEmployees(); 
     
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);

    List<Task> getTasksByEmployeeSsn(String ssn);
}

