//program to demonstrate Inserting method
package test;
import java.sql.*;
public class InsertingData {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select rollno,name,marks from student");
			rs.moveToInsertRow();
			rs.updateInt(1, 7);//Here 1 is column number and 7 is row data
			rs.updateString(2, "Sankar");//Here 2 is column number and Sankar is row data
			rs.updateInt(3, 60);//Here 3 is column number and 60 is row data
			rs.insertRow();//compulsory required for inserting the data
			System.out.println("One Record inserted Successfully");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
