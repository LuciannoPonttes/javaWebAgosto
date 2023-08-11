package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class DaoUsuario {

	public boolean salvarUsuarioBanco(Usuario usuario) {

		FabricaConexao fabricaConexao = new FabricaConexao();

		boolean salvamento = false; // Resposta do metodo
		String comandoSqlInsert = "insert into tb_usuario(nome,perfil, senha) values(?,?,?)";// Comando SQL

		Connection conexaoRecebida = null; // Recebe a conexao
		PreparedStatement declaracaoComando = null; // Preparação do comando

		try {
			conexaoRecebida = fabricaConexao.criarConexaoDb_usuarios();

			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);// Preparação do
																										// comanda
																										// recebe o
																										// banco e o
																										// comando SQL

			declaracaoComando.setString(1, usuario.getUsuario().toUpperCase());
			declaracaoComando.setString(2, usuario.getPerfil().toUpperCase());
			declaracaoComando.setString(3, usuario.getSenha());

			declaracaoComando.execute();

			salvamento = true;
			System.out.println("Jogador Registrado com sucesso");

			

		} catch (Exception mensagemErro) {
			System.out.println(mensagemErro);
			System.out.println("Erro ao salvar!");
			salvamento = false;

		} finally { 

			try {

				if (conexaoRecebida != null) {
					conexaoRecebida.close();
				}

				if (declaracaoComando != null) {
					declaracaoComando.close();
				}

			} catch (Exception msgErro) {
				System.out.println(msgErro);
				System.out.println("Erro ao tentar fechar a conexao");
			}

		}

		return salvamento;

	}
	
	
}
