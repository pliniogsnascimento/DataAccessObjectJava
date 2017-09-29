package com.teste.testes;

import java.sql.SQLException;

import com.teste.dao.UsuarioDAO;
import com.teste.util.FactoryDAO;

public class ExcluirTeste {
	public static void main(String[] args) {
		try {
			UsuarioDAO dao = FactoryDAO.createUsuarioDAO();
			dao.remover(3);
			System.out.println("Usuario removido com sucesso");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
