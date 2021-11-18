package interfaces;

import java.lang.*;

import entity.*;

public interface IUserRepo
{
	User getUser(String userId, String password);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(String userId);
}