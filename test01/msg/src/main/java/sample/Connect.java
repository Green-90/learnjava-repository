package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Connect{
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_db","root","sqlroot4321");
            Statement stmt=con.createStatement();
            @SuppressWarnings("unused")
			ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
