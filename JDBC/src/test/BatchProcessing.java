//program to demonstrate multiple sql queries at a time
package test;
import java.sql.*;
public class BatchProcessing {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			Statement st = con.createStatement();
			st.addBatch("insert into student values(7,'Sankar',65)");
			st.addBatch("update student set marks=98 where rollno=1");
			st.addBatch("delete from student where rollno=3");
			st.executeBatch();
			System.out.println("DML Commands executed successfully");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
