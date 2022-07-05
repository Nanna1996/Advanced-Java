package test;
import java.sql.*;
import java.io.*;
public class BlobDemo {
	public static void main(String[] args) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
				PreparedStatement ps = con.prepareStatement("insert into images values(?,?)");
				ps.setString(1, args[0]);
				FileInputStream fis = new FileInputStream(args[1]);//it opens a file for reading
				ps.setBinaryStream(2, fis, fis.available());
				ps.executeUpdate();
				System.out.println("One Image inserted Successfully");
			} 
			catch (ClassNotFoundException | SQLException | IOException e) 
			{
				
				e.printStackTrace();
			}
	}

}
