package Database.Repository;

import Database.Connection.SqlConnect;
import Logic.Episode;
import Logic.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieRep {

    private SqlConnect databaseConnector;

    public MovieRep() {
        this.databaseConnector = new SqlConnect();
    }

    public ArrayList<Movie> getAllMoviePerAccount(int accountID){
        ArrayList<Movie> MovieList = new ArrayList<Movie>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("select P.ProgramID, P.ProgramTitle, P.Duration ,M.Genre, M.MovieLanguage, M.ContentRating   \n" +
                    "from Account A JOIN NProfile NP ON A.AccountID = NP.AccountID\n" +
                    "\tJOIN ViewedProgram V ON NP.ProfileID = V.ProfileID\n" +
                    "\tJOIN Program P ON  V.ProgramID = P.ProgramID\n" +
                    "\tJOIN Movie M ON P.ProgramID = M.ProgramID\n" +
                    "WHERE  A.AccountID = ?");

            stmt.setInt(1,accountID);
            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {

                int ProgramID = resultSet.getInt("P.ProgramID");
                String ProgramTitle = resultSet.getString("P.ProgramTitle");
                int Duration = resultSet.getInt("P.Duration");
                String Genre = resultSet.getString("M.Genre");
                String MovieLanguage = resultSet.getString("M.MovieLanguage");
                int ContentRating = resultSet.getInt("M.ContentRating");


                MovieList.add(new Movie(ProgramID,ProgramTitle,Duration,Genre,MovieLanguage,ContentRating));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return MovieList;
    }

    public ArrayList<Movie> getMovieCompleetWachted(){
        ArrayList<Movie> MovieList = new ArrayList<Movie>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT Program.ProgramID, Program.ProgramTitle,Program.Duration,Movie.Genre,movie.MovieLanguage,Movie.ContentRating, COUNT(ViewedProgram.ProfileID) AS HeelGekeken\n" +
                    "FROM Movie\n" +
                    "JOIN Program ON Program.ProgramID = Movie.ProgramID\n" +
                    "JOIN ViewedProgram ON ViewedProgram.ProgramID = Program.ProgramID\n" +
                    "JOIN NProfile ON Nprofile.ProfileID = ViewedProgram.ProfileID\n" +
                    "GROUP BY Program.ProgramID, Program.ProgramTitle,Program.Duration,Movie.Genre,movie.MovieLanguage,Movie.ContentRating");


            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {

                int ProgramID = resultSet.getInt("Program.ProgramID");
                String ProgramTitle = resultSet.getString("Program.ProgramTitle");
                int Duration = resultSet.getInt("Program.Duration");
                String Genre = resultSet.getString("Movie.Genre");
                String MovieLanguage = resultSet.getString("Movie,MovieLanguage");
                int ContentRating = resultSet.getInt("Movie.ContentRating");


                MovieList.add(new Movie(ProgramID,ProgramTitle,Duration,Genre,MovieLanguage,ContentRating));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return MovieList;
    }

    public Movie getMovieLongestUnder16(){
        Movie movie = null;

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT Program.ProgramID, Program.ProgramTitle,Program.Duration,Movie.Genre,movie.MovieLanguage,Movie.ContentRating, COUNT(ViewedProgram.ProfileID) AS HeelGekeken\n" +
                    "FROM Movie\n" +
                    "JOIN Program ON Program.ProgramID = Movie.ProgramID\n" +
                    "JOIN ViewedProgram ON ViewedProgram.ProgramID = Program.ProgramID\n" +
                    "JOIN NProfile ON Nprofile.ProfileID = ViewedProgram.ProfileID\n" +
                    "GROUP BY Program.ProgramID, Program.ProgramTitle,Program.Duration,Movie.Genre,movie.MovieLanguage,Movie.ContentRating");


            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {

                int ProgramID = resultSet.getInt("Program.ProgramID");
                String ProgramTitle = resultSet.getString("Program.ProgramTitle");
                int Duration = resultSet.getInt("Program.Duration");
                String Genre = resultSet.getString("Movie.Genre");
                String MovieLanguage = resultSet.getString("Movie,MovieLanguage");
                int ContentRating = resultSet.getInt("Movie.ContentRating");


                movie = new Movie(ProgramID,ProgramTitle,Duration,Genre,MovieLanguage,ContentRating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return movie;
    }
}
