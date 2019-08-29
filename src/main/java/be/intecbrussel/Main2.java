package be.intecbrussel;

import java.sql.*;

public class Main2 {

    public static void main(String[] args) {


        String delete = "Delete from Beers where name like 'test'";
        String create = "Insert into Beers (name) Values('TEST')";


        try (Connection connection = new Dbconnector().getConnection();
             Statement statement = connection.createStatement()) {


            ResultSet rs = statement.executeQuery("Select * from Beers");


            while (rs.next()) {
                System.out.print(rs.getString("id") + " - ");
                System.out.println(rs.getString("name"));
            }


        } catch (SQLException SQL) {
            SQL.printStackTrace();
            System.out.println("Something get wrong wit connection");
        }


    }
}
