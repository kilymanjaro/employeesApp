package com.cristian.villanueva.employees.repository;


import com.cristian.villanueva.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static final String EMPLOYEES_API_URL = "http://dummy.restapiexample.com/api/v1/employees";
    private static final String EMPLOYEE_API_URL = "http://dummy.restapiexample.com/api/v1/employee/{id}";

    public EmployeeRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Employee> getAllEmployees() {
        return Collections.singletonList(restTemplate.getForObject(EMPLOYEES_API_URL, Employee.class));
    }

    public Employee getEmployeeById(int id) {
        return restTemplate.getForObject(EMPLOYEE_API_URL, Employee.class, id);
    }
}