package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// Metodo para buscar todos os itens da tabela e transformar em List
	
	public List<Usuario> buscarListaUsuario(){
		String comandoSqlSelect = "SELECT * FROM tb_usuario";
		FabricaConexao fabricaConexao = new FabricaConexao();
		List<Usuario> usuarios = new ArrayList<>();
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		ResultSet resultSet = null;
		
		try {
			
			//Armazena a conexão
			conexaoRecebida = fabricaConexao.criarConexoBancoUsuario();
			
			//Prepara o comando que sera enviado para o banco
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlSelect);
			resultSet = declaracaoComando.executeQuery();
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setNome(resultSet.getString("nome"));
				usuario.setPerfil(resultSet.getString("perfil"));
				usuario.setSenha(resultSet.getString("senha"));
				usuarios.add(usuario);
				
			}
			
		
			
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
		
		
		return usuarios;
	}
	
	//delete from tb_usuario where nome = 'JULIANA';
	
	public boolean deletarUsuario(String nome) {
		String sql = "delete from tb_usuario where nome = ?";
		
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		
		
		try {
			
			//Armazena a conexão
			conexaoRecebida = fabricaConexao.criarConexoBancoUsuario();
			
			//Prepara o comando que sera enviado para o banco
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sql);
			
			declaracaoComando.setString(1, nome);
			//Executa a query
			declaracaoComando.execute();
			
			
			System.out.println("Deletado com sucesso");
			return true;
			
		} catch (Exception e) {
			System.out.println("Erro ao deletar o Usuario");
			
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
		return false;
	}
	
	public boolean alterarUsuarioBanco(Usuario usuario) {
		
		//Inicializa a classe que cria a conexão
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		boolean salvar = false;
		
		// Comando SQL que sera usado no banco de dados
		String comandoSql = "UPDATE tb_usuario SET perfil = ?, senha = ? WHERE nome = ?";
		
		Connection conexaoRecebida = null ;
		PreparedStatement declaracaoComando = null;
		try {
			
			//Armazena a conexão
			conexaoRecebida = fabricaConexao.criarConexoBancoUsuario();
			
			//Prepara o comando que sera enviado para o banco
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSql);
			
			// Passa os parametros Values da query SQL
			
			declaracaoComando.setString(1, usuario.getPerfil().toUpperCase());
			declaracaoComando.setString(2, usuario.getSenha());
			declaracaoComando.setString(3, usuario.getNome().toUpperCase());
			
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
	
	
	public boolean verificarUsuario(Usuario usuario) {
		
		
		
		List<Usuario> usuariosBanco = buscarListaUsuario();
		
		for (Usuario usuarioBanco : usuariosBanco) {
			if (usuario.getNome().toUpperCase().equals(usuarioBanco.getNome())){
					 
				
				return true;
			}
			
		}
		
		
		
		return false;
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	