import java.sql.*;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        String query = "SELECT nameuser from user ";
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(dbUrl,username,password);
                Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(query)){
            System.out.println("Users");
            while (rs.next()){
                String userName = rs.getString();
                String userpass = rs.getString(passuser);

                System.out.println("Username: " + userName + "\n" +
                                     "Userpass: " + userpass );
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
