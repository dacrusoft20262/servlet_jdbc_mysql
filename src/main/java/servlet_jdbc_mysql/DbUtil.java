package servlet_jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {

		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbName = "pw";
		String dbUsername = "root";
		String dbPassword = "1234";

		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		return con;
	}
}
