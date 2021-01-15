package com.faza.example.gettingstartedwithspringboot.model.controller.request;

public class CreateEmployeeRequest {

    private String name;

    private String function;

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
