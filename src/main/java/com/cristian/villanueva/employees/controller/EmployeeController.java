package com.cristian.villanueva.employees.controller;

import com.cristian.villanueva.employees.model.Employee;
import com.cristian.villanueva.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/{id}/annual-salary")
    public double getEmployeeAnnualSalary(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employeeService.calculateAnnualSalary(employee);
    }
}
