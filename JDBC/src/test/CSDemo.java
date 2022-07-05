package test;
import java.sql.*;
public class CSDemo {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			CallableStatement cs = con.prepareCall("{call ps1(?,?,?)}");
			cs.setInt(1, Integer.parseInt(args[0]));
			cs.setString(2, args[1]);
			cs.setInt(3, Integer.parseInt(args[2]));
			cs.executeUpdate();
			System.out.println("One Record Successfully");
		} 
		catch (NumberFormatException | ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
