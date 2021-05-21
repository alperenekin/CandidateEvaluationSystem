package com.FinalProject;

import com.FinalProject.controller.CandidateSignUpController;
import com.FinalProject.controller.HumanResourceAssistantController;
import com.FinalProject.controller.TeamController;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Employees.HumanResourceManager;
import com.FinalProject.model.Employees.ProjectManager;
import com.FinalProject.model.Employees.Team;
import com.FinalProject.view.CandidateView;
import com.FinalProject.view.TeamView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
//
//                ProjectManager manager = new ProjectManager("Ahmet","Yildirim");
//                HumanResourceManager hrmanager = new HumanResourceManager(manager,"Ali","Yilmaz");
//                HumanResourceAssistant assistant = new HumanResourceAssistant(hrmanager,"Veli","Acar");
//                Team team = new Team("Software Team");
//                team.addEmployee(manager);
//                team.addEmployee(hrmanager);
//                team.addEmployee(assistant);
//
//                Team team2 = new Team("Software Team");
//                team2.addEmployee(manager);
//                team2.addEmployee(hrmanager);
//                team2.addEmployee(assistant);
//
//                ArrayList<Team> teams = new ArrayList<>();
//                teams.add(team); teams.add(team2);
                FileIO.instance().readCandidatesFromFile();
                FileIO.instance().readTeamsFromFile();
                TeamView view = new TeamView(FileIO.instance().getTeams().get(0));
                TeamController controller = new TeamController(FileIO.instance().getTeams().get(0),view);
                CandidateView candidateView = new CandidateView(null);
                CandidateSignUpController candidateSignUpController = new CandidateSignUpController(candidateView);

            }
        });

    }
}
