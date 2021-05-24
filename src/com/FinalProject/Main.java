package com.FinalProject;

import com.FinalProject.Utill.AppInitializer;
import com.FinalProject.Utill.FileIO;
import com.FinalProject.controller.LoginController.LoginController;
import com.FinalProject.model.JobAdvert.JobAdvert;
import com.FinalProject.model.Team;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.LoginView.LoginView;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                AppInitializer appInit = new AppInitializer();
                ArrayList<Team> a = FileIO.instance().getTeams();
                ArrayList<Candidate> b = FileIO.instance().getCandidates();
                ArrayList<JobAdvert> c = FileIO.instance().getAdverts();
                LoginView loginView = new LoginView();
                LoginController loginController = new LoginController(loginView);

            }
        });

    }
}
