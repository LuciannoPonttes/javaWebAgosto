package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;

import model.Usuario;

public class DaoUsuario {

	public boolean salvarUsuarioBanco(Usuario usuario) {
		
		//Inicializa a classe que cria a conexão
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		boolean salvar = false;
		
		// Comando SQL que sera usado no banco de dados
		String comandoSqlInsert = "insert into tb_usuario (nome, perfil, senha) values (?, ?, ?)";
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		try {
			
			//Armazena a conexão
			conexaoRecebida = fabricaConexao.criarConexoBancoUsuario();
			
			//Prepara o comando que sera enviado para o banco
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);
			
			// Passa os parametros Values da query SQL
			declaracaoComando.setString(1, usuario.getNome().toUpperCase());
			declaracaoComando.setString(2, usuario.getPerfil().toUpperCase());
			declaracaoComando.setString(3, usuario.getSenha());
			
			//Executa a query
			declaracaoComando.execute();
			
			
			System.out.println("Salvo com sucesso");
			salvar = true;
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar o Usuario");
			
		}finally {
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
				
			} catch (Exception e2) {
				System.out.println("Erro ao fechar Conexao!!");
			}
			
			
		}
		
		
		return salvar;
	}
	
	
	
}
