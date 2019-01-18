package Logic;

import Database.Repository.ViewedProgramRep;

import java.util.ArrayList;

public class Profile {

    private int profileID;
    private String name;
    private String age;
    private int accountID;
    private ArrayList<ViewedProgram> viewedPrograms;

    public Profile(int profileID, String name, String age, int accountID) {
        this.profileID = profileID;
        this.name = name;
        this.age = age;
        this.accountID = accountID;
        viewedPrograms = new ArrayList<ViewedProgram>();
    }


    public void addViewedProgram(ViewedProgram program){
        ViewedProgramRep viewed = new ViewedProgramRep();
        viewed.insert(program);
        viewedPrograms.clear();
        getViewedProgams();
    }

    public void deleteViewedProgram(int viewedID) {
        ViewedProgramRep viewed = new ViewedProgramRep();
        viewed.delete(viewedID);
        viewedPrograms.clear();
        getViewedProgams();
    }

    public void updateViewedProgram(ViewedProgram progam) {
        ViewedProgramRep viewed = new ViewedProgramRep();
        viewed.update(progam);
        viewedPrograms.clear();
        getViewedProgams();
    }

    private void  getViewedProgams() {
        ViewedProgramRep viewed = new ViewedProgramRep();
        viewedPrograms = viewed.getProfileViewedPrograms(profileID);
    }

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
        return accountID;
    }

}



