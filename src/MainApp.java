import Novels.novels;

import java.sql.*;
import java.util.Scanner;

public class MainApp {

    public static final String SQL = "SELECT * From novels WHERE rating <= ?";

    public static void main(String[] args) throws SQLException {
        Integer maxRating;
        try {
            maxRating = Input.getInt("Enter max rating: ");
        }
        catch (Exception e) {
            System.err.println("Error");
            return;
        }


        try (Connection dataBaseConnection = DatabaseConnector.getConnection();
             //Statement statement = dataBaseConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             //ResultSet resultSet = preparedStatement.executeQuery(SQL); // "SELECT * from novels"
             ) {

            System.out.println("Connection good");

            //novels.getNovels(resultSet);
            //resultSet.first();
            //System.out.println(resultSet.getString("Genre"));

            preparedStatement.setInt(1, maxRating);
            ResultSet resultSet = preparedStatement.executeQuery();
            novels.getNovels(resultSet);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to add a Novel");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("yes")) { // this is not case sensitive
            System.out.println("Enter Title: ");
            String title = input.nextLine();

            System.out.println("Enter Genre: ");
            String genre = input.nextLine();

            System.out.println("Enter Type: ");
            String type = input.nextLine();

            System.out.println("Enter Started Date: ");
            String started = input.nextLine();

            System.out.println("Enter Rating: ");
            String rating = input.nextLine();

            System.out.println("Enter Author: ");
            String author = input.nextLine();

            Novel create = new Novel();
            create.addNovel(title, genre, type, started, rating, author);
        }
        else {
            System.out.println("Okay");
        }

    }
}