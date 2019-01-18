package Logic;

public class Movie extends Program {


    private String genre;
    private String language;
    private int ContentRating;

    public Movie(int programID, String programTitle, int duration, String genre, String language, int contentRating) {
        super(programID, programTitle, duration);
        this.genre = genre;
        this.language = language;
        this.ContentRating = contentRating;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int getContentRating() {
        return ContentRating;
    }

}
