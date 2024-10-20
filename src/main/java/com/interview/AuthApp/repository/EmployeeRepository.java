package com.interview.AuthApp.repository;

import com.interview.AuthApp.model.Employee;
import com.interview.AuthApp.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
