package com.faza.example.gettingstartedwithspringboot.service.impl;

import com.faza.example.gettingstartedwithspringboot.model.controller.request.CreateEmployeeRequest;
import com.faza.example.gettingstartedwithspringboot.model.controller.request.UpdateEmployeeRequest;
import com.faza.example.gettingstartedwithspringboot.model.database.Employee;
import com.faza.example.gettingstartedwithspringboot.repository.EmployeeRepository;
import com.faza.example.gettingstartedwithspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setFunction(request.getFunction());
        employeeRepository.save(employee);
    }

    @Override
    public void update(Integer id, UpdateEmployeeRequest request) {
        Employee employee = findById(id);
        employee.setFunction(request.getFunction());
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
