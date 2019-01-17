package Logic;

import java.util.ArrayList;

public class Profile {

    private int profileID;
    private String name;
    private int age;
    private ArrayList<ViewedProgram> viewedPrograms;


    public Profile(String name, String birthdate, int profileID) {}

    public void addViewedProgram(ViewedProgram program){}

    public void deleteViewedProgram(ViewedProgram program) {}

    public void updateViewedProgram(ViewedProgram progam) {}

    private int getProfileID() { return this.profileID;}

    private String getName() { return this.name;}

    private int getAge() {return this.age;}

    private ArrayList<ViewedProgram> getViewedProgams() {return this.viewedPrograms;}


    }



