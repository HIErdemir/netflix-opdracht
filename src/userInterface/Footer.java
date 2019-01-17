package Userinterface;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    private JLabel projectName;
    private JLabel courseName;
    private JLabel courseYear;
    private JLabel classCode;
    private JLabel studentname1;
    private JLabel studentname2;
    private JLabel studentname3;


    public Footer() {
        super(new GridLayout(1, 1));
        createComponents();
    }

    private void createComponents() {

        projectName = new JLabel("Netflix Statistix");
        projectName.setFont(new Font("Serif", Font.PLAIN, 14));
        courseName = new JLabel("Informatica");
        courseName.setFont(new Font("Serif", Font.PLAIN, 14));
        courseYear = new JLabel("Year 1");
        courseYear.setFont(new Font("Serif", Font.PLAIN, 14));
        classCode = new JLabel("23IVT1D1");
        classCode.setFont(new Font("Serif", Font.PLAIN, 14));
        studentname1 = new JLabel("Ahmet Özkan");
        studentname1.setFont(new Font("Serif", Font.PLAIN, 14));
        studentname2 = new JLabel("Halil Erdemir");
        studentname2.setFont(new Font("Serif", Font.PLAIN, 14));
        studentname3 = new JLabel("Lars Siereveld");
        studentname3.setFont(new Font("Serif", Font.PLAIN, 14));

        this.add(projectName);
        this.add(courseName);
        this.add(courseYear);
        this.add(classCode);
        this.add(studentname1);
        this.add(studentname2);
        this.add(studentname3);


    }



}