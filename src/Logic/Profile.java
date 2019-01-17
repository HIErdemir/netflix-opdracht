package Logic;

import java.util.ArrayList;

public class Profile {

    private int profileID;
    private String name;
    private String age;
    private int AccountID;
    private ArrayList<ViewedProgram> viewedPrograms;


    public Profile(String name, String birthdate, int profileID) {}

    public void addViewedProgram(ViewedProgram program){}

    public void deleteViewedProgram(ViewedProgram program) {}

    public void updateViewedProgram(ViewedProgram progam) {}

    private ArrayList<ViewedProgram> getViewedProgams() {return this.viewedPrograms;}

    public int getProfileID() {
        return profileID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getAccountID() {
        return AccountID;
    }

}



