package com.FinalProject.model.Candidate;

import com.FinalProject.Utill.FileIO;
import com.FinalProject.model.JobAdvert.Position;

/*
 * this is  factory method pattern creator . 
 */
public class CandidateCreator {
	public CandidateCreator(){
		
	}
	public static Candidate createCandidate(String candidateType,String name, String surname, String cv)
	{	
		Candidate candidate = null;
		Position candidatePosition = Position.valueOf(candidateType);
		if(candidatePosition.equals(Position.Mobile)) {
			candidate=new MobileCandidate(name, surname,cv);
			FileIO.instance().addCandidate(candidate);
			return candidate;
		}
		else if(candidatePosition.equals(Position.Web)){
			candidate = new WebCandidate(name, surname,cv);
			FileIO.instance().addCandidate(candidate);
			return candidate ;
		}
		else if(candidatePosition.equals(Position.Frontend)){
			candidate = new FrontendCandidate(name, surname,cv);
			FileIO.instance().addCandidate(candidate);
			return candidate;
		}
		else {
			return new WebCandidate(name, surname,cv);
		}
		
	}
	public static String[] getCandidateTypes() {
		String[] candidateTypes = {"Mobile","Web","Frontend"};
		return candidateTypes;
	}
	
}
