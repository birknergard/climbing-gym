import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book
{
    private String title;
    private String author;
    private int pageCount;
    private String genre;
    private String year;

    Book(String title, String author, int pageCount, String genre, String year){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
        this.year = year;

        try(Connection connection = Database.getDatabaseConnection()){
            String query = "INSERT INTO books(title, author, genre, pageCount, year) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, genre);
            statement.setString(4, year);
            statement.setInt(5, pageCount);

            if(statement.executeUpdate() == 0){
                throw new SQLException("Invalid query for inserting into 'books' table");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
