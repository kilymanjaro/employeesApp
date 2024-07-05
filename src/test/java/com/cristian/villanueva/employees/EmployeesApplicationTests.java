package com.cristian.villanueva.employees;

import com.cristian.villanueva.employees.model.Employee;
import com.cristian.villanueva.employees.service.EmployeeBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeesApplicationTests {

	private final EmployeeBusinessService salaryService = new EmployeeBusinessService();

	@Test
	public void testCalculateAnnualSalary() {
		Employee employee = new Employee();
		employee.setEmployee_salary(5000);

		double annualSalary = salaryService.calculateAnnualSalary(employee);

		assertEquals(60000, annualSalary);
	}

}
