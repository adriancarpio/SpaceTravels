package com.codigorupestre.spacetravels.servelet;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/holamundo")
public class HolaMundoServelet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Se recibe peticion GET");
		
		resp.getWriter().append("hola mundo con servelet").append(LocalDateTime.now().toString());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("Usuario: " + username);
		System.out.println("Contraseña: " + password);
		
		resp.getWriter().append("Logeo exitoso con usuario").append(username);
		
	}
	
}
