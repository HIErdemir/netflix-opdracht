package Logic;

public class Movie extends Program {


    private String genre;
    private String language;
    private String ContentRating;

    public Movie(int programID, String programTitle, int duration, String genre, String language, String contentRating) {
        super(programID, programTitle, duration);
        this.genre = genre;
        this.language = language;
        ContentRating = contentRating;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getContentRating() {
        return ContentRating;
    }

}
