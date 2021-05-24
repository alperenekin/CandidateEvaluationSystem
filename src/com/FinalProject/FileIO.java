package com.FinalProject;


import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Candidate.CandidateAdapter;
import com.FinalProject.model.Candidate.MobileCandidate;
import com.FinalProject.model.Employees.*;
import com.FinalProject.model.JobAdvert.JobAdvert;
import com.FinalProject.model.JobAdvert.Position;
import com.FinalProject.model.States.BaseState;
import com.FinalProject.model.States.StateAdapter;
import com.FinalProject.model.Team;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileIO {
    private  GsonBuilder gsonBuilder;
    private static Gson gson;
    private static FileIO instance = new FileIO();


    private ArrayList<Team> teams;
    private ArrayList<JobAdvert> adverts;
    private ArrayList<Candidate> candidates;


    private FileIO() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Employee.class, new EmployeeAdapter()); //Adapters for seralizing and deserializing are added
        gsonBuilder.registerTypeAdapter(Candidate.class, new CandidateAdapter()); //Adapters for seralizing and deserializing are added
        gsonBuilder.registerTypeAdapter(BaseState.class, new StateAdapter()); //Adapters for seralizing and deserializing are added
        gson = gsonBuilder.create();
    }

    public static FileIO instance() {
        return instance;
    }

    public void readTeamsFromFile(){
        try (JsonReader reader = new JsonReader(new FileReader("teams.json"))) {
            Type teamType = new TypeToken<ArrayList<Team>>() {}.getType();// In order to parse for User Type.
            teams = gson.fromJson(reader, teamType);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveTeamsToFile(){
//        teams = new ArrayList<>();
//        ProjectManager manager = new ProjectManager("Ahmet","Yildirim");
//        HumanResourceManager hrmanager = new HumanResourceManager(manager,"Ali","Yilmaz");
//        HumanResourceAssistant assistant = new HumanResourceAssistant(hrmanager,"Veli","Acar");
//        Team team = new Team("Software Team","software");
//        team.addEmployee(manager);
//        team.addEmployee(hrmanager);
//        team.addEmployee(assistant);
//        teams.add(team);
        try (Writer writer = new FileWriter("teams.json")){
            gson.toJson(teams, writer);
            writer.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Saving to file is succesful.");
    }

    public void readJobAdvertsFromFile(){
        try (JsonReader reader = new JsonReader(new FileReader("jobadverts.json"))) {
            Type jobType = new TypeToken<ArrayList<JobAdvert>>() {}.getType();// In order to parse for User Type.
            adverts = gson.fromJson(reader, jobType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveJobAdvertToFile(){
//    	adverts = new ArrayList<>();
//        JobAdvert advert = new JobAdvert(teams.get(0),"Mobile Dev","Junior mobile developer is needed","Graduated from computer engineering, at least 3 gpa", Position.Mobile,true );
//        adverts.add(advert);
        try (Writer writer = new FileWriter("jobadverts.json")){
            gson.toJson(adverts, writer);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saving to file is succesful.");
    }

    public void readCandidatesFromFile(){
        try (JsonReader reader = new JsonReader(new FileReader("candidates.json"))) {
            Type candidateType = new TypeToken<ArrayList<Candidate>>() {}.getType();// In order to parse for User Type.
            candidates = gson.fromJson(reader, candidateType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCandidatesToFile(){
//       candidates = new ArrayList<>();
//       MobileCandidate candidate1 = new MobileCandidate("Alperen","Ekin");
//       MobileCandidate candidate2 = new MobileCandidate("Ekin","Tepebas");
//       MobileCandidate candidate3 = new MobileCandidate("Ahmet","Yilmaz");
//       candidates.add(candidate1); candidates.add(candidate2); candidates.add(candidate3);
        try (Writer writer = new FileWriter("candidates.json")){
            Type candidateType = new TypeToken<ArrayList<Candidate>>() {}.getType();// In order to parse for User Type.
            String jsonString = gson.toJson(candidates, candidateType);
            writer.append(jsonString);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saving to file is succesful.");
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public ArrayList<JobAdvert> getAdverts() {
        return adverts;
    }
    public void addCandidate(Candidate candidate) {
    	candidates.add(candidate);
    	saveCandidatesToFile();
    }
    public void addTeam(Team team) {
    	teams.add(team);    	
    }
    public void addJobAdvert(JobAdvert jobAdvert) {
    	adverts.add(jobAdvert);
    	saveJobAdvertToFile();
    }
    
}
