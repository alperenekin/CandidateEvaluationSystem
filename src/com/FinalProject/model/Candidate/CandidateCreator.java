package com.FinalProject.model.Candidate;

import com.FinalProject.FileIO;

/*
 * this is temproary factory method pattern creator . it probably replaced with more meaningfull name 
 */
public class CandidateCreator {
	private String teamaccess; // it probably should access to teams array to add newly created candidate to system . or writing to the file is sufficient i guess
	public CandidateCreator(){
		
	}
	public static Candidate createCandidate(String candidateType,String name, String surname, String cv)
	{	
		Candidate c = null; 
		System.out.println("candidatetype ////"+candidateType );
		if(candidateType.equals("Mobile")) {
			c=new MobileCandidate(name, surname,cv);
			FileIO.instance().addCandidate(c);
			return c;
		}
		else if(candidateType.equals("Web")) {
			c = new WebCandidate(name, surname,cv);
			FileIO.instance().addCandidate(c);
			return c ;
		}
		else if(candidateType.equals("Frontend")) {
			c = new FrontendCandidate(name, surname,cv);
			FileIO.instance().addCandidate(c);
			return c;
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
