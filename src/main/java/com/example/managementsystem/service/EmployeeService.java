
package com.example.managementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.managementsystem.model.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    public Employee registerEmployee(Employee employee) {
        employee.setId(nextId.getAndIncrement());
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
