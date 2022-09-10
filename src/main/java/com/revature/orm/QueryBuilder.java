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
	
	// CHANGE ALL 
	
	//Constructor
	public QueryBuilder(Connection connection, String tableName) {
		this.connection = connection;
		this.tableName = tableName;
		sql = new StringBuffer("");
	}
	
	// Adds SELECT operation into the statement builder
	public QueryBuilder getColumns(String columns){
		sql.append("SELECT "+columns);
		return this;
	}
	
	// Adds FROM operation into the statement builder
	public QueryBuilder fromTable(String table) {
		sql.append(" FROM "+table);
		return this;
	}
	
	public QueryBuilder insertTable(String table) {
		sql.append("INSERT "+table);
		return this;
		
	}
	
	// Inserts values into cols
	public QueryBuilder insertRow(String table) { // Evan
		sql.append("INSERT INTO "+table );
		return this;
	}
	
	public QueryBuilder updateTable(String table) {
		sql.append("UPDATE "+table);
		return this;
	}
	
	// Returns a String containing current Query Build
	public String viewSQL() {
		return sql.toString();
	}
	
	public QueryBuilder where(String target, String condition) {
		sql.append("WHERE "+target+" = "+condition);
		return this;
	}
	
	public QueryBuilder deleteRow(String table) {
		sql.append("DELETE FROM "+table);
		return this;
	}
	
	// Sets a col value, overloaded once for integer entries
	public QueryBuilder setCol(String col, String target) {
		sql.append("SET "+col+" = "+target);
		return this;
	}
	public QueryBuilder setCol(String col, int target) {
		sql.append("SET "+col+" = "+target);
		return this;
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
