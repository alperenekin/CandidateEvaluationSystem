package com.FinalProject.model;

import com.FinalProject.model.Employees.Employee;
import com.FinalProject.model.Employees.HumanResourceAssistant;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private String password;
    private List<Employee> employees;

    public Team(String teamName, String password){
        this.teamName = teamName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
