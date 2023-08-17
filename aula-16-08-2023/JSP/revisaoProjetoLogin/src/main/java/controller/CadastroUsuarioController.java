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
				
				response.getWriter().println("<!DOCTYPE html>\r\n"
						+ "\r\n"
						+ "<html>\r\n"
						+ "	<meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Barra de Navegação</title>\r\n"
						+ "    <style>\r\n"
						+ "        ul.navbar {\r\n"
						+ "            list-style-type: none;\r\n"
						+ "            margin: 0;\r\n"
						+ "            padding: 0;\r\n"
						+ "            background-color: #007bff;\r\n"
						+ "            overflow: hidden;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        ul.navbar li {\r\n"
						+ "            float: left;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        ul.navbar li a {\r\n"
						+ "            display: block;\r\n"
						+ "            color: black;\r\n"
						+ "            text-align: center;\r\n"
						+ "            padding: 14px 16px;\r\n"
						+ "            text-decoration: none;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        ul.navbar li a:hover {\r\n"
						+ "            background-color: #e0e0e0;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "		 form {\r\n"
						+ "            margin-top: 20px;\r\n"
						+ "            padding: 20px;\r\n"
						+ "            border: 1px solid #ccc;\r\n"
						+ "            background-color: #f5f5f5;\r\n"
						+ "            width: 300px;\r\n"
						+ "            margin: 0 auto;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        form label,\r\n"
						+ "        form input,\r\n"
						+ "        form select {\r\n"
						+ "            display: block;\r\n"
						+ "            margin-bottom: 10px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        form input[type=\"submit\"] {\r\n"
						+ "            background-color: #007bff;\r\n"
						+ "            color: white;\r\n"
						+ "            border: none;\r\n"
						+ "            padding: 10px 15px;\r\n"
						+ "            cursor: pointer;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        form input[type=\"submit\"]:hover {\r\n"
						+ "            background-color: #0056b3;\r\n"
						+ "        }\r\n"
						+ "	</style>\r\n"
						+ "	<body>\r\n"
						+ "	\r\n"
						+ "	<ul class=\"navbar\">\r\n"
						+ "        <li><a href=\"#\">Inicio</a></li>\r\n"
						+ "        <li><a href=\"#\">Sobre</a></li>\r\n"
						+ "        <li><a href=\"cadastroUsuario\">Administrar</a></li>\r\n"
						+ "    </ul>\r\n"
						+ "	\r\n"
						+ "		<form action=\"cadastroUsuario\" method=\"post\" >\r\n"
						+ "		<label>Nome:</label>\r\n"
						+ "		<input type=\"text\" id=\"nome\" name=\"nome\">\r\n"
						+ "		\r\n"
						+ "		<label>Senha:</label>\r\n"
						+ "		<input type=\"password\" id=\"senha\" name=\"senha\">\r\n"
						+ "		\r\n"
						+ "		<label>Perfil:</label>\r\n"
						+ "		<select id=\"perfil\" name=\"perfil\">\r\n"
						+ "			<option value=\"ADM\">ADM</option>\r\n"
						+ "			<option value=\"COMUM\">COMUM</option>\r\n"
						+ "		</select><br>\r\n"
						+ "		\r\n"
						+ "		<input type=\"submit\" value=\"Enviar\">\r\n"
						+ "		\r\n"
						+ "	</form>\r\n"
						+ "		\r\n"
						+ "		\r\n"
						+ "	</body>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</html>");
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
	}
	

	

}
