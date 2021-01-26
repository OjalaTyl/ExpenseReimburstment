package Connections;

import models.User;

public interface UserDAO {
	User getUser(String username, String password);
}
