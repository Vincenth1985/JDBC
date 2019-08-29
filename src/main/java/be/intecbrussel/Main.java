package be.intecbrussel;


import java.sql.Connection;
import java.sql.DriverManager;

public class Main {


    public static void main(String[] args) {

        Connection connection = DriverManager.getConnection("jbdc:mysql://localhost:3306/beers.db","root","");


    }

}
