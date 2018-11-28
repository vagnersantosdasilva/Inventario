<%@page import="Entidades.Maquina.*"%>
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
                
                <a class="navbar-brand" href="/Inventario/protegido/index.html"><c:out value="${maquina.hostname}" default="SAI v0.7"/></a>
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
		

		
     	
<!-- ########################################################################## Fim NAV############################################################## -->
<br><br>
		<div class="container">
     
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#sessao0" aria-controls="sessao0" role="tab" data-toggle="tab">Inventário</a></li>
			    <li role="presentation"><a href="#sessao1" aria-controls="sessao1" role="tab" data-toggle="tab">Software</a></li>
				<li role="presentation"><a href="#sessao2" aria-controls="sessao2" role="tab" data-toggle="tab">Hardware</a></li>
				<li role="presentation"><a href="#sessao3" aria-controls="sessao3" role="tab" data-toggle="tab">Licenças</a></li>
			</ul>
	
			 		<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="sessao0">
					<div class="row">
						<div class="submenu">
							<ul class="nav nav-pills navbar-left">
							
								<li  role="presentation" class="active"><a href="#myModal" class="alterar" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-edit"></a></li>
								<li  role="presentation" class="active"><a href="#" class="download"><span class="glyphicon glyphicon-download"></a></li>
								<!--  <li  class="active"><a href="#myModal" class="btn btn-xs btn-success alterar" data-toggle="modal" data-target="#myModal">Limpar</a></li>-->
							
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
												<th>Hostname	:</th> <td><c:out value="${maquina.hostname}" default=" "/></td>
											</tr>
											<tr>    
												<th>Nome Usuário :</th> <td><c:out value="${maquina.inventario.responsavel}" default=" "/></td>
											</tr>
											<tr>	
												<th>Login	:</th> <td><c:out value="${maquina.inventario.loginResponsavel}" default=" "/></td>
											</tr>
											<tr>	
												<th>Departamento	:</th> <td><c:out value="${maquina.inventario.departamento}" default=" "/></td>
											</tr>
											<tr>	
												<th>Tel	:</th> <td><c:out value="${maquina.inventario.telefone}" default=" "/></td>
											</tr>
											<tr>	
												<th>Email	:</th> <td><c:out value="${maquina.inventario.emailResponsavel}" default=" "/></td>
											</tr>
											<tr>	
												<th>Patrimônio	:</th> <td><c:out value="${maquina.inventario.patrimonio}" default=" "/></td>
											</tr>
											<tr>	
												<th>Número de Série	:</th> <td><c:out value="${maquina.inventario.serial}" default=" "/></td>
											</tr>
											<tr>	
												<th>Fabricante	:</th> <td><c:out value="${maquina.inventario.fabricante}" default=" "/></td>
											</tr>
											<tr>	
												<th>Modelo	:</th> <td><c:out value="${maquina.inventario.modeloEquipamento}" default=" "/></td>
											</tr>										
									</table>
														 
								</div>
								</div>
							</div>
						</div>
					</div>	
				</div>	
<!-- ############################################################################################################################################### -->				
				<div role="tabpanel" class="tab-pane" id="sessao1">
					<div class="row">
						<br><br>
						<div class="panel-group" id="accordion1">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion1" href="#so">Sistema Operacional</a>
									</h4>
								</div>
								<div id="so" class="panel-collapse collapse in">
									<div class="panel-body">
										<table class="table">
											<tr>
												<th>Nome </th>
												<th>Versão </th>
												<th>Arquitetura </th>
												<th>Última Atualização</th>
												<th>Licença</th>
											</tr>
											<tr>
												<td><c:out value="${maquina.sistemaOperacional.nome}" /></td>
												<td><c:out value="${maquina.sistemaOperacional.arquitetura}" /></td>
												<td><c:out value="${maquina.sistemaOperacional.versao}" /></td>
												<td><c:out value="${maquina.sistemaOperacional.atualizacao}" /></td>
												<td ><span class="glyphicon glyphicon-edit"> </span></td>
											</tr>
																						
										</table>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion1" href="#programas">Programas Instalados</a>
									</h4>
								</div>
								<div id="programas" class="panel-collapse collapse">
									<div class="panel-body">
										<!--  <table class="table">-->
										<table width="99%" class="table table-striped table-bordered table-hover" id="dataTables0">
											<thead>				
												<tr>
													<th>Nome </th>
													<th>Arquitetura </th>
													<th>Data De Instalação</th>
													
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${maquina.listaDeSoftwares}" var="software">						
												<tr>
													<td><c:out value="${software.nome}" default=" " /> </td>
													<td><c:out value="${software.arquitetura}" default=" " /></td>
													<td><c:out value="${software.dataInstalacao}" default=" " /></td>
													
												</tr>
												</c:forEach>
											</tbody>						
										</table>
									</div>
								</div>
							</div>
								
						</div>
					</div> <!-- /row> -->
				</div>
<!-- ################################################################################################################################################ -->				
				<div role="tabpanel" class="tab-pane" id="sessao2">
						<div class="row">
							<br><br>
							<div class="panel-group" id="accordion2">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion2" href="#cpu">CPU</a>
										</h4>
									</div>
									<div id="cpu" class="panel-collapse collapse in">
										<div class="panel-body">
											<table class="table">
												<tr>
													<th>Nome </th>
													<th>Fabricante </th>
													<th>Frequência MHZ</th>
													<th>Núcleos</th>
													<th>Processadores Lógicos</th>
													
													<th>Status</th>
												</tr>
												<tr>
													<td><c:out value="${maquina.hardware.cpu.nome}" default="?"/></td>
													<td><c:out value="${maquina.hardware.cpu.fabricante}" default="?"/></td>
													<td><c:out value="${maquina.hardware.cpu.frequenciaMaxima}" default="?"/></td>
													<td><c:out value="${maquina.hardware.cpu.numeroNucleos}" default="?"/></td>
													<td><c:out value="${maquina.hardware.cpu.numeroProcessadoresLogicos}" default="?" /></td>
													
													<td><c:out value="${maquina.hardware.cpu.status}" default="?" /></td>
												</tr>
											</table>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion2" href="#ram">Memória RAM</a>
										</h4>
									</div>
								<div id="ram" class="panel-collapse collapse">
									<div class="panel-body">
										<table class="table">
											<tr>
												<th>Fabricante </th>
												<th>Tamanho em Gbytes</th>
												<th>Frequência </th>
												<th>Tipo</th>
												<th>Status</th>
											</tr>
											<c:forEach items="${maquina.hardware.listaDeMemorias}" var="memoria">
											<tr>
												<td><c:out value="${memoria.fabricante}" default="?"  /></td>
												<td><c:out value="${memoria.capacidade}" default="?"  /></td>
												<td><c:out value="${memoria.velocidade}" default="?"  /></td>
												<td><c:out value="${memoria.tipo}" default="?"  /></td>
												<td><c:out value="${memoria.status}" default="?"  /></td>
											</tr>	
											</c:forEach>
										</table>
									</div>
								</div>
							</div> 
										  				
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion2" href="#placamae">Placa Mãe</a>
									</h4>
								</div>
								<div id="placamae" class="panel-collapse collapse">
									<div class="panel-body">
										<table class="table">
											<tr> 
												<th>Fabricante</th>
												<th>Modelo</th>
												<th>Número de Série</th>
												<th>Status</th>
											</tr>	
											<tr>
												<td><c:out value="${maquina.hardware.placamae.fabricante}" default="?" /></td>
												<td><c:out value="${maquina.hardware.placamae.modelo}" default="?" /></td>
												<td><c:out value="${maquina.hardware.placamae.serial}" default="?"/></td>
												<td><c:out value="${maquina.hardware.placamae.status}" default="?"/></td>
											</tr>	
										</table>             
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion2" href="#hd">Unidades de Armazenamento</a>
									</h4>
								</div>
								<div id="hd" class="panel-collapse collapse">
									<div class="panel-body">
										<table class="table">
											<tr>
												<th>Fabricante</th>
												<th>Capacidade</th>
												<th>Tipo de Mídea</th>
												<th>Tipo de Interface</th>
												<th>Status</th>
											</tr>	
											<c:forEach items="${maquina.hardware.listaDeUnidadesDeArmazenamento}" var="unidade" >
											<tr>
												<td><c:out value="${unidade.nome}" default="?"/></td>
												<td><c:out value="${unidade.tamanho}" default="?"/></td>
												<td><c:out value="${unidade.tipoDeMidea}" default="?"/></td>
												<td><c:out value="${unidade.tipoDeInterface}" default="?" /></td>
												<td><c:out value="${unidade.status}"  default="?"/></td>
											</tr>
											</c:forEach>	
										</table>             
									</div>
								</div>
							</div>
						</div>
					</div>	
				</div>	
<!-- ################################################################################################################################################ -->			    			 
<!-- licencas -->

				<div role="tabpanel" class="tab-pane" id="sessao3">
					<div class="row">
						<div class="submenu">
								<ul class="nav nav-pills navbar-left">
									
									
									<!--  <li role="presentation" class="active"><a href="#myModalLicenca" data-toggle="modal" data-target="#myModalLicenca"><span class="glyphicon glyphicon-edit"></span></a></li>
									<li role="presentation" class="active"><a href="#"><span class="glyphicon glyphicon-trash"></span></a></li>-->
									<li role="presentation" class="active"><a href="#" data-toggle="modal" ><span class="glyphicon glyphicon-plus novalicenca"></span></a></li>
									<li role="presentation" class="active"><a href="#" ><span class="glyphicon glyphicon-download dowloadlicencas"></a></li>
						    	</ul>
					    </div>
					    <br><br>
						<div class="panel-group" id="accordion10">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion10" href="#licenca">Licenças</a>
									</h4>
								</div>
								<div id="licenca" class="panel-collapse collapse">
									<div class="panel-body">
										<table width="99%" class="table table-striped table-bordered table-hover" >
											<thead>
												<tr>			
													<th>Produto </th>
													<th>Chave </th>
													<th>Validade</th>
													<th align="center" ></th>
													<th align="center"></th>
													<th align="center"></th>
												</tr>
											</thead>
												
											<tbody >
											<c:forEach items="${maquina.listaDeLicencas}" var="unidade" varStatus="status">				
												<tr id="linha${status.count}">
													<td>${unidade.nomeSoftware}</td>
													<td>${unidade.chave} </td>
													<td>${unidade.dataExpiracao}</td>
													<td align="center"><a href="#" class="btn btn-xs btn-info alterarlicenca" data-toggle="modal" data-id="${status.count}"> Alterar </a></td>
													<td align="center"><a href="#" class="btn btn-xs btn-warning transferirlicenca" data-toggle="modal" data-id="${status.count}"> Transferir </a></td>
            										<!-- <td align="center"> <a href="remover?id_material=${status.count}" class="btn btn-xs btn-danger" > Remover </a></td>-->
            										<td align="center"> <button type="button" onclick="remove(this)" class="btn btn-xs btn-danger">Remover</button> </td>
													<!--  <td align="center"><span class="glyphicon glyphicon-edit"> </span></td>
													<td align="center"><input type="checkbox" value=unidade.codigoMaquina /></td>-->
												</tr>
											
											</tbody>
											</c:forEach>					
										</table>
									</div>
								</div>
							</div>
						</div>	
					</div>	
				</div>
				<br>
			</div>
		</div><!-- /container -->
<!-- ################################################################################################################################################ -->
   
		<footer>
			
			<center><p>&copy; Company 2017</p></center>
		</footer>
		
<!-- ################################################################################################################################################ -->		
		<!-- Modal Inventario-->
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		    <!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Controle de Inventário</h4>
					</div>
					<form  id="inventario_form" Action="SalvarInventario" Method="post" data-toggle="validator" role="form">	
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="codigoMaquina" class="form-control" id="codigoMaquina" value="<c:out value="${maquina.codigoMaquina}" default=" "/>">
							<input type="hidden" name="funcao" class="form-control" id="mfuncaoInventario" >
							<input type="hidden" name="hostname" class="form-control" id="mhostname" value="<c:out value="${maquina.hostname}" default=" "/>">
						</div>
						<!-- 
						<div class="form-group">
							<label for="hostname">Hostname:</label>
							<input type="text" name="hostname" class="form-control" id="mhostname" value="<c:out value="${maquina.inventario.hostname}" default=" "/>" required data-error="Preencimento desse campo é necessário">
							<div class="help-block with-errors"></div>
						</div> 
						-->
						<div class="form-group">
							<label for="responsavel">*Responsável:</label>
							<input type="text" name="responsavel" class="form-control" id="mresponsavel" value="<c:out value="${maquina.inventario.responsavel}" default=""/>" required data-error="É necessário atribuir um responsável pela máquina.">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<label for="login">Login:</label>
							<input type="text" name="login" class="form-control" id="mlogin" value="<c:out value="${maquina.inventario.loginResponsavel}" default=""/>">
						</div>
						
						<div class="form-group">
							<label for="telefone">Telefone:</label>
							<input type="text" name="telefone" class="form-control" id="mtelefone" value="<c:out value="${maquina.inventario.telefone}" default=""/>" pattern="^[0-9]{1,}$" maxlength="15" data-error="Digite apenas números. Ex:1133334444">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							  <label for="email">Email:</label>
							  <input type="email" name="email" class="form-control" id="memail" value="<c:out value="${maquina.inventario.emailResponsavel}" default=""/>" data-error="O email está com formato incorreto.">
							  <div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<label for="localizacao">Departamento:</label>
							<input type="text" name="departamento" class="form-control" id="mlocalizacao" value="<c:out value="${maquina.inventario.departamento}" default=""/>">
						</div>
						<div class="form-group">
							  <label for="patrimonio">Patrimônio:</label>
							  <input type="text" name="patrimonio" class="form-control" id="mpatrimônio" value="<c:out value="${maquina.inventario.patrimonio}" default=""/>">
						</div>
						<div class="form-group">
							  <label for="serie">Número de Série:</label>
							  <input type="text"name="serial" class="form-control" id="mserial" value="<c:out value="${maquina.inventario.serial}" default=""/>">
						</div>
						<div class="form-group">
							  <label for="fabricante">Fabricante:</label>
							  <input type="text" name="fabricante" class="form-control" id="mfabricante" value="<c:out value="${maquina.inventario.fabricante}" default=""/>">
						</div>
						<div class="form-group">
							  <label for="modelo">Modelo:</label>
							  <input type="text" name="modeloEquipamento" class="form-control" id="mmodeloEquipamento" value="<c:out value="${maquina.inventario.modeloEquipamento}" default=""/>">
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
<!-- Modal Licenca-->
		<div id="myModalLicenca" class="modal fade" role="dialog">
			<div class="modal-dialog">
		    <!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Controle de Licenças</h4>
					</div>
					<form  id="licencas_form" Action="SalvarLicenca" Method="post" data-toggle="validator" role="form">	
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="codigoMaquina" class="form-control" id="codigoMaquina" value="<c:out value="${maquina.codigoMaquina}" default=" "/>">
							<input type="hidden" name="hostname" class="form-control" id="codigoMaquina" value="<c:out value="${maquina.hostname}" default=" "/>">
							<input type="hidden" name="funcao" class="form-control" id="mfuncao" >
						</div>
						<div class="form-group">
					    	<label for="mproduto" class="control-label">*Nome do Software :</label>
					   		<input name="produto" id="mproduto" class="form-control" placeholder="*Informe o nome completo do software..."  type="text" required data-error="Preencimento obrigatório">
					   		<div class="help-block with-errors"></div>
				  		</div>
						<div class="form-group">
							<label for="mchave" class="control-label">*Chave :</label>
							<input type="text" name="chave" class="form-control" id="mchave" maxlength="35" placeholder="Informa a chave ou serial do software..." required data-error="Preencimento obrigatório">
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<label for="data">Data:</label>
							<input type="text" name="data" class="form-control" id="mdata" placeholder="Informe a data de expiração da licença de uso...">
						</div>
						
					</div>
		      		<div class="modal-footer">
				      	<button type="submit" class="btn btn-primary" id="submitFormLicenca" data-dismiss="modal">Salvar</button>
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
		        $("#inventario_form").submit();
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
