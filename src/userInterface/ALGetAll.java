package Userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALGetAll implements ActionListener {

    private OverviewAccount oa;
    private int number;

    public ALGetAll(int number) {
        oa = new OverviewAccount();
        this.number  = number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        oa.getAll();
        if(number == 1) {
            oa.getAll();
        }
    }
}
