package Userinterface;

import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel{

    private JButton homeScreen;
    private JButton accountOverview;
    private JButton profileOverview;
    private JButton serieOverview;
    private JButton movieOverview;

    public SideMenu(){
        super(new GridLayout(5, 1));
        createComponents();


    }

    private void createComponents() {
        homeScreen = new JButton("Homescreen");
        accountOverview = new JButton("Account");
        profileOverview = new JButton("Profile");
        serieOverview = new JButton("Serie");
        movieOverview = new JButton("Movie");

        homeScreen.addActionListener(new HomeScreen());
        accountOverview.addActionListener(new OverviewAccount());
        profileOverview.addActionListener(new OverviewProfile());
        serieOverview.addActionListener(new OverviewSerie());
        movieOverview.addActionListener(new OverviewMovie());

        this.add(homeScreen);
        this.add(serieOverview);
        this.add(accountOverview);
        this.add(profileOverview);
        this.add(movieOverview);
    }


}
