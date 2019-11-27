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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.  declare the variables
				String urlServlet = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true"
						+ "&useJDBCCompliantTimezoneShift=true"
						+ "&useLegacyDatetimeCode=false"
						+ "&serverTimezone=UTC"; 
				int idTxt = Integer.parseInt(request.getParameter("txtId")) ;
				
				String sql = "DELETE FROM `tiendita`.`productos` WHERE (`idProducto` = "+idTxt+");";
				
				String nombreUsuario ="root";
				String password= "root";
				int rowsAffected = 0;
				String result = "";
				
				//2 declaramos los objetos
				Connection conn = null;
				Statement stmnt= null;
				ResultSet rs = null;
				
				//3 Instanciamos el driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(urlServlet,nombreUsuario,password);
					stmnt = conn.createStatement();
					rowsAffected = stmnt.executeUpdate(sql);
					if(rowsAffected != 0)
					{
						result ="Deleted Successfull!";
					}
					else
					{
						result ="Not Success!";
					}
					stmnt.close();//in this order
					conn.close();
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
				response.getWriter().append(result);	
	}

}
