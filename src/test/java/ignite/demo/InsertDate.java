package ignite.demo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import javafx.css.PseudoClass;

import com.mysql.jdbc.Connection;

public class InsertDate {
	public static void main(String[] args) {
		String sql="insert into person values(?,?,?)";
		Connection connection=ConnectMysql();
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			for(int i=0;i<50;i++){
				ps.setInt(1, i);
				ps.setString(2, "z"+String.valueOf(i));
				ps.setString(3, String.valueOf(i)+"z");
				ps.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	static public Connection ConnectMysql() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost/ignite", "root", "123456");
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			} else {
				System.out.println("Falled connecting to the Database!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;

	}
}
