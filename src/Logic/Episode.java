package Logic;

public class Episode extends Program {

    private int episodeID;
    private int seasonID;
    private int tvShowID;
    private int avgWatched;

    public Episode(int programID, String programTitle, int duration, int episodeID, int seasonID, int tvShowID) {
        super(programID, programTitle, duration);
        this.episodeID = episodeID;
        this.seasonID = seasonID;
        this.tvShowID = tvShowID;
    }

    public Episode(int programID, String programTitle, int duration, int episodeID, int seasonID, int tvShowID, int avgWatched) {
        super(programID, programTitle, duration);
        this.episodeID = episodeID;
        this.seasonID = seasonID;
        this.tvShowID = tvShowID;
        this.avgWatched = avgWatched;
    }

    public int getEpisodeID() {
        return episodeID;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public int getTvShowID() {
        return tvShowID;
    }

    public int getAvgWatched() {
        return avgWatched;
    }
}
