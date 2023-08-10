package seguranca;

import model.Usuario;

public class Autenticar {

	public Usuario autenticarUsuario(Usuario usuario) {
		
		String senhaBanco = "123";
		
		if(usuario.getUsuario().equals("Juliana")) {
			usuario.setPerfil("ADM");
		}
		
		if(usuario.getUsuario().equals("Gabriel")) {
			usuario.setPerfil("COMUM");
		}
		
		
		if(usuario.getUsuario().equals("Juliana") || usuario.getUsuario().equals("Gabriel")) {
			
			if(senhaBanco.equals(usuario.getSenha())) {
				return usuario;
			
			}else {
				return null;
			}
		
		}else {
			return null;
		}
	}
	
}
