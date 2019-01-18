package Userinterface;

import Logic.Serie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OverviewSerie extends JPanel {

    private ArrayList<Serie> allSeries;



    public OverviewSerie() {
        allSeries = new ArrayList<Serie>();
    }

    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        this.add(buttons());

        return this;
    }


    public Box buttons() {
        Box buttonBar = Box.createVerticalBox();

        JButton getAll = new JButton("Get all serie's");
        JButton getSerie= new JButton("Get serie by account");
        getAll.setMaximumSize(new Dimension(150, 100));
        getAll.setMinimumSize(new Dimension(150, 100));
        getSerie.setMaximumSize(new Dimension(150, 100));
        getSerie.setMinimumSize(new Dimension(150, 100));


        buttonBar.add(getAll);
        buttonBar.add(getSerie);


        return buttonBar;

    }
}
