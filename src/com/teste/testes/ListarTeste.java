package com.teste.testes;

import java.util.List;

import com.teste.dao.UsuarioDAO;
import com.teste.model.Usuario;
import com.teste.util.FactoryDAO;

public class ListarTeste {
	public static void main(String[] args) {
		try {
			UsuarioDAO pd = FactoryDAO.createUsuarioDAO();
			List<Usuario> lista = pd.listar(); 
			
			for(Usuario usuario:lista) {
				System.out.println(usuario);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
