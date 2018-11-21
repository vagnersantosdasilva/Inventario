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
										<a data-toggle="collapse" data-parent="#accordion2" href="#inventario"> Informações sobre SGBD </a>
									</h4>
								</div>
								<div id="inventario" class="panel-collapse collapse in">
									<div class="panel-body">
										<table class="table">
											<tr>
												<th>SGBD	:</th> <td ><c:out value="${bd.nomeSGBD}" default=" "/></td>
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
												<th>Frequência de Backup	:</th> <td id="linha_frequencia"><c:out value="${bd.frequenciaBackup}" default=" "/></td>
											</tr>
											<tr>	
												<th>Modo de Backup	:</th> <td id="linha_modo"><c:out value="${bd.modoBackup}" default=" "/></td>
											</tr>
											<tr>	
												<th>Formato de Saída	:</th> <td id="linha_formato"><c:out value="${bd.formatoBackup}" default=" "/></td>
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
							<input type="hidden" name="ip" class="form-control" id="mip" value="<c:out value="${bd.ipBanco}" default=" "/>">
							<input type="hidden" name="porta" class="form-control" id="mporta" value="<c:out value="${bd.portaBanco}" default=" "/>">
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
							    <option id="5" value="Auto">Automático</option>
							    <option id="6" value="Manual">Manual</option>
							   
							 </select>
						</div>
						
						<div class="form-group">
							<label for="grupo">Tipo de Arquivo de Backup:</label>
							<select class="form-control" id="mformato" name="formato">
							    <option id="7" value="TXT">TXT</option>
							    <option id="8" value="CSV">CSV</option>
							    <option id="9" value ="JSON">JSON</option>
							    <option id="10" value="SQL">SQL</option>
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
    $(".alterar").on('click', function(){
		
    	var frequencia = $("#linha_frequencia").text();
    	var modo = $("#linha_modo").text();
		var backup=$("#linha_formato").text();
    	if (frequencia=="Diariamente"){document.getElementById("1").selected=true;}
		if (frequencia=="Semanalmente"){document.getElementById("2").selected=true;}
		if (frequencia=="Mensalmente"){document.getElementById("3").selected=true;}
		if (frequencia=="Semestralmente"){document.getElementById("4").selected=true;}
		if (modo =="Auto"){document.getElementById("5").selected=true;}
		if (modo =="Manual"){document.getElementById("6").selected=true;} 
		if (backup =="TXT"){document.getElementById("7").selected=true;}
		if (backup =="CSV"){document.getElementById("8").selected=true;}
		if (backup =="JSON"){document.getElementById("9").selected=true;}
		if (backup =="SQL"){document.getElementById("10").selected=true;}
	});
    
    </script>
    <script>
		/* must apply only after HTML has loaded */
		$(document).ready(function () {
		    $("#submitForm").on("click", function() {
		        $("#infobanco_form").submit();
		    });
		});
	</script>
	<script src="/Inventario/suporte/js/validator.js"></script>  
	</BODY>
</HTML>
