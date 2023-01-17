package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/login_db";
		String user = "root";
		String password1 = "sqlroot4321";
		String sql = "select * from login;";

		try (Connection con = DriverManager.getConnection(url, user, password1);
				Statement statement = con.createStatement();
				ResultSet resultset = statement.executeQuery(sql)) {
			System.out.println("loginId | password");
			while(resultset.next()) {
				String loginId = resultset.getString("loginId");
				String password = resultset.getString("password");
				System.out.println(loginId + " | " + password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("プログラムを終了します。");
		}
	}
}