package application.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	//ENDEREÇO DO BANCO DE DADOS
	private static final String URL="jbdc:mysql://localhost:3309/DB";
	//USUARIO DO BANCO DE DADOS
	private static final String USER="root";
	//SENHA DO BANCO DE DADOS
	private static final String PASS="98322754";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USER,PASS);
	}
	
}
