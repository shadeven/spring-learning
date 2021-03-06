package com.javacodegeeks.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.javacodegeeks.model.Employee;
import com.javacodegeeks.model.Task;

@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO<Integer, Employee> implements EmployeeDAO {

	public Employee findById(int id) {
        return getByKey(id);
    }

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	public void deleteEmployeeBySsn(String ssn) {
        Employee employee = findEmployeeBySsn(ssn);
        if (employee != null) {
            delete(employee);
        }
    }

	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

	public List<Task> getTasksByEmployeeSsn(String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		if (employee != null) {
			List<Task> tasks = employee.getTasks();
			Hibernate.initialize(tasks);
			return tasks;
		}
		
		return Collections.emptyList();
	}
}
