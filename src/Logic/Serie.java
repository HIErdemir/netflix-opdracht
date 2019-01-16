package Logic;

import java.util.ArrayList;

public class Serie {

    private int serieID;
    private String title;
    private String genre;
    private String language;
    private int age;
    private ArrayList<Episode> episodes;

    public Serie(int SerieID, String title, String genre, int age){}

    public int getSerieID() {
        return this.serieID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getAge() {
        return this.age;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void getAll() {}

}
