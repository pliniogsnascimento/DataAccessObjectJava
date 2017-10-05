package com.teste.testes;

import java.util.List;

import com.teste.dao.UsuarioDAO;
import com.teste.model.Usuario;
import com.teste.util.FactoryDAO;

public class ListarTeste {
	public static void main(String[] args) {
		try {
			UsuarioDAO pd = FactoryDAO.createUsuarioDAO();
			List<Object> lista = pd.listar(); 
			
			for(Object object:lista) {
				Usuario usuario = (Usuario) object;
				System.out.println(usuario.toString());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
