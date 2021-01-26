package Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserDataHandler implements UserDAO {

	@Override
	public User getUser(String username, String password) {
		User user = null;
		String sql = " SELECT * FROM reimburstment_user WHERE username = ? and password = ?"; // sql statement
		try (Connection conn = Connector.getConnection()) {
			PreparedStatement s = conn.prepareStatement(sql); // Allows us to send SQL statements
			s.setString(1, username);
			s.setString(2, password);
			ResultSet rs = s.executeQuery(); // We are executing our SQL statement
			

			while (rs.next()) {
				user = new User(rs.getInt("reimburstment_user_id"), rs.getString("username"), rs.getBoolean("manager"));
				
			}
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		}
		return user;
	}

}
