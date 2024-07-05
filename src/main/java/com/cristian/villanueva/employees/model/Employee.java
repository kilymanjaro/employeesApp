package com.cristian.villanueva.employees.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Employee {
    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;
}