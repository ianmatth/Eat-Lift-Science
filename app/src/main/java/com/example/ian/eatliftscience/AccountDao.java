package com.example.ian.eatliftscience;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class AccountDao
{

	public static String[] getAccount(String name, String pass)
    {
		String[] account = null;
		java.sql.Connection con = null;
        ResultSet rs;

        try
        { 	//connect to database
           	Class.forName("com.mysql.jdbc.Driver");
     	   	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");
     	   	Statement st = con.createStatement();

     	   	//run query for username and password
     	   	String query = "select * from ELS.User where USER_NAME = '" + name + "' and USER_PASSWORD = '" + pass +"'";
     	   	rs = st.executeQuery(query);

     	   	if (rs.next())
     	   	{
     	   		account[0] = rs.getString(1);
				account[1] = rs.getString(2);
				account[2] = rs.getString(3);
				account[3] = rs.getString(4);
				account[4] = rs.getString(5);
				account[5] = rs.getString(6);
     	   	}
     	   	else account[0] = "incorrect password";
        }
        catch (Exception e)
        {
        	System.out.println(e);
        }
        finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return account;
    }

	public static String getUser(String name)
	{
		String user = null;
		java.sql.Connection con = null;
		ResultSet rs;

		try
		{ 	//connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");
			Statement st = con.createStatement();

			//run query for username and password
			String query = "select * from ELS.User where USER_NAME = '" + name + "'";
			rs = st.executeQuery(query);

			if (rs.next()) user = rs.getString(1);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	public static void addUser(String name, String password)
	{
		java.sql.Connection con = null;

		try {    //connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");

			String query = "insert into ELS.User (USER_NAME, USER_PASSWORD)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, password);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void setWeight(String name, String weight)
	{
		java.sql.Connection con = null;
		ResultSet rs;
		String prev_weight;
		try
		{ 	//connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");
			Statement st = con.createStatement();

			//run query for username and password
			String query = "select * from ELS.User where USER_NAME = '" + name + "'";
			rs = st.executeQuery(query);

			if (rs.next())
			{
				prev_weight = rs.getString(3);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		try {    //connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");
			Statement st = con.createStatement();

			String query = "insert into ELS.User (WEIGHT) where USER_NAME = '" + name)";
			PreparedStatement st = con.prepareStatement(query);

			st.setString(5, prev_weight);
			st.setString(3, weight);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void setBF(String name, String bf)
	{
		java.sql.Connection con = null;
		ResultSet rs;
		String prev_bf;
		try
		{ 	//connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");
			Statement st = con.createStatement();

			//run query for username and password
			String query = "select * from ELS.User where USER_NAME = '" + name + "' and USER_PASSWORD = '" + pass +"'";
			rs = st.executeQuery(query);

			if (rs.next())
			{
				prev_bf = rs.getString(4);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		try {    //connect to database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ELS");
			Statement st = con.createStatement();

			String query = "insert into ELS.User (WEIGHT) where USER_NAME = '" + name)";
			PreparedStatement st = con.prepareStatement(query);

			st.setString(6, prev_bf);
			st.setString(4, bf);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
