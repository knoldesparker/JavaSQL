import java.sql.*;

public class db {
    private String query;
    private String dbUrl = "jdbc:mysql://localhost:3306/test";
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


        for (int i = 0; i < 10; i++) {

            String query = "INSERT INTO user (nameuser, passuser) VALUES ('Casper', 1234) ";

            try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
                 Statement statement = connection.createStatement()) {
                System.out.println(query);
                statement.executeUpdate(query);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            i++;
        }

    }
}
