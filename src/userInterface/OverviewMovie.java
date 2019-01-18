package Userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewMovie extends JPanel implements ActionListener {

    private int choice;
    private JPanel jpanel;

    public OverviewMovie(int i) {
        this.choice = i;
    }

    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        this.add(buttons(), BorderLayout.SOUTH);
        if(this.choice > 0) {
            this.add(this.jpanel);
        }
        return this;
    }


    public Box buttons() {
        Box buttonBar = Box.createVerticalBox();

        JButton getAll = new JButton("Get all movie's");
        JButton getMovie= new JButton("Get movie by account");
        getAll.setMaximumSize(new Dimension(150, 100));
        getAll.setMinimumSize(new Dimension(150, 100));
        getMovie.setMaximumSize(new Dimension(150, 100));
        getMovie.setMinimumSize(new Dimension(150, 100));

        getAll.addActionListener(new OverviewMovie(1));


        buttonBar.add(getAll);
        buttonBar.add(getMovie);


        return buttonBar;

    }


    public void getAll() {
        JPanel jpGetAll = new JPanel();

        JTextArea textArea = new JTextArea("Test");

        jpGetAll.add(textArea);

        this.jpanel = jpGetAll;
        jpanel();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.choice == 1) {
            getAll();
        }
    }
}
