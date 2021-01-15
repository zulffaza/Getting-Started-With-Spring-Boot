package com.faza.example.gettingstartedwithspringboot.service;

import com.faza.example.gettingstartedwithspringboot.model.controller.request.CreateEmployeeRequest;
import com.faza.example.gettingstartedwithspringboot.model.controller.request.UpdateEmployeeRequest;
import com.faza.example.gettingstartedwithspringboot.model.database.Employee;

import java.util.List;

public interface EmployeeService {

    void create(CreateEmployeeRequest request);

    void update(Integer id, UpdateEmployeeRequest request);

    void delete(Integer id);

    List<Employee> findAll();

    Employee findById(Integer id);
}
