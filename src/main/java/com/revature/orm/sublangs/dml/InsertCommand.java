package com.revature.orm.sublangs.dml;

import com.revature.orm.jpa.EntityTemplate;
import com.revature.orm.sublangs.Command;

public class InsertCommand extends Command{
	
	public InsertCommand(EntityTemplate temp) {
		
		super(temp);
		isQuery = true;
		
		text = "INSERT INTO "+table+" (";
		
		for(int i = 0; i < size; i++) {
			text = text + cols.get(i).getName();
			
			if(i < size - 1) {
					text = text + ", ";
			}
		}
		
		text = text + ") VALUES (";
		
		for (int i = 0; i < size; i++) {
			text = text + "?";
            if(i < size - 1) {
            	text = text + ", ";
            }
        }
		
		text = text + ") RETURNING "+temp.getPrimary().getName();
	}

}
