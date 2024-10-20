package com.interview.AuthApp.service;

import com.interview.AuthApp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    // create a new employee
    Employee createEmployee(Employee employee);

    // get All Employee
    List<Employee> getAllEmployees();

}
