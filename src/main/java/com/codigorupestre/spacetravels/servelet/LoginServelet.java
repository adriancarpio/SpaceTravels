package com.codigorupestre.spacetravels.servelet;

import java.io.IOException;

import com.codigorupestre.spacetravels.clases.Usuario;
import com.codigorupestre.spacetravels.dao.UsuarioDAO;
import com.codigorupestre.spacetravels.impl.UsuarioDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServelet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		usuarioDAO = new UsuarioDAOImpl();
		
		String usuario = req.getParameter("userName");
		String password = req.getParameter("password");
		
		 Usuario usuarioLogin = usuarioDAO.consultarUsuario(usuario, password);
		 
		 System.out.println("Usuario recuperado :" + usuarioLogin);
		
		if (usuario.equals(usuarioLogin.usuario) && password.equals(usuarioLogin.contrasena)) {
			System.out.println("Login exitoso");
			req.setAttribute("nombre", usuarioLogin.nombre + " " + usuarioLogin.apellidos);
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, resp);
		} else {
			System.out.println("Login Incorrecto");
		}
	}

}
