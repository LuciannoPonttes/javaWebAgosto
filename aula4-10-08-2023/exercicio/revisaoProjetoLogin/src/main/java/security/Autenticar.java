package security;

import model.Usuario;

public class Autenticar {

	public Usuario autenticarUsuario(Usuario usuario) {
		if(usuario.getNome().equals("Gabriel") || usuario.getNome().equals("Pet") ) {
			
			if(usuario.getNome().equals("Gabriel")) {
				usuario.setPerfil("ADM");	
			}
			
			if(usuario.getNome().equals("Pet")) {
				usuario.setPerfil("COMUM");
				
			}
			
			if(usuario.getSenha().equals("123")) {
				return usuario;
			}
		}
			
		return null;
		
		
		
		
		
	}
	
	
}
