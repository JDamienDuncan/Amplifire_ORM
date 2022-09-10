package com.revature.orm.sublangs;

import java.util.ArrayList;

import com.revature.orm.Column;
import com.revature.orm.jpa.EntityTemplate;

public abstract class Command {
	
	protected String text;
	protected String table;
	
	protected ArrayList<Column> cols;
	protected int size;
	protected boolean isQuery;
	
	// Default Constructor
	public Command() {
		text = null;
		table = null;
		cols = null;
		size = 0;
		
	}
	
	// Constructor - Takes in an Entity 
	public Command(EntityTemplate template) {
		this.table = template.getTable();
		this.cols = template.getColumns();
		size = cols.size();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		return this.text;
	}
	
	public boolean isQuery() {
        return isQuery;
    }
	
	
	
	
	
	
	
	
	
	
	

}
