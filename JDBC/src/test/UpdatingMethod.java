//program to update the data based on the updating method 
package test;
import java.sql.*;
public class UpdatingMethod {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select rollno,name,marks from student");
			rs.absolute(6);//here 6 means line of the Table
			rs.updateInt(3, 100);//here 3 means column number or name and 100 means updating the data
			rs.updateRow();
			System.out.println("One Record Updated Successfully");
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
