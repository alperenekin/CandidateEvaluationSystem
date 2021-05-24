package com.FinalProject.controller.LoginController;

import com.FinalProject.FileIO;
import com.FinalProject.controller.CandidateController.CandidateSignUpController;
import com.FinalProject.controller.TeamController.TeamController;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Candidate.CandidateCreator;
import com.FinalProject.model.Team;
import com.FinalProject.view.CandidateView.CandidateLoginView;
import com.FinalProject.view.CandidateView.CandidateView;
import com.FinalProject.view.LoginView.LoginView;
import com.FinalProject.view.TeamView.TeamView;

import javax.swing.*;
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
        view.addListenerToButton(view.getStartWithoutLogin(), new CandidateLoginListener());
        view.addListenerToButton(view.getSwitchCandidateLoginButton(), new SwitchLoginListener());
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Team teamToFind = null;
            for(Team team : teams){
                String teamName = team.getTeamName();
                String teamPwd = team.getPassword();
                if(teamName.equals(view.getUsername()) && teamPwd.equals(team.getPassword())){
                    teamToFind = team;
                    TeamView teamView = new TeamView(team);
                    TeamController controller = new TeamController(teamToFind,teamView);
                    view.setVisible(false);
                    view.disposeFrame();
                }
            }
            if(teamToFind == null){
                JOptionPane.showMessageDialog(view.getFrame(),"User can not be found","Alert",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    class CandidateLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CandidateView candidateView = new CandidateView(null, CandidateCreator.getCandidateTypes());
            CandidateSignUpController candidateSignUpController = new CandidateSignUpController(FileIO.instance().getAdverts(), candidateView);
            view.setVisible(false);
            view.disposeFrame();
        }
    }

    class SwitchLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Switch to candidate login page");
            CandidateLoginView candidateLoginView = new CandidateLoginView();
            CandidateLoginController candidateLoginController = new CandidateLoginController(candidateLoginView);
            view.setVisible(false);
            view.disposeFrame();
        }
    }
}
