package test;
import java.sql.*;
public class PSExecute {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
			PreparedStatement ps = con.prepareStatement("select * from employee where empno=?");
			ps.setInt(1, Integer.parseInt(args[0]));
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getInt(3));
			}
		}
		catch (NumberFormatException | ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
