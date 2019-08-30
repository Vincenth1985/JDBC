package be.intecbrussel;

import java.sql.*;

public class Main2 {

    public static void main(String[] args) {


        String delete = "Delete from Beers where name like 'DUVEL'";
        String create = "Insert into Beers (name) Values('DUVEL')";
        String update = "Update Beers SET price = ? where name like ?";

        int id;

        try (Connection connection = new Dbconnector().getConnection();
        ) {

            PreparedStatement query = connection.prepareStatement(update);
            query.setFloat(1, 2);
           // query.setString(2, "Duvel groen");
            query.executeUpdate();

            query = connection.prepareStatement("Select * from Beers where name like 'duvel groen'");
            ResultSet rs = query.executeQuery();

//            query.executeUpdate(create, Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs1 = query.getGeneratedKeys();
//
//            if (rs1.next()) {
//                id = rs1.getInt(1);
//                System.out.println(id);
//            }


            while (rs.next()) {
                System.out.print(rs.getString("id") + " - ");
                System.out.print(rs.getString("name") + " - ");
                System.out.println(rs.getString("price"));
            }


        } catch (SQLException SQL) {
            SQL.printStackTrace();
            System.out.println("Something get wrong wit connection");
        }


    }
}
