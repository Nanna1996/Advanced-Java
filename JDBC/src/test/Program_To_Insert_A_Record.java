package test;
//Program to Insert a record
import java.sql.*;
public class Program_To_Insert_A_Record {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");//Driver Loaded                   //Connection Established
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
		Statement st = con.createStatement();//Statement Created to execute static SQL Queries
		 st.executeUpdate("insert into student values(4,'Harsha',80)");
		 System.out.println("One Record inserted Successfully");
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}

}
