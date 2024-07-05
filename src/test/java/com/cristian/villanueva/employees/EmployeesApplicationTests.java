package com.cristian.villanueva.employees;

import com.cristian.villanueva.employees.model.Employee;
import com.cristian.villanueva.employees.model.EmployeeResponse;
import com.cristian.villanueva.employees.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import java.util.List;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeesApplicationTests {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


	@Test
	public void testCalculateAnnualSalary() {
		Employee employee = new Employee();
		employee.setEmployee_salary(5000);

		int annualSalary = employeeService.calculateAnnualSalary(employee);

		assertEquals(60000, annualSalary);
	}

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setEmployee_name("John Doe");
        employee1.setEmployee_salary(5000);
        employee1.setEmployee_age(30);
        employee1.setProfile_image("");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setEmployee_name("Jane Doe");
        employee2.setEmployee_salary(6000);
        employee2.setEmployee_age(25);
        employee2.setProfile_image("");

        List<Employee> employeeList = Arrays.asList(employee1, employee2);
        EmployeeResponse mockResponse = new EmployeeResponse();
        mockResponse.setStatus("success");
        mockResponse.setEmployees(employeeList);

        when(restTemplate.getForObject(anyString(), any(Class.class))).thenReturn(mockResponse);

        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getEmployee_name());
        assertEquals("Jane Doe", result.get(1).getEmployee_name());
    }

    @Test
    public void testGetEmployeeById() {
        Employee mockEmployee = new Employee();
        mockEmployee.setId(1);
        mockEmployee.setEmployee_name("John Doe");
        mockEmployee.setEmployee_salary(5000);
        mockEmployee.setEmployee_age(30);
        mockEmployee.setProfile_image("");

        when(restTemplate.getForObject(anyString(), any(Class.class))).thenReturn(mockEmployee);

        Employee result = employeeService.getEmployeeById(1L);
        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getEmployee_name());
        assertEquals(5000, result.getEmployee_salary());
        assertEquals(30, result.getEmployee_age());
    }

}
