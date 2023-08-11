package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;

import model.Usuario;

public class DaoUsuario {

	public boolean salvarUsuarioBanco(Usuario usuario) {
		
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		boolean salvar = false;
		
		String comandoSqlInsert = "insert into tb_usuario (nome, perfil, senha) values (?, ?, ?)";
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		try {
			
			conexaoRecebida = fabricaConexao.criarConexoBancoUsuario();
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);
			
			declaracaoComando.setString(1, usuario.getNome().toUpperCase());
			declaracaoComando.setString(2, usuario.getPerfil().toUpperCase());
			declaracaoComando.setString(3, usuario.getSenha());
			
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
