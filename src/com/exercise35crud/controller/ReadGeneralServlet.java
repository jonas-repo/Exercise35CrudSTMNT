package com.exercise35crud.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that get the product state
 * @author jonas 
 * @version 1.0
 * 
 */


@WebServlet("/Read")
public class ReadGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.  declare the variables
		String urlServlet = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true"
				+ "&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatetimeCode=false"
				+ "&serverTimezone=UTC"; 
		
		String sql = "select * from productos";
		
		String nombreUsuario ="root";
		String password= "root";
		//2.  declare objects
		Connection conn = null;
		Statement stmnt= null;
		ResultSet rs = null;
			
		//3. instance driver
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(urlServlet,nombreUsuario,password);
				stmnt = conn.createStatement();
				rs = stmnt.executeQuery(sql);
				while(rs.next())
				{
					response.getWriter().append("<p>");
					response.getWriter().append("idProducto:"+rs.getInt(1));
					response.getWriter().append("<br>");
					response.getWriter().append("nombreProducto:"+rs.getString(2));
					response.getWriter().append("<br>");
					response.getWriter().append("precioProducto:"+rs.getDouble(3));
					response.getWriter().append("</p>");
				}
				
				
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		//4. open connections
		//5. prepare statement
		//6. execute sentence
		//7. process output
		//8. close connection
		
	}

}
