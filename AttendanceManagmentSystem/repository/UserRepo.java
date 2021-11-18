package repository;

import java.lang.*;

import entity.*;
import interfaces.*;

public class UserRepo implements IUserRepo{
	DatabaseConnection dbc;
	
	public UserRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public User getUser(String empId, String pass)
	{
		User user = null;
		String query = "Select * from login where empId = '"+empId+"' and password = '"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				user = new User();
				user.setUserId(dbc.result.getString("empId"));
				user.setPassword(dbc.result.getString("password"));
				user.setStatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex){System.out.println("Exception : " +ex.getMessage());}
		dbc.closeConnection();
		return user;
	}
	
	
	public void insertUser(User u)
	{
		String query = "INSERT INTO login VALUES ('"+u.getUserId()+"','"+u.getPassword()+"',"+u.getStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
	public void updateUser(User u){
		String query = "UPDATE login SET status='"+u.getStatus()+"', password = '"+u.getPassword()+"' WHERE empId='"+u.getUserId()+"'";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteUser(String empId)
	{
		String query = "DELETE from login  WHERE empId='"+empId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void passwordChange(User user){
		String query = "UPDATE login SET password = '"+user.getPassword()+"' WHERE empId='"+user.getUserId()+"'";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
}