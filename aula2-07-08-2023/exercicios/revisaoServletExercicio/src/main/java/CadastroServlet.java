

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");// Tipo de conteudo Retornado
		 response.getWriter().println("<!DOCTYPE html>\r\n"
	        		+ "<html>\r\n"
	        		+ "<head>\r\n"
	        		+ "    <title>Meu Formulário v 1</title>\r\n"
	        		+ "</head>\r\n"
	        		+ "<body>\r\n"
	        		+ "    <h1>Formulário de Cadastro</h1>\r\n"
	        		+ "    <form action=\"cadastroPessoa\" method=\"post\">\r\n"
	        		+ "        <label for=\"nome\">Nome:</label>\r\n"
	        		+ "        <input type=\"text\" id=\"nome\" name=\"nome\"><br><br>\r\n"
	        		+ "        <label for=\"email\">Email:</label>\r\n"
	        		+ "        <input type=\"email\" id=\"email\" name=\"email\"><br><br>\r\n"
	        		+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
	        		+ "    </form>\r\n"
	        		+ "</body>\r\n"
	        		+ "</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nome = request.getParameter("nome");
		    String email = request.getParameter("email");
		    
		   RegistraArquivo registraArquivo = new RegistraArquivo();
		  String resultado =  registraArquivo.escrevernoArquivo(nome, email);
		   
		    
		    response.getWriter().println("<!DOCTYPE html>\r\n"
		            + "<html>\r\n"
		            + "<head>\r\n"
		            + "    <title>Está a sua resposta - Tudo que você digitou</title>\r\n"
		            + "</head>\r\n"
		            + "<body>\r\n"
		            + "    <p>Resultado: " + resultado + "</p>\r\n"
		            + "</body>\r\n"
		            + "</html>");
		
	}

}
