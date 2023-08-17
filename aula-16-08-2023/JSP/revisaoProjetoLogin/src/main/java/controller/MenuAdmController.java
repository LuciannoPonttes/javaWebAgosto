package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


public class MenuAdmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		Usuario usuarioLogado = (Usuario) sessao.getAttribute("UsuarioSessao");
		
		if(usuarioLogado== null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}else {
			request.getRequestDispatcher("WEB-INF/menuAdm.jsp").forward(request, response);
		}
	}

	
	

}