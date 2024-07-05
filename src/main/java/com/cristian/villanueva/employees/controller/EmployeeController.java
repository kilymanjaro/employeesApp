package com.cristian.villanueva.employees.controller;

import com.cristian.villanueva.employees.model.Employee;
import com.cristian.villanueva.employees.repository.EmployeeRepository;
import com.cristian.villanueva.employees.service.EmployeeBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeBusinessService salaryService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping("/employee/{id}/annual-salary")
    public double getEmployeeAnnualSalary(@PathVariable int id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        return salaryService.calculateAnnualSalary(employee);
    }
}
