package com.FinalProject;

import com.FinalProject.Utill.AppUtill;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.States.Certain;
import com.FinalProject.model.States.HighLevel;
import com.FinalProject.model.States.MidLevel;
import com.FinalProject.model.States.Starter;
import com.FinalProject.model.Team;
import com.FinalProject.model.JobAdvert.JobAdvert;

import java.io.File;
import java.util.ArrayList;

public class AppInitializer {

    public AppInitializer(){
//       FileIO.instance().saveCandidatesToFile();   //this methods are left with in case of initialization or corrupted files.
//       FileIO.instance().saveTeamsToFile();
//       FileIO.instance().saveJobAdvertToFile();

        FileIO.instance().readTeamsFromFile();
        FileIO.instance().readCandidatesFromFile();
        FileIO.instance().readJobAdvertsFromFile();

        initJobAdverts();
        initCandidateStates();
        findHighestCandidateId();
    }

    private void initJobAdverts(){
        for(Team team : FileIO.instance().getTeams()){
            for(JobAdvert job : FileIO.instance().getAdverts()){
                if(job.getTeam().getTeamName().equals(team.getTeamName())){
                    job.setTeam(team);
                }
            }
        }

        for(JobAdvert job : FileIO.instance().getAdverts()){
            ArrayList<Candidate> candidates = new ArrayList<>();
            for(Candidate applicant : job.getAppliedCandidates()){
                for(Candidate candidate : FileIO.instance().getCandidates()){
                    if(applicant.getCandidateId() == candidate.getCandidateId()) {
                        candidates.add(candidate);
                    }
                }
            }
            job.setAppliedCandidates(candidates);
        }
    }

    private void findHighestCandidateId(){
        int max = 0;
        for(Candidate candidate : FileIO.instance().getCandidates()){
            if(candidate.getCandidateId() > max){
                max = candidate.getCandidateId();
            }
        }
        AppUtill.candidateId = max+1;
    }

    private void initCandidateStates(){
        for(Candidate candidate : FileIO.instance().getCandidates()) {
            if(candidate.getApplicationState() instanceof Starter){
                candidate.setApplicationState(Starter.instance());
            }
            else if(candidate.getApplicationState() instanceof MidLevel){
                candidate.setApplicationState(MidLevel.instance());
            }else if(candidate.getApplicationState() instanceof HighLevel){
                candidate.setApplicationState(HighLevel.instance());
            }
            else if(candidate.getApplicationState() instanceof Certain){
                candidate.setApplicationState(Certain.instance());
            }
        }
    }
}
