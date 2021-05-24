package com.FinalProject.controller.LoginController;

import com.FinalProject.Utill.FileIO;
import com.FinalProject.controller.CandidateController.CandidateSignUpController;
import com.FinalProject.controller.TeamController.TeamController;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Candidate.CandidateCreator;
import com.FinalProject.model.Team;
import com.FinalProject.view.CandidateView.CandidateInformationView;
import com.FinalProject.view.CandidateView.CandidateLoginView;
import com.FinalProject.view.CandidateView.CandidateView;
import com.FinalProject.view.LoginView.LoginView;
import com.FinalProject.view.TeamView.TeamView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CandidateLoginController {
	private CandidateLoginView view;
	private ArrayList<Candidate> candidates;
	public CandidateLoginController(CandidateLoginView view){
		this.view = view;
		candidates = FileIO.instance().getCandidates();
		view.addListenerToButton(view.getLoginButton(), new CandidateLoginListener());
	}

	class CandidateLoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Candidate candidateToFind = null;
			for(Candidate candidate: candidates) {
				if(candidate.getPasswd().equals(view.getPassword())&&candidate.getUserName().equals(view.getUsername())) {
					candidateToFind = candidate;
					CandidateInformationView view = new CandidateInformationView(candidate);
				}
			}
			if(candidateToFind == null){
				JOptionPane.showMessageDialog(view.getFrame(),"Candidate can not be found","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}

