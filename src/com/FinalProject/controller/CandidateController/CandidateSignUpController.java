package com.FinalProject.controller.CandidateController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.FinalProject.model.Candidate.CandidateCreator;
import com.FinalProject.view.CandidateView.CandidateView;

public class CandidateSignUpController {
	private CandidateView view;
	public CandidateSignUpController(CandidateView candidateView) {
		this.view = candidateView;
		view.addLoginListener(new SignUpListener());
	}
	class SignUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(view.getComboBoxInput());
			System.out.println("wtf");
			CandidateCreator.createCandidate(view.getComboBoxInput());
			
		}
		
	}

}
