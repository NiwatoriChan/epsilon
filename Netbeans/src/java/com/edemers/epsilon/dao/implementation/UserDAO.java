package com.edemers.epsilon.dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.edemers.epsilon.dao.DAO;
import com.edemers.epsilon.modele.User;

public class UserDAO extends DAO<User> {

	public UserDAO(Connection c)
	{
		super(c);
	}
        
	@Override
	public boolean create(User x) {
		// TODO Auto-generated method stub
	
		String req = "INSERT INTO user (`USERNAME` , `PASSWORD`) "+
			     "VALUES ('"+x.getUsername()+"','"+x.getPassword()+"')";

		//System.out.println("REQUETE "+req);

		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		return false;
	}

	@Override
	public boolean delete(User x) {
		// TODO Auto-generated method stub
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate("DELETE FROM user WHERE username='"+x.getUsername()+"'"); //A CHANGER POUR ID!!!
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;
	}

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return this.read(""+id);
	}

	@Override
	public User read(String username) {
		// TODO Auto-generated method stub
                Statement stm = null;
                ResultSet r = null;
		try 
		{
			stm = cnx.createStatement(); 
			r = stm.executeQuery("SELECT * FROM user WHERE username = '"+username+"'");
			if (r.next())
			{
				User c = new User(r.getString("username"),
						r.getString("password"));		
				r.close();
				stm.close();
				return c;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
                                r.close();
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return null;
	}

	@Override
	public boolean update(User x) {
		// TODO Auto-generated method stub
		Statement stm = null;
		try 
		{
			String req = "UPDATE user SET NOM = '"+x.getUsername()+"',"+
							"COURRIEL = '"+x.getPassword()+"'";
			//System.out.println("REQUETE "+req);
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;
	}
	@Override
	public List<User> findAll() {
		List<User> liste = new LinkedList<User>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM user");
			while (r.next())
			{
				User c = new User(r.getString("username"),
						r.getString("password"));
				liste.add(c);
			}
			r.close();
			stm.close();
		}
		catch (SQLException exp)
		{
		}
		return liste;
	}
}
