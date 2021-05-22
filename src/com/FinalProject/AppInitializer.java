package com.FinalProject;

import com.FinalProject.model.Team;
import com.FinalProject.model.JobAdvert;

public class AppInitializer {

    public AppInitializer(){
        FileIO.instance().readJobAdvertsFromFile();
        FileIO.instance().readTeamsFromFile();
        FileIO.instance().readCandidatesFromFile();
        initJobAdverts();
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
}
