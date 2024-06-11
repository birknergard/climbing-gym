import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database
{
    private static Properties properties = new Properties();

    static{
        try{
            DriverManager.registerDriver(new Driver());
            properties.load(new FileInputStream("Database/config.properties"));

            String[] propertyList = {"username", "password", "url"};

            for(String property : propertyList){
                if(!properties.containsKey(property)){
                    throw new IOException("database.properties does not contain" + property + " property.");
                }
                if(properties.getProperty(property).isEmpty()){
                    throw new IOException("database.properties field is empty.");
                }
            }

        } catch (SQLException | IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getDatabaseConnection() throws SQLException{
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
