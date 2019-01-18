package Userinterface;

import javax.swing.*;
import java.awt.*;


public class OverviewMovie extends JPanel {
    private Color cl;


    public OverviewMovie() {
        cl = new Color(255,0,0);
    }

    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = getAll();
        JComponent panel2 = getMovie();
        JComponent panel3 = getLongestMovieU16();
        tabbedPane.addTab("Get all movies", null, panel1, "Go to all movies");
        tabbedPane.addTab("Get movie", null, panel2, "Search for movie");
        tabbedPane.addTab("Get longest movie U16", null, panel3, "Get longest movie U16");


        this.add(tabbedPane);



        return this;
    }

    public JPanel getAll() {
        JPanel getAll = new JPanel();
        getAll.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komen alle films");

        getAll.add(textArea);

        return getAll;
    }

    public JPanel getMovie() {
        JPanel getMovie = new JPanel();
        getMovie.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komt een film naar keuze");

        getMovie.add(textArea);

        return getMovie;
    }

    public JPanel getLongestMovieU16() {
        JPanel getLongestMovieU16= new JPanel();
        getLongestMovieU16.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier komt de langst durende film, onder de zestien jaar");

        getLongestMovieU16.add(textArea);

        return getLongestMovieU16;

    }


}
