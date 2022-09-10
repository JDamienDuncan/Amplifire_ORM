package com.revature.orm.jpa;



import java.lang.reflect.Method;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.revature.orm.Column;
import com.revature.orm.sublangs.Command;


// Will be used to interact with the DAO user from the application. 

public class EntityTemplate {
	
	private final ArrayList<Column> columns = new ArrayList<>();
    private String table;
   
    
    private Column primary;
    
    public EntityTemplate(String tableName) {
    	this.table = tableName;
    }

	public void addCol(String name, Method getter, Method setter, boolean idCheck) {
        Column col = new Column(name, getter, setter);
        if(idCheck) {
            if(primary != null) {
            	throw new RuntimeException("Another Primary Column Detected");
            }
            primary = col;
        } else {
        	columns.add(col);
        }
    }
    
    
     public String getTable() {
		return table;
	}

	

	public Column getPrimary() {
		return primary;
	}
	
	public void setPrimary(Column primary) {
		this.primary = primary;
	}
	
	public ArrayList<Column> getColumns() {
		return columns;
	}

	
	
    
    
    
    










}


