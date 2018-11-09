<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Recuperação de Senha</title>
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
	    <style>
		.jumbotron{
			width:70%;
			margin:auto;
			padding:100px;
			
			}
		</style>	
		
	</head>
	<body>
		<div class="container">
			
			<div class="jumbotron">
				<h2 class="form-signin-heading">Recuperação de Senha</h2><br><br>
					<form class="form-signin" method="post" action="/Inventario/ResetDeSenha" data-toggle="validator" role="form" > 
								<div class="form-group">                					
									<h4>Informe o seu login :</h4>
									<input name="nomeUsuario" type="text" id="inputLogin" class="form-control" placeholder="Login de acesso ao sistema SAI" required autofocus data-error="Informe seu login">
									<div class="help-block with-errors"></div>
								</div>
								<div class="form-group">
									<h4>Informe seu Endereço de email registrado :</h4>
									<input name="email" type="text" id="email" class ="form-control" placeholder="ex : nome@empresa.com" type="email"  data-error="O formato de email está inválido" required>
									<div class="help-block with-errors"></div>
			    				</div>
									
								<label>
								<br>
						
									<button class="btn btn-lg btn-primary btn-lg" type="submit">Enviar</button>
								</label>
					 </form>
					 <c:if test="${sessionScope.mensagem=='1' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " Não foi possível enviar a nova senha para seu email."</p>
			  			
			  		</div>
			  	</div>
			    </c:if>
			    <c:if test="${sessionScope.mensagem=='2' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " O email informado não está registrado"</p>
			  			
			  		</div>
			  	</div>
			    </c:if> 
			    
			     <c:if test="${sessionScope.mensagem=='3' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " O usuário informado é inexistente."</p>
			  			
			  		</div>
			  	</div>
			  	</c:if> 
			  	<c:if test="${sessionScope.mensagem=='4' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Um erro ocorreu!</strong> " Não foi possível atualizar a senha nesse momento."<br>
			  			Se o problema persistir, entre em contato com o administrador do sistema.</p>
			  			
			  		</div>
			  	</div>
			    </c:if>   
			    <c:if test="${sessionScope.mensagem=='5' }">
			        <div class="ui-widget">
			  			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			  			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			  			<strong>Tudo certo!<br>Acesse seu email registrado para conhecer sua nova senha.<br></strong> </p>
			  		</div>
			  	</div>
			    </c:if>   
			    <br><br>
			</div> <!-- /jumbotron -->    			 
        </div> <!-- /container -->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="/Inventario/suporte/js/bootstrap.min.js"></script>
		<script src="/Inventario/suporte/js/validator.js"></script>
	</body>
</html>