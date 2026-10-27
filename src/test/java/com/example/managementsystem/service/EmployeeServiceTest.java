
package com.example.managementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.managementsystem.model.Employee;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void registerEmployeeShouldAssignId() {
        Employee employee = new Employee();
        employee.setName("Arun Kumar");
        employee.setEmail("arun@example.com");
        employee.setDepartment("IT");
        employee.setSalary(25000);

        Employee saved =
                employeeService.registerEmployee(employee);

        assertNotNull(saved);
        assertEquals(1, saved.getId());
        assertEquals(1,
                employeeService.getAllEmployees().size());
    }

    @Test
    void employeeListShouldInitiallyBeEmpty() {
        assertEquals(0,
                employeeService.getAllEmployees().size());
    }
}
