package be.intecbrussel;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws SQLException {


        PreparedStatement query;
        List<Beer> beerList = new ArrayList<>();
        ResultSet rs;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC", "root", "")) {
            try {
                Statement statement = connection.createStatement();
                rs = statement.executeQuery("Select * from Beers");


                while (rs.next()) {
                    //parse resultset record

                    beerList.add(new Beer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("brewerId"),
                            rs.getFloat("Price"),
                            rs.getInt("Stock"),
                            rs.getFloat("Alcohol"),
                            rs.getInt("Version")
                    ));
                }


            } catch (Exception e) {
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        beerList.forEach(System.out::println);

        Dbconnector dbconnector = new Dbconnector();

        try (Connection connection = dbconnector.getConnection();
             Statement statement = connection.createStatement();) {

            String sql = "Insert into Beers (Name,Alcohol) Values('Bruwdog','4');";
            String sql2 = "Delete from Beers where name like 'Bruwdog'";
            String sql3 = "Update Beers SET Alcohol = ? WHERE id = ?";


            statement.executeUpdate(sql);
            connection.prepareStatement("Update Beers SET Alcohol = 10 ");
            rs = statement.executeQuery("Select * from Beers");

            while (rs.next()) {
                System.out.print(rs.getInt("id") + "-");
                System.out.print(rs.getString("Name") + "-");
                System.out.println(rs.getString("brewerid"));

            }

        } catch (SQLException s) {

            s.printStackTrace();

        }

//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC", "root", "")) {
//
//            try {
//                query = connection.prepareStatement("SELECT name,alcohol FROM Beers");
//                ResultSet rs = query.executeQuery();
//                while (rs.next()) {
//                    System.out.print(rs.getString("name") + " - ");
//                    System.out.println(rs.getString("alcohol"));
//
//
//                }
//            } catch (Exception e) {
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

}
