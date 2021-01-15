package com.faza.example.gettingstartedwithspringboot.model.controller.response;

public class EmployeeResponse {

    private Integer id;

    private String name;

    private String function;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
