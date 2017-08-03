package com.javacodegeeks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacodegeeks.dao.EmployeeDAO;
import com.javacodegeeks.model.Employee;
import com.javacodegeeks.model.Task;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	public Employee findById(int id) {
		return dao.findById(id);
	}

	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if (entity != null) {
			entity.setId(employee.getId());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
		}
	}

	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}

	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	public Employee findEmployeeBySsn(String ssn) {
		return dao.findEmployeeBySsn(ssn);
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return (employee == null || ((id != null) && (employee.getId() == id)));
	}

	public List<Task> getTasksByEmployeeSsn(String ssn) {
		return dao.getTasksByEmployeeSsn(ssn);
	}
}
