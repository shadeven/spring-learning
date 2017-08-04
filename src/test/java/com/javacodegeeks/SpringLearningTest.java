package com.javacodegeeks;

import static org.junit.Assert.*;

import com.javacodegeeks.model.Employee;
import com.javacodegeeks.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class SpringLearningTest {

    @Autowired
    private EmployeeService service;

    @Test
    public void testEmployeeService() {
        assertEquals("com.javacodegeeks.service.EmployeeServiceImpl", this.service.getClass().getCanonicalName());
    }

    @Test
    public void testUpdateEmployee() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(2);

        // Act
        service.updateEmployee(employee);

        // Assert
        assertEquals(employee.getId(), 2);
    }
}
