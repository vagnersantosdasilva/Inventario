<%@page import="Controle.*"%>
<%@page import="java.lang.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
    <HEAD>
        
        <TITLE>Login</TITLE>
        <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <!-- Bootstrap -->
            <link href="suporte/css/bootstrap.css" rel="stylesheet">

            <link href="suporte/css/jumbotron-narrow.css" rel="stylesheet">
           
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>    

	    <![endif]-->	
	<style>
		.jumbotron{
			width:50%;
			margin:auto;
			
			}
	</style>

    </HEAD>
    
    <BODY>
	
	
	
	
	 <div class="container"><br><br><br><br><br>

             <div class="jumbotron" >

		  <div class="header clearfix">
			<nav>
			  <ul class="nav nav-pills pull-right">
			    <!--<li role="presentation" ><a href="login.php">Login</a></li>-->
			    <li role="presentation" ><a href="recuperarSenha.php">Esqueci a senha</a></li>
			    <li role="presentation"><a href="cadastro.php">Novo cadastro</a></li>
			    
			  </ul>
			</nav>
		<br>
		<!--<h3 class="text-muted">Controle de Acesso</h3>-->
	
          </div>

				      
			<form class="form-signin" method="post" action="autenticar" > 
				<h2 class="form-signin-heading">Identifique-se</h2>
                                    					
					<label for="inputLogin" class="sr-only">login</label>
					<input name="nomeUsuario" type="text" id="inputLogin" class="form-control" placeholder="Login" required autofocus >
					<label for="inputPassword" class="sr-only" >senha</label>
					<input name="acesso" type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
		    
					<label><br>
						<button class="btn btn-lg btn-primary btn-lg" type="submit">Enviar</button>
					</label>
		     </form>
		     <c:if test="${sessionScope.mensagem=='1' }">
		        <div class="ui-widget">
		  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
		  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
		  			<strong>Hey!</strong> Você não teve autorização</p>
		  			
		  		</div>
		  	</div>
		    </c:if>  
		     
		      
		</div> <!-- /jumbotron -->    			 
                   
         </div> <!-- /container -->
   
		
		 	
			
			
    

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="suporte/js/bootstrap.min.js"></script>
        
   </BODY>
</HTML>