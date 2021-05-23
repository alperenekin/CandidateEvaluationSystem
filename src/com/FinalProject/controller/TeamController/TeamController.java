package com.FinalProject.controller.TeamController;

import com.FinalProject.FileIO;
import com.FinalProject.controller.EmployeeController.HumanResourceAssistantController;
import com.FinalProject.model.Candidate.*;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Team;
import com.FinalProject.model.JobAdvert;
import com.FinalProject.model.States.Certain;
import com.FinalProject.view.TeamView.AddJobButton;
import com.FinalProject.view.TeamView.EmployeeDialogView;
import com.FinalProject.view.TeamView.JobAdvertView;
import com.FinalProject.view.TeamView.TeamView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

public class TeamController {
    private Team team;
    private TeamView view;
    private ArrayList<Candidate> pendingCandidates;
    private ArrayList<Candidate> approvedCandidates;
    private Candidate candidate;

    public TeamController(Team team, TeamView view){
        this.team = team;
        this.view = view;
        pendingCandidates = new ArrayList<>();
        approvedCandidates = new ArrayList<>();
        for(Candidate c : FileIO.instance().getCandidates()){
            if(c.getApplicationState() != Certain.instance()){
                pendingCandidates.add(c);
            }else{
                approvedCandidates.add(c);
            }
        }
        view.addCandidateListToTable(view.getPendingCandidates(),pendingCandidates);
        HumanResourceAssistant assistant = team.findAssistant();
        view.addListenerToButton(view.getRateCandidateButton(),new RateCandidateListener(assistant));
        view.addListenerToButton(view.getPostAd(),new AddAdvertListener());


    }

    private String showInputDialog(){
        String result = (String) JOptionPane.showInputDialog(
                view.getFrame(),
                "Enter a candidate to evaluate",
                "Evaluate a candidate",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "1"
        );

        if(result != null && result.length()>0){
            return result;
        }else{
            return null;
        }
    }

    class RateCandidateListener implements ActionListener{
        HumanResourceAssistant assistant;
        public RateCandidateListener(HumanResourceAssistant assistant){
            this.assistant = assistant;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = showInputDialog();
            if(input != null){
                int result =  Integer.parseInt(input);
                candidate = pendingCandidates.stream().filter((Candidate c) -> c.getCandidateId() == result).findAny().orElse(null); //find candidate with given ID
                if(candidate != null){
                    EmployeeDialogView view2 = new EmployeeDialogView(assistant,view.getFrame()); //creates dialog view for taking input
                    HumanResourceAssistantController controller = new HumanResourceAssistantController(candidate,assistant,view2);
                    controller.reviewACandidate();//shows dialog for input, takes input makes evaluation if it passes sends to next person to evaluate, otherwise goes execution from next line and eleminates candidate.
                    if(candidate.getApplicationState() == Certain.instance()){ //if candidate can pass all, it will be added to approved.
                        pendingCandidates.remove(candidate);
                        view.removeRowFromTable(view.getPendingCandidates(),result);
                        approvedCandidates.add(candidate);
                        view.addCandidateToTable(view.getApprovedCandidates(),candidate);
                    }else{//If eliminated, candidate will be deleted from list
                        if(candidate.getTechnicalSkills() != 0 || candidate.getSoftSkills() != 0 || candidate.getCompatibleness() != 0){
                            pendingCandidates.remove(candidate);
                            view.removeRowFromTable(view.getPendingCandidates(),result);
                            JOptionPane.showMessageDialog(view.getFrame(),"The candidate is eliminated!");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(view.getFrame(),"Candidate can not be found","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    class AddAdvertListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AddJobButton jobButton = new AddJobButton("Enter job title, description and requirement,","New Job Advert",view.getFrame());
            jobButton.addListenerToButton(new AddConfirmListener(jobButton));

        }
        class AddConfirmListener implements ActionListener{
            private AddJobButton jobButton;
            public AddConfirmListener(AddJobButton jobButton) {
                this.jobButton = jobButton;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String jobTitle = jobButton.getJobTitle();
                String jobRequirement = jobButton.getReq();
                String jobDescription = jobButton.getDesc();
                JobAdvert job = new JobAdvert(team,jobTitle,jobDescription,jobRequirement,team.getTeamName(),true);
                FileIO.instance().getAdverts().add(job);
                FileIO.instance().saveJobAdvertToFile();
                JobAdvertView jobView = new JobAdvertView(job,false);
                jobButton.setVisible(false);
                view.getTablesPanel().add(jobView);
                view.getFrame().revalidate();
                view.getFrame().repaint();
            }
        }
    }
}
