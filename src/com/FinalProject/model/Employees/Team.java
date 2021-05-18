package com.FinalProject.model.Employees;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;

    private List<IEmployee> employees;

    public Team(String teamName){
        this.teamName = teamName;
        employees = new ArrayList<>();
    }

    public boolean addEmployee(IEmployee employee){
        if(employee != null){
            employees.add(employee);
            return true;
        }else {
            return false;
        }
    }
    public HumanResourceAssistant findAssistant(){
        for(IEmployee employee : employees){
            if (employee instanceof HumanResourceAssistant){
                return (HumanResourceAssistant) employee;
            }
        }
        return null;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<IEmployee> getEmployees() {
        return employees;
    }
}
