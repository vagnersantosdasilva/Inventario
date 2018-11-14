<%@page import="DAO.Usuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <script src="/Inventario/suporte/js/bootstrap.js"></script>
        <link href="/Inventario/suporte/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="/Inventario/suporte/css/bootstrap2.css" rel="stylesheet">
	    <link href="/Inventario/suporte/css/dataTables.bootstrap.css" rel="stylesheet">
      	<link href="/Inventario/suporte/css/dataTables.responsive.css" rel="stylesheet">
    	<title>Perfil do Usuário</title>
	</head>
	<body>
		<div class="navegacao"> 
	        <!-- Navigation -->
	        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		       	 <div class="container">
						
		            <div class="navbar-header">
		                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		                    <span class="sr-only">Toggle navigation</span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                </button>
		                <a class="navbar-brand" href="index.html">SAI v0.7</a>
		            </div>
		            <!-- /.navbar-header -->
	           		<ul class="nav navbar-nav navbar-right">
		           		<li><a href="/Inventario/protegido/index.html"><i class="fa fa-home fa-fw"></i> Início</a> </li>	
		                <li class="dropdown">
		                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
		                    </a>
		                    <ul class="dropdown-menu dropdown-user">
		                        <li><a href="/Inventario/listarPerfil"><i class="fa fa-gear fa-fw"></i> Configurações</a>
		                        </li>
		                        <li class="divider"></li>
		                        <li><a href="/Inventario/login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
		                        </li>
		                    </ul>
		                    <!-- /.dropdown-user -->
		               </li>
		                <!-- /.dropdown -->
		            </ul>
		        </div>  <!-- /.navbar-top-links -->
			</nav>
		</div>
	    <!-- ########################################################################## Fim NAV############################################################## -->
		<br><br>
		<div class="container">
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="sessao0">
					<div class="row">
						<div class="submenu">
							<ul class="nav nav-pills navbar-left">
							
								<li  role="presentation" class="active">
									<a href="#myModal" class="alterar" data-toggle="modal" data-target="#myModal">
										<span class="glyphicon glyphicon-edit">
									</a>
								</li>
								<li  role="presentation" class="active">
									<a href="#" class="download">
										<span class="glyphicon glyphicon-download">
									</a>
								</li>
								
							
					    	</ul>
				    	</div>	
				    	
						<br><br>
						<div class="panel-group" id="accordion0">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion2" href="#inventario"> Informações de Perfil </a>
									</h4>
								</div>
								<div id="inventario" class="panel-collapse collapse in">
									<div class="panel-body">
										<table class="table">
											<tr>
												<th>Login	:</th> <td ><c:out value="${usuario.nomeUsuario}" default=" " /></td>
											</tr>
											<tr>    
												<th>Nível de Acesso  :</th> <td><c:out value="${usuario.grupoAcesso}" default=" "/></td>
											</tr>
											<tr>	
												<th>Email	:</th> <td><c:out value="${usuario.email}" default=" "/></td>
											</tr>
											<tr>	
												<th>Telefone	:</th> <td><c:out value="${usuario.telefone}" default=" "/></td>
											</tr>
											<tr>
												<th>Senha	:</th> <td >******</td>	
												<!--  <th>Senha	:</th> <td ><c:out value="${usuario.chaveAcesso}" default=" "/></td>-->
											</tr>
									</table>
														 
								</div>
								</div>
							</div>
						</div>
					</div>	
				</div>	
			</div>
   		</div>
		<footer>
			
			<p align="center">&copy; Company 2017</p>
		</footer>
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		    <!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Configuração de Perfil</h4>
					</div>
					<form  id="config_usuario_form" Action="" Method="post" data-toggle="validator" role="form">	
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="nome" class="form-control" id="mnomeSGBD" value="<c:out value="${usuario.nomeUsuario}" default=" " />">
							<input type="hidden" name="grupo" class="form-control" id="mdataBackup" value="<c:out value="${usuario.grupoAcesso}" default=" "/>">
						</div>
				 
				
						<div class="form-group">
						    <label for="memail" class="control-label">Email *</label>
						    <input name="email" id="memail" class="form-control" placeholder="*Digite o E-mail do usuário..." type="email"  
						    	data-error="O formato de email está inválido" required value="<c:out value="${usuario.email}" default=" "/>">
						    <div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label for="mtelefone">Telefone:</label>
							<input type="text" name="telefone" class="form-control" id="mtelefone" placeholder="Telefone ou ramal do usuário para contato..." 
							pattern="^[0-9]{1,}$" maxlength="15" data-error="Digite apenas números. Ex:1133334444"  value="<c:out value="${usuario.telefone}" default=" "/>">
							<div class="help-block with-errors" ></div>
						</div>
						<div class="form-group">
							<h4>Informe a nova senha :</h4>
							<input name="acesso" disabled type="password" id="inputPassword" class="form-control" placeholder="Senha de no mínimo 6 caracteres."  
							data-error="É necessário informar a senha." data-minlength="6">
							<div class="help-block with-errors"></div>
							<div class="help-block">Mínimo de  caracteres</div>
						</div>
						
						<div class="form-group">	
							<h4>Confirme a nova senha :</h4>
							<input name="acesso" disabled type="password"  id="inputConfirm" class="form-control" placeholder="Confirme a Senha"   
							data-error="É necessário confirmar ." data-match="#inputPassword" data-match-error="Atenção! As senhas não estão iguais." 
							data-minlength="6">
							<div class="help-block with-errors"></div>
							<div class="help-block">Mínimo de  caracteres</div>
						</div>
						<div class="form-group">
							<label class="checkbox-inline" for="mreset" >
							<input type="checkbox" name="reset"  class="checkbox-inline" id ="check-reset"  value="reset" onchange="javascript:habilitarSenha()"> Renovar Senha:</label>
						</div>
						
					</div>
		      		<div class="modal-footer">
				      	<button type="submit" class="btn btn-primary" id="submitForm" data-dismiss="modal">Salvar</button>
		        		<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		      		</div>
		     		</form>
		    	</div>
		  	</div>
		</div>
		
<!-- ################################################################################################################################################ -->
                                       	
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<!-- ><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="/Inventario/suporte/js/jquery.js"></script>
		<script src="/Inventario/suporte/js/bootstrap.min.js"></script>
		<script src="/Inventario/suporte/js/validator.js"></script>
		<script>
		 function habilitarSenha(){
		        if(document.getElementById('check-reset').checked){
		            document.getElementById('inputPassword').removeAttribute("disabled");
		            document.getElementById('inputConfirm').removeAttribute("disabled");
		            document.getElementById('inputPassword').setAttribute("required", "enabled");
		            document.getElementById('inputConfirm').setAttribute("required", "enabled");
		        }
		        else {
		            document.getElementById('check-reset').value=''; //Evita que o usuário defina um texto e desabilite o campo após realiza-lo
		            document.getElementById('inputPassword').setAttribute("disabled", "disabled");
		            document.getElementById('inputConfirm').setAttribute("disabled", "disabled");
		            document.getElementById('inputPassword').removeAttribute("required");
		            document.getElementById('inputConfirm').removeAttribute("required");
		        }
		    }
		</script>
		
		
	</body>
</html>