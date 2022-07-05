//Program to demonstrate CachedRowSet
package test;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;
public class CRSDemo {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs.setUsername("SYSTEM");
			crs.setPassword("HARSHA");
			crs.setCommand("select * from employee");
			crs.execute();
			while(crs.next())
			{
				System.out.print(crs.getInt(1)+"\t");
				System.out.print(crs.getString(2)+"\t");
				System.out.println(crs.getInt(3));
			}
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		

	}

}
