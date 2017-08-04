package com.javacodegeeks;

import com.javacodegeeks.dao.EmployeeDAO;
import com.javacodegeeks.model.Employee;
import com.javacodegeeks.service.EmployeeService;
import com.javacodegeeks.service.EmployeeServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public EmployeeService getEmployeeService() {
        return new EmployeeServiceImpl();
    }

    @Bean
    public EmployeeDAO getEmployeeDAO() {
        EmployeeDAO mockDAO = Mockito.mock(EmployeeDAO.class);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Steven");
        Mockito.when(mockDAO.findById(Mockito.anyInt())).thenReturn(employee);
        return mockDAO;
    }
}
