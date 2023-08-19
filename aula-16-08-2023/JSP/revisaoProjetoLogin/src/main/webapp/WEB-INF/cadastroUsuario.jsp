<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page  import="persistence.*" %>
<%@ page  import="model.Usuario" %>
<%@ page  import="java.util.List" %>


 <!DOCTYPE html>
<html>
<!DOCTYPE html>
<html>


<!--Codigo Java  -->
<%

	DaoUsuario daoUsuario = new DaoUsuario();
	List<Usuario> usuarios = daoUsuario.buscarListaUsuario();

%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Barra de Navegação</title>
    <style>
        /* Seus estilos CSS aqui */
        table.custom-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            border: 1px solid #ccc;
        }

        table.custom-table th, table.custom-table td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ccc;
        }

        table.custom-table th {
            background-color: #f2f2f2;
        }

        .btn-editar,
        .btn-deletar,
        .btn-enviar {
            padding: 6px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        .btn-deletar {
            background-color: #ff4444;
        }

        .btn-enviar {
            background-color: #00cc00; /* Cor verde */
        }

        ul.navbar {
            list-style-type: none;
            margin: 0;
            padding: 0;
            background-color: #007bff;
            overflow: hidden;
        }

        ul.navbar li {
            float: left;
        }

        ul.navbar li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.navbar li a:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <nav>
        <ul class="navbar">
            <li><a href="#">Inicio</a></li>
            <li><a href="#">Sobre</a></li>
            <li><a href="cadastroUsuario">Administrar</a></li>
        </ul>
    </nav><br>
    <form action="cadastroUsuario" method="post">
        <label>Nome:</label>
        <input value="" type="text" id="nome" name="nome" autocomplete="off">
        
        <label>Senha:</label>
        <input value="" type="password" id="senha" name="senha" autocomplete="off">
        
        <label>Perfil:</label>
        <select id="perfil" name="perfil">
            <option value=""></option>
            <option value="ADM">ADM</option>
            <option value="COMUM">COMUM</option>
        </select>
        
        <button class="btn-enviar" type="submit">Enviar</button>
    </form>
    
    <table class="custom-table">
        <tr>
            <th>Nome</th>
            <th>Perfil</th>
             
        </tr>
        <% for(Usuario usuario: usuarios) {%>
        	
        	<tr>
        		<td><%= usuario.getNome() %></td> <!-- Usar o igual no lugar do ;  -->
        		<td><%= usuario.getPerfil() %></td> <!-- Usar o igual no lugar do ;  -->
        	
        	</tr>
        <% } %>
        
        
        
        
        </table>
      
 		
       
    
    
</body>
</html>