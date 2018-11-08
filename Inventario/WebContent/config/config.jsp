<%@page import="Controle.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
    <HEAD>
        
        <TITLE>Configuração de Ambiente</TITLE>
        <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <!-- Bootstrap -->
            <link href="/Inventario/suporte/css/bootstrap.css" rel="stylesheet">

            <link href="/Inventario/suporte/css/jumbotron-narrow.css" rel="stylesheet">
           
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>    

	    <![endif]-->
	    	
	

    </HEAD>
    
    <BODY>
	
	 <div class="container">
	 	

         <div class="jumbotron" >

			  <div class="header clearfix">
					<nav>
					  <ul class="nav nav-pills pull-right">
					    <!--<li role="presentation" ><a href="login.php">Login</a></li>-->
					    <li role="presentation" ><a href="">Ajuda</a></li>
					    
					    
					  </ul>
					</nav>
					<br>
					<!--<h3 class="text-muted">Controle de Acesso</h3>-->
		
	          </div>
	           
	
					      
			  <form class="form-signin" method="post" action="/Inventario/ConfiguraAmbiente" data-toggle="validator" role="form" > 
					<h2 class="form-signin-heading">Configurações de Ambiente</h2><br><br>
					
						<h4>Informe o banco de dados :</h4>
						<select name ="db" id="db" class="form-control">
							<option  value="mysql">MySQL</option>
							<option  value="postgresql">PostgreSQL</option>
						</select>
						<!--<input name="db" type="text" id="db" class ="form-control" placeholder="Informe o Banco de dados. Ex: mysql" >-->
						<div class="form-group">                					
							<h4>Informe um login de acesso ao banco de dados que tenha privilégios de administrador. </h4>
							<input name="nomeUsuario" type="text" id="inputLogin" class="form-control" placeholder="Login de acesso ao banco de dados .Ex: root" required autofocus data-error="É necessário informar o login do banco de dados.">
							<div class="help-block with-errors"></div>
						</div>	
						<div class="form-group">
							<h4>Informe a senha :</h4>
							<input name="acesso" type="password" id="inputPassword" class="form-control" placeholder="Senha de acesso ao banco de dados" required data-error="É necessário informar a senha do banco de dados.">
							<div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">	
							<h4>Confirme a senha :</h4>
							<input name="acesso" type="password" id="inputConfirm" class="form-control" placeholder="Confirme a Senha de acesso ao banco" required  data-error="É necessário confirmar a senha do banco de dados." data-match="#inputPassword" data-match-error="Atenção! As senhas não estão iguais." >
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<h4>Informe um endereço de email para receber notificações ou recuperar senhas :</h4>
							<input name="email" type="text" id="email" class ="form-control" placeholder="ex : nome@empresa.com" type="email"  data-error="O formato de email está inválido" required>
							<div class="help-block with-errors"></div>
			    		</div>
			    		<div class="form-group">
				    		<h4>Informe o caminho onde se encontra a pasta da aplicação :</h4>
							<input name="caminhoAplicacao" type="text" id="caminhoAplicacao" class="form-control" placeholder="ex: /home/administrador/ProjetoInventario/Inventario" required autofocus >
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<h4>Informe o endereço IP da máquina onde se encontra o banco de dados :</h4>
							<input name="enderecoBanco" type="text" id="enderecoBanco" class ="form-control" placeholder="ex : 127.0.0.1" data-error="É necessário informar o endereço IP do banco de dados." required>
							<div class="help-block with-errors"></div>
			    		</div>
						<label>
						<br>
				
							<button class="btn btn-lg btn-primary btn-lg" type="submit">Criar Estruturas</button>
						</label>
			     </form>
			     <c:if test="${sessionScope.mensagem=='1' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " Não foi possível acessar o banco"</p>
			  			
			  		</div>
			  	</div>
			    </c:if>
			    
			    <c:if test="${sessionScope.mensagem=='2' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " Houve falha ao tentar criar as estruturas"</p>
			  			
			  		</div>
			  	</div>
			    </c:if> 
			    
			     <c:if test="${sessionScope.mensagem=='3' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " Houve um erro de processamento no Servidor"<br>Um caminho de arquivo não foi encontrado. </p>
			  			
			  		</div>
			  	</div>
			    </c:if>   
			    
			     <c:if test="${sessionScope.mensagem=='4' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Erro ao executar arquivo de script de criação de tabelas!</strong> </p>
			  			
			  		</div>
			  	</div>
			    </c:if>   
			    
			      <c:if test="${sessionScope.mensagem=='5' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Procedimento realizado com sucesso!<br>Será necessário reiniciar o sistema antes do primeiro acesso.<br>
			  			Use usuário "admin" e senha "default" para o primeiro acesso.<br></strong> </p>
			  			
			  		</div>
			  	</div>
			    </c:if>   
			      
		     
		      
			</div> <!-- /jumbotron -->    			 
                   
        </div> <!-- /container -->
   
		

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="/Inventario/suporte/js/bootstrap.min.js"></script>
		<script src="/Inventario/suporte/js/validator.js"></script>
        
   </BODY>
</HTML>