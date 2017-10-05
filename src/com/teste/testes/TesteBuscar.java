package com.teste.testes;

import java.sql.SQLException;

import com.teste.dao.UsuarioDAO;
import com.teste.model.Usuario;
import com.teste.util.FactoryDAO;

public class TesteBuscar {

	public static void main(String[] args) {
		try {
			UsuarioDAO dao = FactoryDAO.createUsuarioDAO();
			Usuario usuario = (Usuario) dao.buscar(2);
			
			System.out.println(usuario.toString());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
