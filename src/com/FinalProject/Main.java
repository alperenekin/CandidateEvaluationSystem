package com.FinalProject;

import com.FinalProject.controller.HumanResourceAssistantController;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Employees.ProjectManager;
import com.FinalProject.view.HumanResourceAssistantView;

public class Main {

    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager("Ali","Yilmaz");
        HumanResourceAssistant assistant = new HumanResourceAssistant(manager,"Veli","Acar");
        HumanResourceAssistantView view = new HumanResourceAssistantView(assistant);
        HumanResourceAssistantController controller = new HumanResourceAssistantController(assistant,view);
    }
}
