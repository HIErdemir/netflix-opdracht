package Logic;

public class ViewedProgram {

    private int viewedProgramID;
    private int programID;
    private int profileID;
    private int percentageWatched;

    public ViewedProgram(int viewedProgramID, int programID, int profileID, int percentageWatched) {
        this.viewedProgramID = viewedProgramID;
        this.programID = programID;
        this.profileID = profileID;
        this.percentageWatched = percentageWatched;
    }

    public int getViewedProgramID(){return this.viewedProgramID;}

    public int getProgramID() {return this.programID;}

    public int getProfileID() {
        return profileID;
    }

    public int getPercentageWatched() {return this.percentageWatched;}





}
