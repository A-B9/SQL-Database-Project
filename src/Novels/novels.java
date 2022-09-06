package Novels;

import java.sql.ResultSet;
import java.sql.SQLException;

public class novels {


    public static void getNovels(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
             StringBuffer buffer = new StringBuffer();

             buffer.append("Novel Title: " + resultSet.getString("Title") + ", ");
             buffer.append("Genre: " + resultSet.getString("Genre") + ", ");
             buffer.append("Type: " + resultSet.getString("Type") + ", ");
             buffer.append("Started: " + resultSet.getDate("Started") + ", ");
             buffer.append("Rating: " + resultSet.getInt("Rating") + ", ");
             buffer.append("Author: " + resultSet.getString("Author") + ", ");

            System.out.println(buffer.toString());
        }
    }
}
