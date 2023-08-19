package controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import persistence.DaoUsuario;



public class CadastroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		Usuario usuarioLogado = (Usuario) sessao.getAttribute("UsuarioSessao");
		
		if(usuarioLogado== null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}else {
			
		
			if(usuarioLogado.getPerfil().equals("ADM")) {
				
				request.getRequestDispatcher("WEB-INF/cadastroUsuario.jsp").forward(request, response);
			
			}else {
				response.getWriter().println("Acesso Negado!!");
			}
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		Usuario usuario = new Usuario();
		DaoUsuario daoUsuario = new DaoUsuario();
		
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setPerfil(request.getParameter("perfil"));
	
		
		daoUsuario.salvarUsuarioBanco(usuario);
		request.getRequestDispatcher("WEB-INF/cadastroUsuario.jsp").forward(request, response);
	}
	

	

}
