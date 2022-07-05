//Program to demonstrate WebRowSet 
package test;
import java.io.*;
import java.sql.SQLException;
import javax.sql.rowset.WebRowSet;
import oracle.jdbc.rowset.OracleWebRowSet;
public class WRSDemo {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			WebRowSet wrs = new OracleWebRowSet();
			wrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			wrs.setUsername("SYSTEM");
			wrs.setPassword("HARSHA");
			wrs.setCommand("select * from student");
			wrs.execute();
			FileOutputStream fos = new FileOutputStream("student.xml");
			wrs.writeXml(fos);
			System.out.println("WebRowSet data written to student.xml file");
		} 
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}

	}

}
