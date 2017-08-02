package com.javacodegeeks.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.javacodegeeks.model.Employee;

@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO<Integer, Employee> implements EmployeeDAO {

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub

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

}
