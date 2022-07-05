//Program to demonstrate JDBCRowSet
package test;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import oracle.jdbc.rowset.OracleJDBCRowSet;
public class JRSDemo {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			JdbcRowSet jrs = new OracleJDBCRowSet();
			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			jrs.setUsername("SYSTEM");
			jrs.setPassword("HARSHA");
			jrs.setCommand("select * from student");
			jrs.execute();
			while(jrs.next())
			{
				System.out.print(jrs.getInt("rollno")+"\t");
				System.out.print(jrs.getString("name")+"\t");
				System.out.println(jrs.getInt("marks"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    

	}

}
