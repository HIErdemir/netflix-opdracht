package Userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewProfile extends JPanel {
    private Color cl;

    public OverviewProfile(){
        cl = new Color(255,0,0);
    }

    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = getAll();
        JComponent panel2 = getProfile();
        JComponent panel3 = inputProfile();
        JComponent panel4 = updateProfile();
        JComponent panel5 = deleteProfile();
        tabbedPane.addTab("Get all profiles", null, panel1, "Go to all profiles");
        tabbedPane.addTab("Get profile", null, panel2, "Search for profile");
        tabbedPane.addTab("Input profile", null, panel3, "Input profile");
        tabbedPane.addTab("Update profile", null, panel4, "Update profile");
        tabbedPane.addTab("Verwijder profile", null, panel5, "Verwijder profile");

        this.add(tabbedPane);



        return this;
    }

    public JPanel getAll() {
        JPanel getAll = new JPanel();
        getAll.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komen alle profielen");

        getAll.add(textArea);

        return getAll;
    }

    public JPanel getProfile() {
        JPanel getProfile = new JPanel();
        getProfile.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komt een profiel naar keuze");

        getProfile.add(textArea);

        return getProfile;
    }

    public JPanel inputProfile() {
        JPanel inputProfile = new JPanel();
        inputProfile.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier kan een gebruiker een profiel toevoegen");

        inputProfile.add(textArea);

        return inputProfile;

    }

    public JPanel updateProfile() {
        JPanel updateProfile = new JPanel();
        updateProfile.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier kan een gebruiker een profiel updaten");

        updateProfile.add(textArea);

        return updateProfile;

    }

    public JPanel deleteProfile() {
        JPanel deleteProfile = new JPanel();
        deleteProfile.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier kan een gebruiker een profiel verwijderen");

        deleteProfile.add(textArea);

        return deleteProfile;
    }




}
