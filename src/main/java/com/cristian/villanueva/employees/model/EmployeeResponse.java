package com.cristian.villanueva.employees.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponse {
    private String status;

    @JsonProperty("data")
    private List<Employee> employees;

    private String message;
}