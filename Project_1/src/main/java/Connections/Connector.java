package Connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	// "jdbc:postgresql://[ENDPOINT]/[DATABASE]
	private static final String URL = "jdbc:postgresql://database-2.clfxfw4urext.us-east-2.rds.amazonaws.com/postgres";
	private static final String USERNAME = System.getenv("DATABASE_USERNAME");
	private static final String PASSWORD = System.getenv("DATABASE_PASSWORD");

	private static Connection conn;

	public static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
