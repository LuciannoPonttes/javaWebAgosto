package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class FabricaConexao {
	
	// Usuario e senha do banco de dados
	private String USUARIO = "root";
	private String SENHA = "root";
	
	// url do banco de dados
	private static String BANCO_URL_USUARIOS = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC";
	
	public Connection criarConexoBancoUsuario() {
		Connection conexao = null;
		
		try {
			// Classe do drive do banco de dados
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Cria o objeto de conexão
			conexao = DriverManager.getConnection(BANCO_URL_USUARIOS, USUARIO, SENHA);
			
			System.out.println("Conexão Realizada");
	
			
		} catch (Exception e) {
			System.out.println("Erro na conexão");
			System.out.println(e.getMessage());
			
		}
		return conexao;
	}

}
