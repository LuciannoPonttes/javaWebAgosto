package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class FabricaConexao {
	private String USUARIO = "root";
	private String SENHA = "root";
	
	private static String BANCO_URL_USUARIOS = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC";
	
	public Connection criarConexoBancoUsuario() {
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexao = DriverManager.getConnection(BANCO_URL_USUARIOS, USUARIO, SENHA);
			System.out.println("Conexão Realizada");
	
		} catch (Exception e) {
			System.out.println("Erro na conexão");
		}
		return conexao;
	}

}
