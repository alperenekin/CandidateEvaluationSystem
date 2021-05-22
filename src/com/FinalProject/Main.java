package com.FinalProject;

import com.FinalProject.controller.CandidateController.CandidateSignUpController;
import com.FinalProject.controller.TeamController.TeamController;
import com.FinalProject.view.CandidateView.CandidateView;
import com.FinalProject.view.TeamView.TeamView;

import javax.swing.*;
import java.lang.reflect.Array;
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
                AppInitializer appInit = new AppInitializer();
                ArrayList a = FileIO.instance().getTeams();
                ArrayList b = FileIO.instance().getCandidates();
                ArrayList c = FileIO.instance().getAdverts();


                TeamView view = new TeamView(FileIO.instance().getTeams().get(0));
                TeamController controller = new TeamController(FileIO.instance().getTeams().get(0),view);
                CandidateView candidateView = new CandidateView(null);
                CandidateSignUpController candidateSignUpController = new CandidateSignUpController(candidateView);

            }
        });

    }
}
