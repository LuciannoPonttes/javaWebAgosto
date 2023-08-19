package security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Usuario;
import persistence.DaoUsuario;

public class Autenticar {

	
	// Verifica se o usuario é credenciado
	public Usuario autenticarUsuario(Usuario usuario) {
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		List<Usuario> usuariosBanco = daoUsuario.buscarListaUsuario();
			
		
		for (Usuario usuarioBanco : usuariosBanco) {
			if (usuario.getNome().toUpperCase().equals(usuarioBanco.getNome()) 
					&& usuario.getSenha().equals(usuarioBanco.getSenha())) {
				
				return usuarioBanco;
			}
			
		}
		
		return null;
		
	}
	
	
}