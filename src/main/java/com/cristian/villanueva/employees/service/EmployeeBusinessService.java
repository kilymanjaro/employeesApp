package com.cristian.villanueva.employees.service;

import com.cristian.villanueva.employees.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBusinessService {

    public double calculateAnnualSalary(Employee employee) {
        return employee.getEmployee_salary() * 12;
    }
}