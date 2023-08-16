package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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
		
		 	DaoUsuario daoUsuario = new DaoUsuario();
			
		 	String nomeUsuario = " ";
		 	String botaoFormulario = "Novo";
		 	
			HttpSession sessao = request.getSession();
			
			Usuario usuarioLogado = (Usuario) sessao.getAttribute("UsuarioSessao");
			
			if(usuarioLogado== null) {
				response.sendRedirect(request.getContextPath() + "/login");
			}else {
				
			
			if(usuarioLogado.getPerfil().equals("ADM")) {
		 
				 String acao = request.getParameter("action");
				
				 if(acao != null && acao.equals("delete") ) {
					  nomeUsuario = request.getParameter("nome");
					 daoUsuario.deletarUsuario(nomeUsuario);
					 response.sendRedirect(request.getContextPath() + "/cadastroUsuario");
					 
				 }
				 
				 if(acao != null && acao.equals("edit") ) {
					  nomeUsuario = request.getParameter("nome");
					  botaoFormulario = "Alterar";
					 
					 
					 
				 }
				 
				 
				 
				 
				 List<Usuario> usuarios = daoUsuario.buscarListaUsuario();
				 
				 StringBuilder linhasDaTabela  = new StringBuilder();
				 
				 for (Usuario usuario : usuarios) {
					linhasDaTabela.append("<tr>\r\n");
					linhasDaTabela.append(" <td>").append(usuario.getNome()).append("</td>\r\n");
					linhasDaTabela.append(" <td>").append(usuario.getPerfil()).append("</td>\r\n");
					linhasDaTabela.append("    <td>\r\n");
					linhasDaTabela.append("        <a href=\"cadastroUsuario?action=edit&nome=" + usuario.getNome() + "\" class=\"btn-editar\">Editar</a>\r\n");
					linhasDaTabela.append("    <td>\r\n");
					linhasDaTabela.append("        <a href=\"cadastroUsuario?action=delete&nome=" + usuario.getNome() + "\" class=\"btn-deletar\">Deletar</a>\r\n");
					linhasDaTabela.append("    </td>\r\n");
					linhasDaTabela.append("</tr>\r\n");
				  
					
				 }
				 
				 
				 String htmlResponse = "<!DOCTYPE html>\r\n"
				 		+ "<html>\r\n"
				 		+ "<head>\r\n"
				 		+ "    <meta charset=\"UTF-8\">\r\n"
				 		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				 		+ "    <title>Barra de Navegação</title>\r\n"
				 		+ "    <style>\r\n"
				 		+ "        /* Seus estilos CSS aqui */\r\n"
				 		+ "        table.custom-table {\r\n"
				 		+ "            width: 100%;\r\n"
				 		+ "            border-collapse: collapse;\r\n"
				 		+ "            margin-top: 20px;\r\n"
				 		+ "            border: 1px solid #ccc;\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
				 		+ "        table.custom-table th, table.custom-table td {\r\n"
				 		+ "            padding: 8px;\r\n"
				 		+ "            text-align: left;\r\n"
				 		+ "            border: 1px solid #ccc;\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
				 		+ "        table.custom-table th {\r\n"
				 		+ "            background-color: #f2f2f2;\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
				 		+ "        .btn-editar,\r\n"
				 		+ "        .btn-deletar,\r\n"
				 		+ "        .btn-enviar {\r\n"
				 		+ "            padding: 6px 10px;\r\n"
				 		+ "            background-color: #007bff;\r\n"
				 		+ "            color: white;\r\n"
				 		+ "            border: none;\r\n"
				 		+ "            cursor: pointer;\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
				 		+ "        .btn-deletar {\r\n"
				 		+ "            background-color: #ff4444;\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
				 		+ "        .btn-enviar {\r\n"
				 		+ "            background-color: #00cc00; /* Cor verde */\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
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
				 		+ "            color: black; \r\n"
				 		+ "            text-align: center;\r\n"
				 		+ "            padding: 14px 16px;\r\n"
				 		+ "            text-decoration: none;\r\n"
				 		+ "        }\r\n"
				 		+ "\r\n"
				 		+ "        ul.navbar li a:hover {\r\n"
				 		+ "            background-color: #e0e0e0; \r\n"
				 		+ "        }\r\n"
				 		+ "    </style>\r\n"
				 		+ "</head>\r\n"
				 		+ "<body>\r\n"
				 		+ "    <nav>\r\n"
				 		+ "        <ul class=\"navbar\">\r\n"
				 		+ "            <li><a href=\"#\">Inicio</a></li>\r\n"
				 		+ "            <li><a href=\"#\">Sobre</a></li>\r\n"
				 		+ "            <li><a href=\"cadastroUsuario\">Administrar</a></li>\r\n"
				 		+ "        </ul>\r\n"
				 		+ "    </nav><br>\r\n"
				 		+ "    <form action=\"cadastroUsuario\" method=\"post\">\r\n"
				 		+ "        <label>Nome:</label>\r\n"
				 		+ "<input value=\""+nomeUsuario+"\" type=\"text\" id=\"nome\" name=\"nome\" autocomplete=\"off\">"
				 		+ "\r\n"
				 		+ "        <label>Senha:</label>\r\n"
				 		 +" <input value=\"\" type=\"password\" id=\"senha\" name=\"senha\" autocomplete=\"off\">"
				 		+ "\r\n"
				 		+ "        <label>Perfil:</label>\r\n"
				 		+ "        <select id=\"perfil\" name=\"perfil\">\r\n"
				 		+ "            <option value=\"\"></option>\r\n"
				 		+ "            <option value=\"ADM\">ADM</option>\r\n"
				 		+ "            <option value=\"COMUM\">COMUM</option>\r\n"
				 		+ "        </select>\r\n"
				 		+ "\r\n"
				 		+ "        <button class=\"btn-enviar\" type=\"submit\">"+botaoFormulario+"</button>\r\n"
				 		+ "    </form>\r\n"
				 		+ "\r\n"
				 		+ "    <table class=\"custom-table\">\r\n"
				 		+ "        <tr>\r\n"
				 		+ "            <th>Nome</th>\r\n"
				 		+ "            <th>Perfil</th>\r\n"
				 		+ "            <th>Editar</th>\r\n"
				 		+ "            <th>Deletar</th>\r\n"
				 		+ "        </tr>\r\n"
				 		+ linhasDaTabela.toString()
				 		+ "    </table>\r\n"
				 		+ "</body>\r\n"
				 		+ "</html>"
						 ;
			 
				 		response.getWriter().println(htmlResponse);
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
	
		if (daoUsuario.verificarUsuario(usuario)) {
			daoUsuario.alterarUsuarioBanco(usuario);
		}else {
			daoUsuario.salvarUsuarioBanco(usuario);
		}
		
		
		
		
		response.sendRedirect(request.getContextPath()+ "/cadastroUsuario");
	
	
	
	}
	
	

	

}
