package com.cristian.villanueva.employees.service;

import com.cristian.villanueva.employees.config.AppConfig;
import com.cristian.villanueva.employees.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1";


    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        String url = BASE_URL + "/employees";
        EmployeeResponse response = restTemplate.getForObject(url, EmployeeResponse.class);
        return response.getEmployees();
    }

    public Employee getEmployeeById(long id) {
        String url = BASE_URL + "/employee/" + id;
        return restTemplate.getForObject(url, Employee.class);
    }
    public int calculateAnnualSalary(Employee employee) {
        return employee.getEmployee_salary() * 12;
    }
}