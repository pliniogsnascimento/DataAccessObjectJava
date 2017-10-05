package com.teste.dao;

import java.util.List;

import com.teste.model.Usuario;

public interface UsuarioDAO {
	public void inserir(Object object);
	public void remover(int id);
	public List<Object> listar();
	public Object buscar(int id);
	public void editar(Object object);
}
