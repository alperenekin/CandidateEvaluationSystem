package com.FinalProject;

import com.FinalProject.Utill.AppUtill;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Team;
import com.FinalProject.model.JobAdvert;

public class AppInitializer {

    public AppInitializer(){
        FileIO.instance().readJobAdvertsFromFile();
        FileIO.instance().readTeamsFromFile();
        FileIO.instance().readCandidatesFromFile();
        initJobAdverts();
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
}
