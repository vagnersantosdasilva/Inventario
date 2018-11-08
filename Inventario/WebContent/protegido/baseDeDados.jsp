<%@page import="Entidades.BD"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>Inventário</TITLE>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <!-- Bootstrap -->
        <!-- <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
	    <script src="/Inventario/suporte/js/bootstrap.js"></script>
	    
	    <!-- DataTables CSS -->
    	<link href="/Inventario/suporte/css/dataTables.bootstrap.css" rel="stylesheet">
    	<link href="/Inventario/suporte/css/dataTables.responsive.css" rel="stylesheet">
    	<link href="/Inventario/suporte/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    	<link href="/Inventario/suporte/css/sb-admin-2.css" rel="stylesheet">
        <link href="/Inventario/suporte/css/bootstrap2.css" rel="stylesheet">
        <!-- Custom CSS -->
       <!--   <link href="/Inventario/suporte/css/agency.css" rel="stylesheet">-->
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
		 <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

		 -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>    

	    <![endif]-->	
	</HEAD>
    
	<BODY>
<!-- Inicio NAV --> 

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
                
                <a class="navbar-brand" href="/Inventario/protegido/index.html">SAI v0.7</a>
            </div>
            <!-- /.navbar-header -->

           
           		<ul class="nav navbar-nav navbar-right">
           		
	           	<li><a href="/Inventario/protegido/index.html"><i class="fa fa-home fa-fw"></i> Início</a> </li>	
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-search fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-search ">
                        <li>
							<form method="get" action="buscar" >
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
		  							<input name="procurar" class="form-control id="procurar" type="text" placeholder="Pesquisar hostname..." />
		  						</div>
		  						
		  							
		  					</form>
						</li>
                       
                        
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Listar Tudo</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Personalizar Conta</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configurações</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
          </div>  <!-- /.navbar-top-links -->
		</nav>
		

		
     	
<!-- ########################################################################## Fim NAV############################################################## -->
<br><br>
		<div class="container">
     
		
			 		<!-- Tab panes -->
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
										<a data-toggle="collapse" data-parent="#accordion2" href="#inventario"> Inventário de Máquina </a>
									</h4>
								</div>
								<div id="inventario" class="panel-collapse collapse in">
									<div class="panel-body">
										<table class="table">
											<tr>
												<th>SGBD	:</th> <td><c:out value="${bd.nomeSGBD}" default=" "/></td>
											</tr>
											<tr>    
												<th>Nome  :</th> <td><c:out value="${bd.nomeBanco}" default=" "/></td>
											</tr>
											<tr>	
												<th>Ip	:</th> <td><c:out value="${bd.ipBanco}" default=" "/></td>
											</tr>
											<tr>	
												<th>Porta	:</th> <td><c:out value="${bd.portaBanco}" default=" "/></td>
											</tr>
											<tr>	
												<th>Frequência de Backup	:</th> <td><c:out value="${bd.frequenciaBackup}" default=" "/></td>
											</tr>
											<tr>	
												<th>Modo de Backup	:</th> <td><c:out value="${bd.modoBackup}" default=" "/></td>
											</tr>
											<tr>	
												<th>Formato de Saída	:</th> <td><c:out value="${bd.formatoBackup}" default=" "/></td>
											</tr>
											<tr>	
												<th>Último Backup	:</th> <td><c:out value="${bd.dataBackup}" default=" "/></td>
											</tr>
																				
									</table>
														 
								</div>
								</div>
							</div>
						</div>
					</div>	
				</div>	

   
		<footer>
			
			<p align="center">&copy; Company 2017</p>
		</footer>
		
<!-- ################################################################################################################################################ -->		
		<!-- Modal Inventario-->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		    <!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Configuração de Backup</h4>
					</div>
					<form  id="infobanco_form" Action="salvarInfoBanco" Method="post" data-toggle="validator" role="form">	
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="nomeSGBD" class="form-control" id="mnomeSGBD" value="<c:out value="${bd.nomeSGBD}" default=" "/>">
							<input type="hidden" name="dataBackup" class="form-control" id="mdataBackup" value="<c:out value="${bd.dataBackup}" default=" "/>">
							<input type="hidden" name="nomeBanco" class="form-control" id="mnomeBanco" value="<c:out value="${bd.nomeBanco}" default=" "/>">
						</div>
						<!-- 
						<div class="form-group">
							<label for="hostname">Hostname:</label>
							<input type="text" name="hostname" class="form-control" id="mhostname" value="<c:out value="${maquina.inventario.hostname}" default=" "/>" required data-error="Preencimento desse campo é necessário">
							<div class="help-block with-errors"></div>
						</div> 
						-->
						
						
						<div class="form-group">
							<label for="ip">Ip do Banco:</label>
							
							<input type="text" name="ip" class="form-control" id="mip" value="<c:out value="${bd.ipBanco}" default=""/>" pattern="\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\.|$)){4}\b" maxlength="15" data-error="Ip inválido. Ex:127.0.0.1">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							  <label for="email">Porta Utilizada:</label>
							  <input type="porta" name="porta" class="form-control" id="mporta" value="<c:out value="${bd.portaBanco}" default=""/>" pattern="^[0-9]{1,}$" maxlength="15" data-error="Digite apenas números. Ex: 3306">
							  <div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<label for="grupo">Frequência de Backup:</label>
							<select class="form-control" id="mfrequencia" name="frequencia">
							    <option id="1" value="Diariamente">Diariamente</option>
							    <option id="2" value="Semanalmente">Semanalmente</option>
							    <option id="3" value="Mensalmente">Mensalmente</option>
							    <option id="4" value="Semestralmente">Semestralmente</option>
							 </select>
						</div>
						<div class="form-group">
							<label for="grupo">Modo de Backup:</label>
							<select class="form-control" id="mmodo" name="modo">
							    <option id="1" value="auto">Automático</option>
							    <option id="2" value="manual">Manual</option>
							   
							 </select>
						</div>
						
						<div class="form-group">
							<label for="grupo">Tipo de Arquivo de Backup:</label>
							<select class="form-control" id="mformato" name="formato">
							    <option id="1" value="txt">TXT</option>
							    <option id="2" value="csv">CSV</option>
							    <option id="3" value ="json">JSON</option>
							    <option id="4" value="sql">SQL</option>
							 </select>
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

<!-- ################################################################################################################################################ -->
<!-- Transferencia de licença-->
		<div id="modalTransferirLicencas" class="modal fade" role="dialog">
			<div class="modal-dialog">
		    <!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Transferência de Licenças</h4>
					</div>
					<form  id="transferencia_form" Action="TransferirLicenca" Method="post" data-toggle="validator" role="form">	
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="codigoMaquina" class="form-control" id="codigoMaquina" value="<c:out value="${maquina.codigoMaquina}" default=" "/>">
							<input type="hidden" name="hostname" class="form-control" id="codigoMaquina" value="<c:out value="${maquina.hostname}" default=" "/>">
							<input type="hidden" name="funcao" class="form-control" id="nfuncao" >
						</div>
						<div class="form-group">
					    	<label for="mproduto" class="control-label">Nome do Software :</label>
					   		<input name="produto" id="nproduto" readonly="true" class="form-control" placeholder="*Informe o nome completo do software..."  type="text" required data-error="Preencimento obrigatório">
					   		<div class="help-block with-errors"></div>
				  		</div>
						<div class="form-group">
							<label for="mchave" class="control-label">Chave :</label>
							<input type="text" name="chave" readonly="true" class="form-control" id="nchave" maxlength="35" placeholder="Informa a chave ou serial do software..." required data-error="Preencimento obrigatório">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group" >
							<label for="data">Data: </label>
							<input type="text" name="data" readonly="true" class="form-control" id="ndata" placeholder="Informe a data de expiração da licença de uso...">
						</div>
						
						<div class="form-group">
							<label for="data">*Máquina Destinada:</label>
							<input type="text" name="maquinadestino" class="form-control" id="nmaquina" placeholder="Informe o Hostname da máquina de destino" required data-error="Preencimento obrigatório">
						</div>
						
					</div>
		      		<div class="modal-footer">
				      	<button type="submit" class="btn btn-primary" id="submitFormTransferencia" data-dismiss="modal">Transferir</button>
		        		<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		      		</div>
		     		</form>
		    	</div>
		  	</div>
		</div>
<!-- ################################################################################################################################################ -->
	
	
	<script src="/Inventario/suporte/js/jquery.js"></script>
	<script src="/Inventario/suporte/js/bootstrap.min.js"></script>
    <script src="/Inventario/suporte/js/jquery.dataTables.min.js"></script>
    <script src="/Inventario/suporte/js/dataTables.bootstrap.js"></script>
    <script src="/Inventario/suporte/js/dataTables.responsive.js"></script>
	<script src="/Inventario/suporte/js/dataTables.responsive.js"></script>
	<script src="/Inventario/suporte/js/dataTables.buttons.min.js"></script>
	<script src="/Inventario/suporte/js/tabelas.js"></script>
	
    <!-- Atualizar variaveis de modal -->
   	<script>
		$(document).on("hidden.bs.modal", "#myModalLicenca", function () {
			
			$('#licencas_form')[0].reset();
		});
		
		$(".novalicenca").on('click', function(){
			
			var produto="";
			var chave="";
			var dataexp="";
			var funcao="incluir";
		    $("#mfuncao").val(funcao);
			$("#mproduto").val(produto);
			$("#mchave").val(chave);
			$("#mdata").val(dataexp);
			$("#myModalLicenca").modal();
		});
	</script>
    
   
    <script>
	$(".alterarlicenca").on('click', function(){
		
		 
		var id = $(this).data('id');
		var linha = $('#linha' + id).children(); 
		var funcao="editar";
		$("#mfuncao").val(funcao);
		$("#mproduto").val($(linha[0]).text());
		$("#mchave").val($(linha[1]).text());
		$("#mdata").val($(linha[2]).text());
	    $("#myModalLicenca").modal();
	    

	});
    
    </script>
    <script>
		$(".transferirlicenca").on('click', function(){
			
			 
			var id = $(this).data('id');
			var linha = $('#linha' + id).children(); 
			
			$("#nproduto").val($(linha[0]).text());
			$("#nchave").val($(linha[1]).text());
			$("#ndata").val($(linha[2]).text());
		    $("#modalTransferirLicencas").modal();
		    
	
		});
    
    </script>
    
    
    
    
    <script>
		/* must apply only after HTML has loaded */
		$(document).ready(function () {
		    $("#submitForm").on("click", function() {
		        $("#infobanco_form").submit();
		    });
		     
		    $("#submitFormLicenca").on('click', function() {
		    	
		        $("#licencas_form").submit();
		    });
		    
 			$("#submitFormTransferencia").on('click', function() {
		    	
		        $("#transferencia_form").submit();
		    });
		});
	</script>
	
	<!-- Excluir linha de tabela -->
	<script>
	(function($) {
		  remove = function(item) {
		    var tr = $(item).closest('tr');
			tr.fadeOut(400, function() {
		      tr.remove();  
		    });

		    return false;
		  }
		})(jQuery);
	</script>
	<script>
	<!-- Adicionar linha na tabela  -->
	(function($) {
		  AddTableRow = function() {
		
		    var newRow = $("<tr>");
		    var cols = "";
		
		    cols += '<td>&nbsp;</td>';
		    cols += '<td>&nbsp;</td>';
		    cols += '<td>&nbsp;</td>';
		    cols += '<td>&nbsp;</td>';
		    cols += '<td>';
		    cols += '<button onclick="RemoveTableRow(this)" type="button">Remover</button>';
		    cols += '</td>';
		
		    newRow.append(cols);
		    $("#products-table").append(newRow);
		
		    return false;
		  };
		})(jQuery);
	</script>
	<script src="/Inventario/suporte/js/validator.js"></script>  
	</BODY>
</HTML>





<!--
	<div class="container">
     
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="sessao0">
					<div class="row">
						<div class="submenu">
							<ul class="nav nav-pills navbar-left">
							
								<li  role="presentation" class="active"><a href="#myModal" class="alterar" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-edit"></a></li>
								<li  role="presentation" class="active"><a href="#" class="download"><span class="glyphicon glyphicon-download"></a></li>
								<!--  <li  class="active"><a href="#myModal" class="btn btn-xs btn-success alterar" data-toggle="modal" data-target="#myModal">Limpar</a></li>-->
		<!--  					
					    	</ul>
				    	</div>	
				    	
						<br><br>
						<div class="panel-group" id="accordion0">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse"  href="#inventario"> Informações sobre Banco de Dados </a>
									</h4>
								</div>
								<div id="inventario" class="panel-collapse collapse in">
									<div class="panel-body">
										<table class="table">
											<tr tr id="linha1">
												<th>SGBD	:</th> <td>MySQL</td>
											</tr>
											<tr tr id="linha2">    
												<th>Nome da Base :</th> <td>inventario</td>
											</tr>
											<tr>	
												<th>IP do Servidor	:</th> <td>10.0.0.100</td>
											</tr>
											<tr>	
												<th>Porta Utilizada	:</th> <td>3306</td>
											</tr>
											<tr>	
												<th>Frequência de Backup	:</th> <td>Semanalmente</td>
											</tr>
											<tr>	
												<th>Formato de Backup	:</th> <td>Arquivo CSV</td>
											</tr>
											<tr>	
												<th>Último Backup	:</th> <td>25/09/2019</td>
											</tr>
											<tr>	
												<th>Modo de Backup	:</th> <td>Automático</td>
											</tr>
																
									</table>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>  -->