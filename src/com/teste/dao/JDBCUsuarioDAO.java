package com.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teste.model.Endereco;
import com.teste.model.Usuario;
import com.teste.util.ConnectionFactory;

public class JDBCUsuarioDAO implements UsuarioDAO{
	
	private Connection connection;
	
	public JDBCUsuarioDAO() throws ClassNotFoundException, SQLException {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Object object) {
		Usuario usuario = (Usuario) object;
		
		/*
		String SQL = "INSERT INTO tbUsuario (nome, sobrenome, telefone, email, login, senha, fraseRec, pais, estado, cidade, "
				+ "rua, bairro, num, cep)"
				+ " VALUES('" + usuario.getNome() + ", '" + usuario.getSobrenome() + "', '" + usuario.getTelefone() + "', '"
				+ usuario.getEmail() + "', '" + usuario.getLogin() + "', '" + usuario.getSenha() + "', '" + usuario.getFraseRec()
				+ "', '" + usuario.getEndereco().getPais() + "', '" + usuario.getEndereco().getEstado() + "', '"
				+ usuario.getEndereco().getCidade() + "', '" + usuario.getEndereco().getRua() + "', '" + usuario.getEndereco().getBairro()
				+ "', " + usuario.getEndereco().getNum() + ", " + usuario.getEndereco().getCep() + ")";
		*/
		String SQL = "INSERT INTO tbUsuario (nome, sobrenome, telefone, email, login, senha, fraseRec, pais, estado, cidade, "
				+ "rua, bairro, num, cep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			
			//Substitui interrogações, index é a referência de qual interrogação e não qual coluna no bd
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setLong(3, usuario.getTelefone());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getLogin());
			stmt.setString(6, usuario.getSenha());
			stmt.setString(7, usuario.getFraseRec());
			stmt.setString(8, usuario.getEndereco().getPais());
			stmt.setString(9, usuario.getEndereco().getEstado());
			stmt.setString(10, usuario.getEndereco().getCidade());
			stmt.setString(11, usuario.getEndereco().getRua());
			stmt.setString(12, usuario.getEndereco().getBairro());
			stmt.setInt(13, usuario.getEndereco().getNum());
			stmt.setInt(14, usuario.getEndereco().getCep());
			
			//Usado para inserts, updates e deletes
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(int id) {
		String SQL = "DELETE FROM tbUsuario WHERE id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
			} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Object> listar() {
		List<Object> usuarios = new ArrayList<Object>();
		String SQL = "SELECT * FROM tbUsuario";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				Endereco endereco = new Endereco();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setTelefone(rs.getLong("telefone"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setFraseRec(rs.getString("fraseRec"));
				endereco.setPais(rs.getString("pais"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setNum(rs.getInt("num"));
				endereco.setCep(rs.getInt("cep"));
				usuario.setEndereco(endereco);
				
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			connection.close();
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Usuario buscar(int id) {
		String SQL = "SELECT * FROM tbUsuario WHERE id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Usuario usuario = new Usuario();
				Endereco endereco = new Endereco();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setTelefone(rs.getLong("telefone"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setFraseRec(rs.getString("fraseRec"));
				endereco.setPais(rs.getString("pais"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setNum(rs.getInt("num"));
				endereco.setCep(rs.getInt("cep"));
				usuario.setEndereco(endereco);
				
				rs.close();
				stmt.close();
				connection.close();
				
				return usuario;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void editar(Object object) {
		Usuario usuario = (Usuario) object;
		String SQL = "UPDATE tbUsuario SET nome=?, sobrenome=? WHERE id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(SQL);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setInt(3, usuario.getId());
			
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
