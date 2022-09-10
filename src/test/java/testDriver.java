import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.orm.QueryBuilder;
import com.revature.services.ConnectionFactory;

public class testDriver {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		Connection connection = ConnectionFactory.getConnection();
		
		
		// Updates User using id 
		QueryBuilder query = new QueryBuilder(connection, "testtable");
		
		query.updateTable("testtable").setCol("testuser","testJohn").where("testid", 1).endOperation();
		System.out.println(query.viewSQL());
		query.executeUpdate();
		
		//deletes user where user id = 1 
		QueryBuilder query2 = new QueryBuilder(connection, "testtable");
		
		query2.deleteRow("testtable").where("testid", 1).endOperation();
		System.out.println(query2.viewSQL());
		query2.executeUpdate();
		
		
		
		
		/*
		query.updateTable("testtable").setCol("testuser","John").setCol("testpass", "password").
				setCol("testemail", "john@email.com").setCol("testid", 1).endOperation();
		System.out.println(query.viewSQL());
		query.executeUpdate();
		*/
		

	}
}
	
