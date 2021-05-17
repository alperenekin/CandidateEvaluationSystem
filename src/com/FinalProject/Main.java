package com.FinalProject;

import com.FinalProject.controller.HumanResourceAssistantController;
import com.FinalProject.controller.TeamController;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Employees.HumanResourceManager;
import com.FinalProject.model.Employees.ProjectManager;
import com.FinalProject.view.TeamView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                ProjectManager manager = new ProjectManager("afas","12");
                HumanResourceManager hrmanager = new HumanResourceManager(manager,"Ali","Yilmaz");
                HumanResourceAssistant assistant = new HumanResourceAssistant(hrmanager,"Veli","Acar");
                TeamView view = new TeamView(assistant);
                TeamController controller = new TeamController(assistant,view);            }
        });

    }
}
