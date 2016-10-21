package org.apache.ignite.internal.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.IgniteTransactions;

public class Transaction {
	public static void main(String[] args) {
		String insertString = "INSERT into Person (age,name,address) VALUES(1234,'1111','1111')";
		String deleteString = "delete from Person where age=1234";
		String updateString = "update person set address='1122' where age=2222";
		String mergeString = "MERGE into Person (age,name,address) VALUES(1111,'1111','3333')";
		/*
		 * ApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("spring.xml");
		 */
		// Register JDBC driver.
		Connection conn = null;
		
		org.apache.ignite.transactions.Transaction transaction=null;

		try {
			Class.forName("org.apache.ignite.IgniteJdbcDriver");

			// Open JDBC connection (cache name is not specified, which means
			// that we use default cache).
			// Connection conn =
			// DriverManager.getConnection("jdbc:ignite://133.133.133.99:11211/author");

			conn = DriverManager
					.getConnection("jdbc:ignite:cfg://cache=person@file:///C:\\Users\\zhimx\\workspace\\demo\\config\\jdbc-config.xml");
			Statement statement = conn.createStatement();
			PreparedStatement preparedStatement=conn.prepareStatement("update person set address=? where age=43");
			Ignite client=((JdbcConnection)conn).ignite();
			IgniteTransactions transactions = client.transactions();
			transaction=transactions.txStart();
			
			/*preparedStatement.setInt(1, 4444);
			preparedStatement.execute();
			preparedStatement.setInt(1, 5555);
			preparedStatement.execute();*/
			
			statement.execute("INSERT into Person (age,name,address) VALUES(1234,'1111','1111')");
			statement.execute("INSERT into Person (age,name,address) VALUES(4321,'1111','1111')");
			
			preparedStatement.setString(1, "43z");
			preparedStatement.execute();
			
			/*statement.execute("INSERT into Person (age,name,address) VALUES(4444,'1111','1111')");
			statement.execute("INSERT into Person (age,name,address) VALUES(5555,'1111','1111')");*/
			transaction.commit();

			/*
			 * ResultSet rs = conn.createStatement().executeQuery(
			 * "select \"country\".Country.CO_NAME from \"country\".Country");
			 * while (rs.next()) { String name = rs.getString(1);
			 * System.out.println(name); }
			 */

			/*
			 * PreparedStatement stmt =
			 * conn.prepareStatement("select name, age from Person where name=?"
			 * ); stmt.setString(1, "1111"); ResultSet rs2 =
			 * stmt.executeQuery(); while (rs2.next()) { String name =
			 * rs2.getString("name"); int age = rs2.getInt("age");
			 * System.out.println("name is:"+name+"age is:"+age); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
			try {
				transaction.rollback();
			} catch (IgniteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
}
