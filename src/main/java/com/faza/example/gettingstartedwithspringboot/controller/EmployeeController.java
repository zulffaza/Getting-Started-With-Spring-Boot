package com.faza.example.gettingstartedwithspringboot.controller;

import com.faza.example.gettingstartedwithspringboot.model.controller.request.CreateEmployeeRequest;
import com.faza.example.gettingstartedwithspringboot.model.controller.request.UpdateEmployeeRequest;
import com.faza.example.gettingstartedwithspringboot.model.controller.response.EmployeeResponse;
import com.faza.example.gettingstartedwithspringboot.model.database.Employee;
import com.faza.example.gettingstartedwithspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateEmployeeRequest request) {
        employeeService.create(request);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody UpdateEmployeeRequest request) {
        employeeService.update(id, request);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll()
                .stream()
                .map(this::convertIntoEmployeeResponse)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse findById(@PathVariable Integer id) {
        return convertIntoEmployeeResponse(employeeService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        employeeService.delete(id);
    }

    private EmployeeResponse convertIntoEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setFunction(employee.getFunction());
        return employeeResponse;
    }
}
