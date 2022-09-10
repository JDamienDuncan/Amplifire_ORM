package com.revature.main;


import java.sql.Connection;
import java.sql.SQLException;

import com.revature.services.ConnectionFactory;
import com.revature.services.DatabaseConnection;


public class Driver {
	
	public static void main(String[] args) throws SQLException {
	
		// Creates a connection with the AWS database
		Connection connection = ConnectionFactory.getConnection();
		
		
		
	}

	/*
	 * 
	 * User object -> Orm -> Database
	 * 
	 * QueryBuilder
	 * - Creates statement need for app
	 * - Needs to be able to tell what statement type to create
	 * - Needs to parse the correct information into prepared statements 
	 * - Could split different statement types into several classes
	 * - Orm depend so it can't import the userDao class from app
	 * 
	 * ConnectionFactory
	 * - Connects to the database, handled already
	 * 
	 * SessionFactory
	 * - Handles session data 
	 *
	 * TransactionFactory
	 * 
	 * 
	 */

	
}














