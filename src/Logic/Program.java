package Logic;

public abstract class Program {

private int programID;
private String programTitle;
private int duration;

    public Program(int programID, String programTitle, int duration) {
        this.programID = programID;
        this.programTitle = programTitle;
        this.duration = duration;
    }

    public int getProgramID() {
        return programID;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public int getDuration() {
        return duration;
    }
}
