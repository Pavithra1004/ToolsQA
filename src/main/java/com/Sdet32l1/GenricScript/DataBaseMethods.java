package com.Sdet32l1.GenricScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains all the common action related to database
 */
public class DataBaseMethods
{

	static Connection connection;
	static Statement statement;
	/**
	 * This method is used to open the database connection
	 * @param dbUrl
	 * @param userName
	 * @param dbPassword
	 * @throws SQLException 
	 */
	public static void openDBConnection(String dbUrl,String dbun,String dbpwd) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(dbUrl, dbun, dbpwd);
		statement = connection.createStatement();
	}
	/**
	 * This method is used to fetch the data from database/to do the DQL action on the database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query,String columnName) throws SQLException
	{
		ArrayList<String> list=new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{

			list.add(result.getString(columnName));
		}
		return list;

	}
	/**
	 * This method is used to validate the data wether data is present in the data base or not
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDataInDataBase(String query,String columnName,String expectedData) throws SQLException
	{
		ArrayList<String> list=getDataFromDataBase(query,columnName);
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		return flag;
		
	}
	/**
	 * This method is used to store/modify/insert/delete the data into databaseto do the DML and DDL actions on database
	 * @param query
	 * @throws SQLException
	 */
	public static void setDataIntoDataBase(String query) throws SQLException
	{
		int result=statement.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("Data enterd or modified successfully");
		}
	}
	/** 
	 * This method is used to close the database connection
	 * @throws SQLException
	 */
	public static void closeDBConnection() throws SQLException
	{
		connection.close();
	}
	
	
	
	
	
}	

