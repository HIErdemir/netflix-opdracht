package Userinterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeScreen extends JPanel implements ActionListener {

    private JFrame homeframe;
    private SwitchPanel sw;

    public HomeScreen() {
        this.setLayout(new GridLayout());

        try {
            // Specify the path to the image
            BufferedImage image = ImageIO.read(new File("./Image/Netflix.jpg"));
            // Define a label, which shows the image in the form of an ImageIcon
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Add the image and constraints to the Homescreen
            this.add(imageLabel);
        } catch (IOException a) {
            System.out.println(a);
        }
        this.setBackground(new Color(255, 7, 56));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setLayout(new GridLayout());

        try {
            // Specify the path to the image
            BufferedImage image = ImageIO.read(new File("./Image/Netflix.jpg"));
            // Define a label, which shows the image in the form of an ImageIcon
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Add the image and constraints to the Homescreen
            this.add(imageLabel);
        } catch (IOException a) {
            System.out.println(a);
        }
        jpanel();
    }


    public JPanel jpanel() {
        return this;
    }
}


