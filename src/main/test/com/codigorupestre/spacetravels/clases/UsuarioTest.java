package com.codigorupestre.spacetravels.clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	public void testCreateUsuario() {
		System.out.println("Inicio prueba Unitaria");
		Usuario usuarioUno = new Usuario();

		usuarioUno.id = 1;
		usuarioUno.nombre = "Adrian";
		usuarioUno.apellidos = "Carpio Moran";
		usuarioUno.usuario = "manu";
		usuarioUno.email = "adrian@gamil.com";
		usuarioUno.telefono = "0987654321";
		usuarioUno.activo = true;
		System.out.println(usuarioUno);

		Usuario usuarioDos = new Usuario(2, "Manuel", "MoranCarpio", "adri", "1208", "manuel@gamil.com", "0999999999",
				false);
		System.out.println(usuarioDos);

		System.out.println("Termina prueba Unitaria");
	}

}
