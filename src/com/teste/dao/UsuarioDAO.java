package com.teste.dao;

import java.util.List;

import com.teste.model.Usuario;

public interface UsuarioDAO {
	public void inserir(Usuario usuario);
	public void remover(int id);
	public List<Usuario> listar();
	public Usuario buscar(int id);
	public void editar(Usuario usuario);
}
