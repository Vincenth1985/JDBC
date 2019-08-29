package be.intecbrussel;


import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {


        PreparedStatement query;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC", "root", "")) {

            try {

                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Categories");
                
                while (rs.next()) {
                    System.out.print(rs.getString("id") + " - ");
                    System.out.println(rs.getString("category"));
                }
            } catch (Exception e) {
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC", "root", "")) {

            try {
                query = connection.prepareStatement("SELECT name,alcohol FROM Beers");
                ResultSet rs = query.executeQuery();
                while (rs.next()) {
                    System.out.print(rs.getString("name") + " - ");
                    System.out.println(rs.getString("alcohol"));
//

                }
            } catch (Exception e) {
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
