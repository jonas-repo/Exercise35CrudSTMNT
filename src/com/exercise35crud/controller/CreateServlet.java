package com.exercise35crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Application/json charset='utf-8");
		PrintWriter output = response.getWriter();
		
		String nombreProducto = request.getParameter("txtNameProduct");
		double priceProduct =Double.parseDouble(request.getParameter("txtPriceProduct")) ;
		
		//1 declaramos objetos
		String urlServidor = "jdbc:mysql://localhost:3306/tiendita?useUnicode=true"
				+ "&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatetimeCode=false"
				+ "&serverTimezone=UTC"; 
				
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
			conn = DriverManager.getConnection(urlServidor,nombreUsuario,password);
			stmnt = conn.createStatement();
			rowsAffected = stmnt.executeUpdate("insert into productos (nombreProducto,precioProducto)"
					+"values ('"+nombreProducto+"',"+priceProduct+")");
			if(rowsAffected != 0)
			{
				result ="Success!";
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
		
		//4 Abrimos la conexion
		//5 ejecutamos la sentencia sql
		//6 procesamos los datos
		//7 Cerramos los objetos de conexion
	
		
		output.append(result);
	}

}
