package com.FinalProject.controller.CandidateController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.FinalProject.model.JobAdvert;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Candidate.CandidateCreator;
import com.FinalProject.view.CandidateView.CandidateView;

public class CandidateSignUpController {
	private CandidateView view;
	ArrayList<JobAdvert> jobs;
	public CandidateSignUpController(ArrayList<JobAdvert> jobAdverts, CandidateView candidateView) {
		this.view = candidateView;
		this.jobs = jobAdverts;
		view.addLoginListener(new SignUpListener());
		view.addComboBoxListener(new ComboboxListener());
		view.addSubComboBoxListener(new titleComboBoxListener());
	}
	class SignUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(view.getCandidateTypeComboBoxInput());
			
			String jobTitle = view.getJobTitleComboBoxInput();
			//System.out.println(jobTitle);
			JobAdvert job = findJobAdvertFromJobTitle(jobTitle);
			String userName = view.getUserName();
			String userSurname = view.getUserSurname();
			String cv = view.getUserCv();
			Candidate c = CandidateCreator.createCandidate(view.getCandidateTypeComboBoxInput(),userName,userSurname,cv);
			job.addCandidate(c);
			//GET THE OTHER COMBOBOX INPUT ALSO
		}
		
	}
	class titleComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String jobTitle = view.getJobTitleComboBoxInput();
			JobAdvert job = findJobAdvertFromJobTitle(jobTitle);
			view.addJobAdvertPanel(job);
			
		}
		
	}
	class ComboboxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("works."+view.getCandidateTypeComboBoxInput());
			ArrayList<JobAdvert> subComboAdverts = getRelatedAdverts(view.getCandidateTypeComboBoxInput());
			String[] positions = getRelatedPositionsFromAdverts(subComboAdverts);
			view.updateJobComboBox(positions);
			
		}

		private String[] getRelatedPositionsFromAdverts(ArrayList<JobAdvert> subComboAdverts) {
			ArrayList<String> aList = new ArrayList<String>();
			for (JobAdvert job:subComboAdverts) {
				System.out.println(job.getPosition());
				aList.add(job.getTitle());
			}
			
			return aList.toArray(new String[0]);
		}
		
	}
	private ArrayList<JobAdvert> getRelatedAdverts(String comboBoxInput) {
		ArrayList<JobAdvert> retList = new ArrayList<JobAdvert>();
		for(JobAdvert job: this.jobs) {
			if(comboBoxInput.equals((job.getPosition()))) {
				retList.add(job);
			}
		}
		return retList;
		
	}
	public JobAdvert findJobAdvertFromJobTitle(String position) {
		JobAdvert j= null;
		for (JobAdvert job: jobs) {
			if(job.getTitle().equals(position)) {
				j = job;
			}
		}
		return j;
	}

}
