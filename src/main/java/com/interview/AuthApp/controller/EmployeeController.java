package com.interview.AuthApp.controller;

import com.interview.AuthApp.model.Employee;
import com.interview.AuthApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        Employee employeeObj=employeeService.createEmployee(employee);
        if(employeeObj !=null){
            return ResponseEntity.ok(employeeObj);
        }
        else{
            return ResponseEntity.status(400).body("Failed to create Employee");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllEmployees(){
        List<Employee>employeeList=employeeService.getAllEmployees();
       if(!employeeList.isEmpty()){
           return ResponseEntity.ok(employeeList);
       }
       else{
            return ResponseEntity.status(400).body("Failed to get all Employees");
       }
    }


}
