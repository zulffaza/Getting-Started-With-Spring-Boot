package com.faza.example.gettingstartedwithspringboot.repository;

import com.faza.example.gettingstartedwithspringboot.model.database.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
