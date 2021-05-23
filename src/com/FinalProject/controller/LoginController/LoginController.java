package com.FinalProject.controller.LoginController;

import com.FinalProject.FileIO;
import com.FinalProject.controller.TeamController.TeamController;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Team;
import com.FinalProject.view.LoginView.LoginView;
import com.FinalProject.view.TeamView.TeamView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginController {
    private LoginView view;
    private ArrayList<Candidate> candidates;
    private ArrayList<Team> teams;
    public LoginController(LoginView view){
        this.view = view;
        candidates = FileIO.instance().getCandidates();
        teams = FileIO.instance().getTeams();
        view.addListenerToButton(view.getLoginButton(), new LoginListener());
        view.addListenerToButton(view.getSwitchCandidateLoginButton(), new LoginListener());
        view.addListenerToButton(view.getStartWithoutLogin(), new LoginListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("asfas");
            for(Team team : teams){
                if(team.getTeamName().equals(view.getUsername())){

                }
                TeamView teamView = new TeamView(FileIO.instance().getTeams().get(0));
                TeamController controller = new TeamController(FileIO.instance().getTeams().get(0),teamView);
                view.setVisible(false);
                view.dispose();

            }
        }
    }
}
