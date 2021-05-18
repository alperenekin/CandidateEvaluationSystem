package com.FinalProject;

import com.FinalProject.controller.HumanResourceAssistantController;
import com.FinalProject.controller.TeamController;
import com.FinalProject.model.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Employees.HumanResourceManager;
import com.FinalProject.model.Employees.ProjectManager;
import com.FinalProject.model.Employees.Team;
import com.FinalProject.view.CandidateView;
import com.FinalProject.view.TeamView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                ProjectManager manager = new ProjectManager("Ahmet","Yildirim");
                HumanResourceManager hrmanager = new HumanResourceManager(manager,"Ali","Yilmaz");
                HumanResourceAssistant assistant = new HumanResourceAssistant(hrmanager,"Veli","Acar");
                Team team = new Team("Software Team");
                team.addEmployee(manager);
                team.addEmployee(hrmanager);
                team.addEmployee(assistant);
                TeamView view = new TeamView(team);
                TeamController controller = new TeamController(team,view);
                //CandidateView candidateView = new CandidateView(null);
            }
        });

    }
}
