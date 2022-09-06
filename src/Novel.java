import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Novel {

    private String title; private String genre; private String type;
    private String started; private String rating; private String author;


    public Novel(String title, String genre, String type, String started, String rating, String author) {
        this.title = title;
        this.genre = genre;
        this.type = type;
        this.started = started;
        this.rating = rating;
        this.author = author;
    }

    public Novel() {

    }


    public void addNovel(String title, String genre, String type, String started, String rating, String author) {

        String sqlQuery = "INSERT INTO `novels` (`Title`, `Genre`, `Type`, `Started`, `Rating`, `Author`) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)){

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, genre);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, started);
            preparedStatement.setString(5, rating);
            preparedStatement.setString(6, author);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
