package com.revature.orm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.revature.services.DatabaseConnection;

public class QueryBuilder {
	
	protected StringBuffer sql;
	private String tableName;
	Connection connection;
	
	//Constructor
	public QueryBuilder(Connection connection, String tableName) {
		this.connection = connection;
		this.tableName = tableName;
		sql = new StringBuffer("");
	}
	
	// Adds SELECT operation into the statement builder
	public void getColumns(String columns){
		sql.append("SELECT "+columns);
	}
	
	// Adds FROM operation into the statement builder
	public void fromTable(String table) {
		sql.append(" FROM "+table);
	}
	
	public void insertTable(String table) {
		sql.append("INSERT "+table);
		
	}
	
	// Inserts values into cols
	public void insertRow(String table) { // Evan
		sql.append("INSERT INTO "+table );
	}
	
	public void updateTable(String table) {
		sql.append("UPDATE "+table);
	}
	
	// Returns a String containing current Query Build
	public String viewSQL() {
		return sql.toString();
	}
	
	public void where(String target, String condition) {
		sql.append("WHERE "+target+" = "+condition);
	}
	
	public void deleteRow(String table) {
		sql.append("DELETE FROM "+table);
	}
	
	// Sets a col value, overloaded once for integer entries
	public void setCol(String col, String target) {
		sql.append("SET "+col+" = "+target);
	}
	public void setCol(String col, int target) {
		sql.append("SET "+col+" = "+target);
	}
	
	public void executeOperation(){
		sql.append(";");
	}
	
	// Executes Query described in the StringBuffer
	// Needs to return a collection 
	public void executeQuery() {
		try(Statement statement = connection.createStatement();){
			ResultSet set = statement.executeQuery(sql.toString());
		} catch(SQLException e) {
			System.out.println("Well that Query didn't work!");
		}
		
	}
	
	// Executes Update Operation described in the StringBuffer
	public void executeUpdate(){
		try(Statement statement = connection.createStatement();){
			statement.executeUpdate(sql.toString());
		} catch(SQLException e) {
			System.out.println("Well that Update didn't work!");
		}
	}

}
