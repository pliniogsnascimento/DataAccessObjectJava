package com.teste.testes;

import java.sql.SQLException;

import com.teste.dao.UsuarioDAO;
import com.teste.model.Usuario;
import com.teste.util.FactoryDAO;

public class UpdateTeste {

	public static void main(String[] args) {
		try {
			UsuarioDAO dao = FactoryDAO.createUsuarioDAO();
			Usuario usuario = new Usuario();
			
			usuario.setId(2);
			usuario.setNome("José");
			usuario.setSobrenome("Silva");
			
			dao.editar(usuario);
			
			System.out.println("Dados alterados com sucesso!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
