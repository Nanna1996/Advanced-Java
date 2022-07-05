package test;
import java.sql.*;
public class Program_To_Create_Tbale {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OrcaleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
		Statement st = con.createStatement();
		st.execute("create table student (rollno number(3), name varchar2(10), marks number(3))");
		System.out.println("Table Created Successfully");
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}

}
