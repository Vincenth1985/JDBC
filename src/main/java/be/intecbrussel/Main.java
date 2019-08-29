package be.intecbrussel;


import java.sql.*;

public class Main {


    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC","root","");
            try{
                PreparedStatement query = connection.prepareStatement("SELECT * FROM Categories");
                ResultSet rs = query.executeQuery();
                while(rs.next()){
                    System.out.print(rs.getInt("id") + " - ");
                    System.out.println(rs.getString("category"));
                }
            } catch (Exception e){}

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
