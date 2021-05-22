package com.FinalProject.model;

import com.FinalProject.model.Employees.Employee;
import com.FinalProject.model.Employees.HumanResourceAssistant;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;

    private List<Employee> employees;

    public Team(String teamName){
        this.teamName = teamName;
        employees = new ArrayList<>();
    }

    public boolean addEmployee(Employee employee){
        if(employee != null){
            employees.add(employee);
            return true;
        }else {
            return false;
        }
    }
    public HumanResourceAssistant findAssistant(){
        for(Employee employee : employees){
            if (employee instanceof HumanResourceAssistant){
                return (HumanResourceAssistant) employee;
            }
        }
        return null;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
