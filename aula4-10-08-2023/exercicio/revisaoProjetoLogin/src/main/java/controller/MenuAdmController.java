package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MenuAdmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Barra de Navegação</title>\r\n"
				+ "    <style>\r\n"
				+ "       \r\n"
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
				+ "    <ul class=\"navbar\">\r\n"
				+ "        <li><a href=\"#\">Inicio</a></li>\r\n"
				+ "        <li><a href=\"#\">Sobre</a></li>\r\n"
				+ "        <li><a href=\"cadastroUsuario\">Administrar</a></li>\r\n"
				+ "    </ul>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	
	

}
