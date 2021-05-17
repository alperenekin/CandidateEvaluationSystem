package com.FinalProject.view;

import com.FinalProject.model.States.HighLevel;

import java.awt.*;

public class AppTheme {
    private static AppTheme instance = new AppTheme();

    private AppTheme(){}

    public static AppTheme instance() {
        return instance;
    }
    public Color tableBackgroundColor(){
        return new  Color(234, 179, 179);
    }

    public Font bodyTextFont(){
        return new Font("Tahome", Font.BOLD,15);
    }

    public Font headerText(){
        return new Font("Serif", Font.BOLD, 30);
    }

    public Font headerTextSmall(){
        return new Font("Serif", Font.BOLD, 20);
    }

    public Color mainBackGroundColor(){
        return new Color(1, 0, 72);
    }

    public Color secondaryBackground(){
        return new Color(244, 222, 251);
    }

    public Color backupBackground(){
        return new Color(51, 41, 72);
    }

    public Color buttonColor(){
        return new Color(75, 0, 72);
    }
}
