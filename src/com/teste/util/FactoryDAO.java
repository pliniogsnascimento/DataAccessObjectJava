package com.teste.util;

import java.sql.SQLException;

import com.teste.dao.JDBCUsuarioDAO;
import com.teste.dao.UsuarioDAO;


/**
 * Em caso de mudança de banco de dados, só troca este método
 * @author plinio
 *
 */
public class FactoryDAO {
	public static UsuarioDAO createUsuarioDAO() throws ClassNotFoundException, SQLException {
		return new JDBCUsuarioDAO();
	}
}
