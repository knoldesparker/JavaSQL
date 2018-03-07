import java.sql.*;
import java.util.Scanner;

public class db {
    private String query;
    private String dbUrl = "jdbc:mysql://localhost:3306/users";
    private String username = "root";
    private String password = "1234";

    public void printUsers() {
        query = "SELECT * FROM user";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            System.out.println("Users");
            while (rs.next()) {
                int iduser = rs.getInt(1);
                String nameuser = rs.getString(2);
                String passuser = rs.getString(3);

                System.out.println("id# " + iduser + "\t" + nameuser + "\t" + passuser);

            }
            connection.close();
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteUsers() {
        String query = "DELETE FROM user WHERE nameuser = 'freja'";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void insertUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert name");
            String name = scanner.nextLine();
        System.out.println("Insert password");
            String pass = scanner.nextLine();
        System.out.println();

            String query = "INSERT INTO users (user_name, user_pass) VALUES ('" + name + "', '" + pass + "'); ";

            try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
                 Statement statement = connection.createStatement()) {
                System.out.println(query);
                statement.executeUpdate(query);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }
}
