package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import security.Autenticar;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	// Metodo responsavel por aprensetar o formulario de login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}


	
	//Metodo responsavel por executar a ação do botão submit do login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Inicializa o objeto Usuario
		Usuario usuarioTentandoAutenticar = new Usuario();
		
		Usuario usuarioAutenticado = new Usuario();
		
		// Inicializa a Classe  autenticar
		Autenticar autenticar = new Autenticar();
		
		// busca o elemento userName na requisição
		usuarioTentandoAutenticar.setNome(request.getParameter("username"));
		// busca o elemento  na requisição
		usuarioTentandoAutenticar.setSenha(request.getParameter("password"));
		
		usuarioAutenticado = autenticar.autenticarUsuario(usuarioTentandoAutenticar);
		
		//Separa uma sessao para o sistema no servidor
		HttpSession sessao = request.getSession();
		
		// Verificar se o usuario foi atenticado 
		if( usuarioAutenticado != null) {
			sessao.setAttribute("UsuarioSessao", usuarioAutenticado);
			
			// Direciona para a pagina /menuAdm
			response.sendRedirect(request.getContextPath()+ "/menuAdm");
			
			// Direciona Caso o login esteja errado
		}else {
			response.sendRedirect(request.getContextPath()+ "/erroLogin");
		}
		
	}

}
