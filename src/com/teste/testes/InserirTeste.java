package com.teste.testes;

import java.sql.SQLException;

import com.teste.dao.JDBCUsuarioDAO;
import com.teste.dao.UsuarioDAO;
import com.teste.model.Endereco;
import com.teste.model.Usuario;
import com.teste.util.FactoryDAO;

public class InserirTeste {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		Endereco endereco = new Endereco();
		
		
		usuario.setNome("José");
		usuario.setSobrenome("Gomes");
		usuario.setTelefone(989319136);
		usuario.setEmail("jose@outlook.com");
		usuario.setLogin("jose");
		usuario.setSenha("jose123");
		usuario.setFraseRec("Linux is the best");
		endereco.setPais("Brasil");
		endereco.setEstado("São Paulo");
		endereco.setCidade("São Paulo");
		endereco.setRua("Flores");
		endereco.setBairro("São Lucas");
		endereco.setNum(142);
		endereco.setCep(03250000);
		usuario.setEndereco(endereco);
		
		try {
			UsuarioDAO dao = FactoryDAO.createUsuarioDAO();
			dao.inserir(usuario);
			System.out.println("Usuario inserido com sucesso!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
