package com.FinalProject.model.Candidate;

import com.FinalProject.FileIO;
import com.FinalProject.model.JobAdvert.Position;

/*
 * this is temproary factory method pattern creator . it probably replaced with more meaningfull name 
 */
public class CandidateCreator {
	private String teamaccess; // it probably should access to teams array to add newly created candidate to system . or writing to the file is sufficient i guess
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
		String[] candidateTypes = {"Mobile","Frontend","Web"};
		return candidateTypes;
	}
	
}
