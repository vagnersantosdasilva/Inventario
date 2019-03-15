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
        <!-- <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->
	    <link href="/Inventario/suporte/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="/Inventario/suporte/css/bootstrap2.css" rel="stylesheet">
	    <link href="/Inventario/suporte/css/dataTables.bootstrap.css" rel="stylesheet">
      	<link href="/Inventario/suporte/css/dataTables.responsive.css" rel="stylesheet">
    	<title>Gerenciamento de Usuários</title>
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
                        <li><a href="/Inventario/keepout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
          </div>  <!-- /.navbar-top-links -->
		</nav>
	</div>	
	
	
	<div class="container">
	<br><br>
	<!-- *******************************************************************SUBMENU******************************************************* -->
	 	<div class="submenu">
			<ul class="nav nav-pills navbar-left">
				<li role="presentation" class="active">
					<a href="#" class="novo" data-toggle="modal" data-id="0">
						<span class="fas fa  fa-user-plus"></span>
					</a>
				</li>
				<li role="presentation" class="active">
					<a href="#">
						<span class="glyphicon glyphicon-download">
					</a>
				</li>
			</ul>
		</div>
	<!-- *******************************************************************FIM - SUBMENU ************************************************* -->	
		<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <b>Listagem de Usuários</b>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!--  <table width="99%" class="table table-striped table-bordered table-hover" id="dataTables">-->
                            <table  class="table table-bordered table-hover" >  
                                <thead>
                                    <tr>
                                        <th>Nome de Usuário</th>
                                        <th>Grupo de Acesso</th>
                                        <th>Email</th>
                                        <th>Telefone</th>
                                        <th></th>
                                        <th></th>
                                        
                                    </tr>
                                </thead>
                                
                                <tbody>
                                <c:forEach items="${usuarios.listaDeUsuarios}" var="usuario" varStatus="status">
                                    <tr id="linha${status.count}">
                                        <td ><c:out value="${usuario.nomeUsuario}" default=" " /></td>
                                        <td ><c:out value="${usuario.grupoAcesso}" default=" "/></td>
                                        <td ><c:out value="${usuario.email}" default=" "/></td>
                                        <td ><c:out value="${usuario.telefone}" default=" "/></td>
                                        <td align="center"><a href="#" class="btn btn-xs btn-info alterar" data-toggle="modal" data-id="${status.count}">Alterar</a></td>
            							<!--<td align="center"><a href="remover?id_material=${status.count}"class="btn btn-xs btn-danger" > Remover </a></td>-->
            							<td align="center"> <button type="button" onclick="remove(this,${status.count})" value="${status.count}" class="btn btn-xs btn-danger">Remover</button> </td>
            							<!--  <td align="center"> <a href="#remover"  id="remover" value="${status.count}" class="btn btn-xs btn-danger">Remover</button> </td>-->
            							
        
                                    </tr>
                                    
                                  </c:forEach>  
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
	
						</div>
					</div>
	
				</div>
		</div>
	</div>
	
	<footer>
			<center><p>&copy; Company 2017</p></center>
			<br><br>
	</footer>

<!-- Modal Licenca-->
	
	<div id="myModalUsuarios" class="modal fade" role="dialog">
			<div class="modal-dialog">
		    <!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" id="btn-fechar-x">&times;</button>
						<h4 class="modal-title">Configuração de Usuários</h4>
					</div>
					<form  id="cliente_form"  Action="Cadastro.php" Method="post" data-toggle="validator" role="form">	
					<div class="modal-body">
						<input type="hidden" name="contexto" class="form-control " id="mcontexto"  >
						<div class="form-group">
							<label for="grupo">Grupo de Acesso:</label>
							<select class="form-control" id="mgroup" name="grupo">
							    <option id="1">admin</option>
							    <option id="2">default</option>
							 </select>
						</div>
						
						<div class="form-group">
					    	<label for="mnome" class="control-label">Nome de Usuário *</label>
					   		<input name="nome" id="mnome" class="form-control" placeholder="*Escolha um nome de usuário..." data-minlength="5" type="text" required>
					   		<div class="help-block">Mínimo de 5 caracteres</div>
				  		</div>
				  
						<div class="form-group">
						    <label for="memail" class="control-label">Email *</label>
						    <input name="email" id="memail" class="form-control" placeholder="*Digite o E-mail do usuário..." type="email"  data-error="O formato de email está inválido" required>
						    <div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label for="mtelefone">Telefone:</label>
							<input type="text" name="telefone" class="form-control" id="mtelefone" placeholder="Telefone ou ramal do usuário para contato..." pattern="^[0-9]{1,}$" maxlength="15" data-error="Digite apenas números. Ex:1133334444">
							<div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label class="checkbox-inline" for="mreset" >
							<input type="checkbox" name="reset"  class="checkbox-inline" id ="check-reset"  value="sim"> Reset de senha:</label>
						</div>
					
					</div>
		      		<div class="modal-footer">
				      	<!--  <button type="button" class="btn btn-primary" id="submitForm" >Salvar <span class="glyphicon glyphicon-thumbs-up"></span>
				      	</button>-->
				      	<button type="button" class="btn btn-primary salvar" id="btn-salvar">Salvar</button>
		        		<button type="button" class="btn btn-default fechar" id="btn-fechar" data-dismiss="modal">Fechar</button>
		      		</div>
		     		</form>
		    	</div>
		  	</div>
		</div>
<!-- ################################################################################################################################################ -->
		 <div id="confirm" class="modal fade" role="dialog">
			 <div class="modal-dialog">
				 	<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" id="btn-fechar-x">&times;</button>
							<h4 class="modal-title">Configuração de Usuários</h4>
						</div>
						  <div class="modal-body">
						    Está seguro disso?
						  </div>
						  <input type="hidden" name="nome" class="form-control " id="rnome"  >
						  <div class="modal-footer">
						    <button type="button" data-dismiss="modal" class="btn btn-primary delete"  id="delete" >Delete</button>
						    <button type="button" data-dismiss="modal" class="btn">Cancel</button>
						  </div>
				 	</div>
			 </div>
		</div>
		 
<!-- ################################################################################################################################################ -->
		 <div id="carregando" class="modal fade" role="dialog" data-backdrop="static" >
			 <div class="modal-dialog modal-sm">
				 	<div class="modal-content">
						  <div class="modal-header">
								
								<h4 class="modal-title">Aguarde...</h4>
						  </div>
						  <div class="modal-body">
   								<center> <img src="/Inventario/suporte/images/spinner2.gif"/></center>
						  </div>
					  <div class="modal-footer">
						   
					  </div>	 
						
				 	</div>
			 </div>
		</div>
		
		<div id="erro" class="modal fade" role="dialog">
			 <div class="modal-dialog">
				 	<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" id="btn-fechar-x">&times;</button>
							<h4 class="modal-title">Configuração de Usuários</h4>
						</div>
						  <div class="modal-body">
						    <p>Um erro ocorreu ao tentar excluir o registro!</p>
						  </div>
						  <input type="hidden" name="nome" class="form-control " id="rnome"  >
						  <div class="modal-footer">
						    
						    <button type="button" data-dismiss="modal" class="btn">Fechar</button>
						  </div>
				 	</div>
			 </div>
		</div>
		<div id="erro-alterar" class="modal fade" role="dialog">
			 <div class="modal-dialog">
				 	<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" id="btn-fechar-x">&times;</button>
							<h4 class="modal-title">Configuração de Usuários</h4>
						</div>
						  <div class="modal-body">
						  <div class="alert alert-danger">
							   <strong>UM ERRO OCORREU!</strong> <p id="erro-texto"> Ao tentar salvar dados do usuário!</p>
						  </div>
						   
						  </div>
						  <input type="hidden" name="nome" class="form-control " id="rnome"  >
						  <div class="modal-footer">
						    
						    <button type="button" data-dismiss="modal" class="btn">Fechar</button>
						  </div>
				 	</div>
			 </div>
		</div>
		<div id="mensagem" class="modal fade" role="dialog">
			 <div class="modal-dialog">
				 	<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" id="btn-fechar-x">&times;</button>
							<h4 class="modal-title">Configuração de Usuários</h4>
						</div>
						  <div class="modal-body">
						   	<div class="alert alert-success">
  								<strong>Tudo Certo!</strong> <p id="mensagem-texto">Informações foram salvas com sucesso!</p>
							</div>
						  </div>
						  <input type="hidden" name="nome" class="form-control " id="rnome"  >
						  <div class="modal-footer">
						    
						    <button type="button" data-dismiss="modal" class="btn">Fechar</button>
						  </div>
				 	</div>
			 </div>
		</div>
		<div id="excluir-sucesso" class="modal fade" role="dialog">
			 <div class="modal-dialog">
				 	<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" id="btn-fechar-x">&times;</button>
							<h4 class="modal-title">Configuração de Usuários</h4>
						</div>
						  <div class="modal-body">
						    <div class="alert alert-success">
  								<strong>Tudo Certo!</strong> <p>Usuário excluído com sucesso!</p>
							</div>
						  </div>
						  <input type="hidden" name="nome" class="form-control " id="rnome"  >
						  <div class="modal-footer">
						    
						    <button type="button" data-dismiss="modal" class="btn">Fechar</button>
						  </div>
				 	</div>
			 </div>
		</div>
	    
	 
<!-- ################################################################################################################################################ -->
	    
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- ><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/Inventario/suporte/js/jquery.js"></script>
	<script src="/Inventario/suporte/js/bootstrap.min.js"></script>

	
	<!-- DataTables JavaScript -->
    <script src="/Inventario/suporte/js/jquery.dataTables.min.js"></script>
    <script src="/Inventario/suporte/js/dataTables.bootstrap.js"></script>
    <script src="/Inventario/suporte/js/dataTables.responsive.js"></script>
	<script src="/Inventario/suporte/js/dataTables.buttons.min.js"></script>
	<script src="/Inventario/suporte/js/tabelas.js"></script>
	<!-- Os proximos scripts devem ser transferidos para arquivos .js -->
	
	<!-- Passagem de parametros entre tabela e modal -->
	<script>
	$(".novo").on('click', function(){
		
		var nome="";
		var telefone="";
		var email="";
		var contexto="incluir";
		
	    $("#mcontexto").val(contexto);
		$("#mnome").val(nome);
		$("#memail").val(email);
		$("#mtelefone").val(telefone);
		document.getElementById("check-reset").disabled = true;
		$("#myModalUsuarios").modal()
	});
	
	$(".alterar").on('click', function(){
		var id = $(this).data('id');
		var linha = $('#linha' + id).children(); 
		
		var nome = $(linha[0]).text();
		$("#mnome").val(nome);
	    var grupo = $(linha[1]).text();
	    if (grupo=="default"){
	    	document.getElementById("2").selected=true;
	    }
	    if (grupo=="admin"){
			document.getElementById("1").selected=true;
		}
	    var contexto="editar";
	    $("#mcontexto").val(contexto);
	    var email = $(linha[2]).text();
	    $("#memail").val(email);
	    var telefone = $(linha[3]).text();
		$("#mtelefone").val(telefone);
		document.getElementById("check-reset").disabled = false;
		
		$("#myModalUsuarios").modal();
	});
	
	/*Envio do formulario para servlet*/
	/* must apply only after HTML has loaded */
	$(document).ready(function () {
	    $("#submitForm").on('click', function() {
	    		 $("#usuario_form").submit();	 
	    });
	});
		
	</script>
	<SCRIPT>
			$(".salvar").on('click', function(){
				$("#myModalUsuarios").modal('hide'); 
				$("#carregando").modal();
				$("#usuario_form").submit();
			});
				
	</SCRIPT>
	
	
	<script>
	(function($) {
		    remove = function(item,contador) {
		    	var tr = $(item).closest('tr');
				var contador=contador;
				//var id = $(this).data('id');
				var linha = $('#linha' + contador).children(); 
				var nome = $(linha[0]).text();
				$("#confirm").modal();
				$(".delete").on('click', function(){
					$('#carregando').modal();
		    		$.post('removerUsuario',{codigo_usuario:nome},function(responseText) {
						if (responseText=="SUCESSO")
						{
								tr.fadeOut(400, function() {
							      tr.remove();  
							    });
							
								$('#carregando').modal('hide');
								$('#excluir-sucesso').modal();
								//$("#confirm").modal('hide');
								//$("#confirm").close();
						}
						else
						{
							$('#carregando').modal('hide');
							$("#erro").modal();
						}
		            });
		    	});
		    return false;
		  }
		})(jQuery);
	</script>
	<script src="/Inventario/suporte/js/validator.js"></script>
	<c:if test="${sessionScope.resposta=='SUCESSO' }">
	    <c:remove var="resposta" scope="session" />
			<SCRIPT>
			$(document).ready(function() {
				$('#mensagem').modal('show');
			});
			</SCRIPT>
	</c:if>
	<c:if test="${sessionScope.resposta=='FALHA' }">
		<c:remove var="resposta" scope="session" />
			<SCRIPT>
			$(document).ready(function() {
				$('#erro-alterar').modal('show');
			});
			</SCRIPT>
	</c:if>
	<c:if test="${sessionScope.sql=='ERRO' }">
	    <c:remove var="sql" scope="session" />
			<SCRIPT>
			$(document).ready(function() {
				$('#erro-texto').css("color", "red");
				$('#erro-texto').text('Ao tentar se comunicar com o Banco de Dados');
				$('#erro-alterar').modal();
			});
			</SCRIPT>
	</c:if>
	<c:if test="${sessionScope.smtp=='ERRO' }">
	    <c:remove var="smtp" scope="session" />
			<SCRIPT>
			$(document).ready(function() {
				$('#erro-texto').css("color", "red");
				$('#erro-texto').text('Ao tentar enviar um email contendo a nova senha do usuário para o endereço cadastrado.\nVerifique se as configurações do servidor de SMTP estão corretas.');
				$('#erro-alterar').modal('show');
			});
			</SCRIPT>
	</c:if>
</body>
</html>