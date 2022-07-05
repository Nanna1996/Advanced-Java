package test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@SuppressWarnings("serial")
public class RegServlet extends GenericServlet {
	Connection con;
    public RegServlet() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "HARSHA");
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
		
	}

	
	public void destroy() 
	{
		try {
			con.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		try {
			String s1 = request.getParameter("fname");
			String s2 = request.getParameter("lname");
			String s3 = request.getParameter("uname");
			String s4 = request.getParameter("pwd");
			PreparedStatement ps = con.prepareStatement("insert into uinfo values(?,?,?,?)");
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			PrintWriter pw = response.getWriter();
			pw.println("<html><body bgcolor=red text=yellow><center>");
			pw.println("<h1>You Have Registered Successfully</h1>");
			pw.println("<a href=login.html>Login</a>");
			pw.println("</center></body><html>");
		} catch (SQLException | IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}

}
