package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import security.Autenticar;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "	<meta charset=\"UTF-8\">\r\n"
				+ "	<title>Tela de Login</title>\r\n"
				+ "	<style>\r\n"
				+ "		body {\r\n"
				+ "           	 	font-family: Arial, sans-serif;\r\n"
				+ "            		background-color: #f4f4f4;\r\n"
				+ "            		margin: 0;\r\n"
				+ "            		padding: 0;\r\n"
				+ "            		display: flex;\r\n"
				+ "            		justify-content: center;\r\n"
				+ "            		align-items: center;\r\n"
				+ "            		min-height: 100vh;\r\n"
				+ "        	}\r\n"
				+ "		\r\n"
				+ "		 .login-container {\r\n"
				+ "            		background-color: #fff;\r\n"
				+ "            		padding: 20px;\r\n"
				+ "            		border-radius: 5px;\r\n"
				+ "            		box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n"
				+ "            		width: 300px;\r\n"
				+ "       		 }\r\n"
				+ "\r\n"
				+ "		 .login-container h2 {\r\n"
				+ "            		 text-align: center;\r\n"
				+ "           		 margin-bottom: 25px;\r\n"
				+ "        	 }\r\n"
				+ "		 .form-group {\r\n"
				+ "            		margin-bottom: 15px;\r\n"
				+ "        	 }\r\n"
				+ "		\r\n"
				+ "		 label {\r\n"
				+ "            		display: block;\r\n"
				+ "            		font-weight: bold;\r\n"
				+ "            		margin-bottom: 5px;\r\n"
				+ "        	}\r\n"
				+ "		\r\n"
				+ "		input[type=\"text\"], input[type=\"password\"] {\r\n"
				+ "            		width: 90%;\r\n"
				+ "            		padding: 8px;\r\n"
				+ "            		border: 1px solid #ccc;\r\n"
				+ "            		border-radius: 3px;\r\n"
				+ "        	}\r\n"
				+ "		\r\n"
				+ "		button {\r\n"
				+ "           	  background-color: #007bff;\r\n"
				+ "            	  color: #f4f4f4;\r\n"
				+ "            	  border: none;\r\n"
				+ "            	  padding: 10px 20px;\r\n"
				+ "                  border-radius: 3px;\r\n"
				+ "                  cursor: pointer;\r\n"
				+ "            	  width: 100%;\r\n"
				+ "        	}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "	</style>\r\n"
				+ "	\r\n"
				+ "	\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "	<body>\r\n"
				+ "	  <div class=\"login-container\">\r\n"
				+ "		<h2>Tela de Login</h2>\r\n"
				+ "		<form action=\"login\" method=\"post\" >\r\n"
				+ "			<div class=\"form-group\">\r\n"
				+ "				<label form=\"username\">Usuario:</label>\r\n"
				+ "				<input type=\"text\" id=\"username\" name=\"username\" required>\r\n"
				+ "			</div>\r\n"
				+ "			<div class=\"form-group\">\r\n"
				+ "				<label form=\"password\">Senha:</label>\r\n"
				+ "				<input type=\"password\" id=\"password\" name=\"password\" required>\r\n"
				+ "			</div>\r\n"
				+ "			<button type=\"submit\">Entrar</button>\r\n"
				+ "\r\n"
				+ "		</form>	\r\n"
				+ "	</div>\r\n"
				+ "			\r\n"
				+ "	</body>\r\n"
				+ "</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuarioTentandoAutenticar = new Usuario();
		Usuario usuarioAutenticado = new Usuario();
		
		Autenticar autenticar = new Autenticar();
		
		usuarioTentandoAutenticar.setNome(request.getParameter("username"));
		usuarioTentandoAutenticar.setSenha(request.getParameter("password"));
		usuarioAutenticado = autenticar.autenticarUsuario(usuarioTentandoAutenticar);
		if( usuarioAutenticado != null) {
			if(usuarioAutenticado.getPerfil().equals("ADM")) {
				response.sendRedirect(request.getContextPath()+ "/menuAdm");
			}
			
			if(usuarioAutenticado.getPerfil().equals("COMUM")) {
				response.sendRedirect(request.getContextPath()+ "/menuComum");
			}
		
		
		}else {
			response.sendRedirect(request.getContextPath()+ "/erroLogin");
		}
		
	}

}
