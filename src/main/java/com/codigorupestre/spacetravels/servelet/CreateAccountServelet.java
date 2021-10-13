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

@WebServlet("/account")
public class CreateAccountServelet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8375118784034517540L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.nombre = req.getParameter("nombre");
		usuario.apellidos = req.getParameter("apellidos");
		usuario.usuario = req.getParameter("usuario");
		usuario.contrasena = req.getParameter("password");
		usuario.email = req.getParameter("email");
		usuario.telefono = req.getParameter("telefono");

		System.out.println(usuario);
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.insertarUsuario(usuario);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);

	}

}
