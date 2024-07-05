package com.cristian.villanueva.employees.controller;

import com.cristian.villanueva.employees.model.Employee;
import com.cristian.villanueva.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allemployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/{id}/annual-salary")
    public int getEmployeeAnnualSalary(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employeeService.calculateAnnualSalary(employee);
    }

    @GetMapping("/employees")
    public String getEmployees(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            Employee employee = employeeService.getEmployeeById(id);
            model.addAttribute("employees", Arrays.asList(employee));
        } else {
            List<Employee> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
        }
        return "employees";
    }
}
