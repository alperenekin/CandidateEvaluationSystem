package com.FinalProject;

import com.FinalProject.controller.CandidateController.CandidateSignUpController;
import com.FinalProject.controller.TeamController.TeamController;
import com.FinalProject.model.JobAdvert;
import com.FinalProject.model.Team;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Candidate.CandidateCreator;
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
                ArrayList<Team> a = FileIO.instance().getTeams();
                ArrayList<Candidate> b = FileIO.instance().getCandidates();
                ArrayList<JobAdvert> c = FileIO.instance().getAdverts();
                //System.out.println(c.get(0).getPosition());

                TeamView view = new TeamView(FileIO.instance().getTeams().get(0));
                TeamController controller = new TeamController(FileIO.instance().getTeams().get(0),view);
                String[] den = CandidateCreator.getCandidateTypes();
                System.out.println(den.length);
                CandidateView candidateView = new CandidateView(null,den);
                CandidateSignUpController candidateSignUpController = new CandidateSignUpController(c, candidateView);

            }
        });

    }
}
