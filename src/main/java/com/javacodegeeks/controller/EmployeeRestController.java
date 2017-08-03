package com.javacodegeeks.controller;

import com.javacodegeeks.model.Employee;
import com.javacodegeeks.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("com.javacodegeeks")
public class EmployeeRestController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<List<Employee>>(employees, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findEmployeeBySsn(String ssn) {
        Employee employee = service.findEmployeeBySsn(ssn);
        if (employee == null) {
            return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee currentEmployee = service.findById(id);
        if (currentEmployee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        currentEmployee.setJoiningDate(employee.getJoiningDate());
        currentEmployee.setName(employee.getName());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setSsn(employee.getSsn());
        service.updateEmployee(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id, @RequestBody String ssn) {
        Employee employee = service.findById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        service.deleteEmployeeBySsn(ssn);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
