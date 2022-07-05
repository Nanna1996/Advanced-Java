//Program to find absolute position from the table by using 
//TYPE_SCROLL_SENSITIVE,CONCUR_UPDATABLE
package test;
import java.sql.*;
public class MoveDemo {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from employee");
			rs.absolute(6);//here 6 means 6th line of the table
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.println(rs.getInt(3));
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
