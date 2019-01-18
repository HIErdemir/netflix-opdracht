package Userinterface;


import javax.swing.*;
import java.awt.*;


public class OverviewSerie extends JPanel {
    private Color cl;

    public OverviewSerie() {
        cl = new Color(255,0,0);
    }
    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = getAll();
        JComponent panel2 = getSerie();
        tabbedPane.addTab("Get all serie's", null, panel1, "Go to all serie's");
        tabbedPane.addTab("Get serie", null, panel2, "Search for serie");


        this.add(tabbedPane);



        return this;
    }

    public JPanel getAll() {
        JPanel getAll = new JPanel();
        getAll.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komen alle serie's");

        getAll.add(textArea);

        return getAll;
    }

    public JPanel getSerie() {
        JPanel getSerie = new JPanel();
        getSerie.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komt een serie naar keuze, om tijdsduur te bekijken");

        getSerie.add(textArea);

        return getSerie;
    }

}
