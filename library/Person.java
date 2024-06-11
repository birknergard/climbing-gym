import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Person
{
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        try(Connection connection = Database.getDatabaseConnection()){
            String query = "INSERT INTO people(fullName, email) VALUES(?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, this.getFullName());
            statement.setString(2, this.getEmail());
            statement.executeUpdate();
            System.out.println("Person added to people database.");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }
    public String getEmail() {
        return email;
    }
}
