package ignite.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.internal.jdbc2.JdbcConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JdbcDriverForIgnite{

public static void main(String[] args) {
	String insertString="INSERT into Person (age,name,address) VALUES(2222,'1111','1111')";
	String deleteString="delete from Person where age=1111 or age=2222";
	String updateString="update person set address='1122' where age=1111";
	String mergeString="MERGE into Person (age,name,address) VALUES(1111,'1111','3333')";
	/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");*/
    // Register JDBC driver.
	Connection conn=null;
	try{    
		Class.forName("org.apache.ignite.IgniteJdbcDriver");
   
	// Open JDBC connection (cache name is not specified, which means that we use default cache).
    //Connection conn = DriverManager.getConnection("jdbc:ignite://133.133.133.99:11211/author");
		
	conn = DriverManager.getConnection("jdbc:ignite:cfg://cache=country@file:///C:\\Users\\zhimx\\workspace\\demo\\config\\jdbc-config.xml");
	/*Statement statement=conn.createStatement();
	statement.execute("delete from Person where age=44");*/
	/*ResultSet rs = conn.createStatement().executeQuery("select \"country\".Country.CO_NAME from \"country\".Country");   
    while (rs.next()) {
        String name = rs.getString(1);
        System.out.println(name);
    }*/
    
    
    PreparedStatement stmt = conn.prepareStatement("select \"country\".Country.CO_NAME from \"country\".Country where \"country\".Country.CO_ID=?");
    stmt.setInt(1, 5);
    ResultSet rs2 = stmt.executeQuery();
    while (rs2.next()) {
        String name = rs2.getString("CO_NAME");       
        System.out.println("name is:"+name);
    }
	
}catch(Exception e){
	e.printStackTrace();
	try {
		conn.rollback();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
}
}
}
