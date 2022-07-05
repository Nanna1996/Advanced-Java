//Program to insert data by using PreparedStatement Interface--->For dynamic SQL queries
package test;
import java.sql.*;
public class PSDemo {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, Integer.parseInt(args[0]));
			ps.setString(2, args[1]);
			ps.setInt(3, Integer.parseInt(args[2]));
			ps.executeUpdate();
			System.out.println("One Record Inserted Successfully");
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		}

	}


