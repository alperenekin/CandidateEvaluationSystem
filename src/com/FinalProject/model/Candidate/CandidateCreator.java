package com.FinalProject.model.Candidate;
/*
 * this is temproary factory method pattern creator . it probably replaced with more meaningfull name 
 */
public class CandidateCreator {
	private String teamaccess; // it probably should access to teams array to add newly created candidate to system . or writing to the file is sufficient i guess
	public CandidateCreator(){
		
	}
	public static void createCandidate(String candidateType)
	{
		if(candidateType.equals("Mobile")) {
			new MobileCandidate("ek", "surname");
		}
	}
}
