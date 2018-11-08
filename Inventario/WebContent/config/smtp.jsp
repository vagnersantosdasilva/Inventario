<%@page import="Controle.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
    <HEAD>
        
        <TITLE>Configuração de SMTP</TITLE>
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
	          <form class="form-signin" method="post" action="/Inventario/ConfiguraSMTP" data-toggle="validator" role="form" > 
					<h2 class="form-signin-heading">Configurações de Envio de Email</h2><br><br>
					
						
						<!--<input name="db" type="text" id="db" class ="form-control" placeholder="Informe o Banco de dados. Ex: mysql" >-->
						<div class="form-group">                					
							<h4>Informe o Servidor SMTP </h4>
							<input name="servidorSMTP" type="text" id="inputLogin" class="form-control" placeholder="Ex: smtp.mail.yahoo.com.br" required autofocus data-error="É necessário informar o enderenço do servidor SMTP.">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">                					
							<h4>Informe a Porta SMTP </h4>
							<input name="portaSMTP" type="text" id="inputLogin" class="form-control" placeholder="O padrao costuma ser 465" required autofocus data-error="É necessário informar a porta SMTP.">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<h4>Informe o Email de Origem :</h4>
							<input name="emailOrigem" type="text" id="email" class ="form-control" placeholder="ex : nome@empresa.com" type="email"  data-error="O formato de email está inválido" required>
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
						
						<h4>SSL :</h4>
						<select name ="ssl" id="ssl" class="form-control">
							<option  value="true">Sim</option>
							<option  value="false">Não</option>
						</select>
						
			    		<label>
						<br>
				
							<button class="btn btn-lg btn-primary btn-lg" type="submit">Gravar</button>
						</label>
			     </form>
			     <c:if test="${sessionScope.mensagem=='1' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Tudo certo!</strong> " Dados foram gravados com sucesso"<br>
			  			Uma mensagem do sistema foi enviada para seu email. </p>
			  			
			  		</div>
			  	</div>
			    </c:if>
			    
			    <c:if test="${sessionScope.mensagem=='2' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " Não foi possível salvar as informações"</p>
			  			
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