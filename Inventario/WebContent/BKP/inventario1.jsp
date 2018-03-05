<%@page import="Entidades.Maquina.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
    <HEAD>
        
        <TITLE>Inventário</TITLE>
        <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <!-- Bootstrap -->
        <!-- <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
	    <script src="js/bootstrap.js"></script>
        <link href="css/bootstrap2.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/agency.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
		 <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

		 -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>    

	    <![endif]-->	
	</HEAD>
    
    <BODY>
		

		<nav class="navbar-default">
		    <div class="container">
					<div class="navbar-header">
						  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						    <span class="sr-only">Toggle navigation</span>
						    <span class="icon-bar"></span>
						    <span class="icon-bar"></span>
						    <span class="icon-bar"></span>
						  </button>
					  	  <a class="navbar-brand" href="#"><c:out value="${maquina.hostname}" default="Inventário"/></a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
						    <li>
					    		<div class="dropdown">
					    			<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						    				<span class="glyphicon glyphicon-edit"> </span>
					    			</button>
					    		</div>
								
							 </li>
							 <li>
							    <div class="dropdown">
					  				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					   						<span class="glyphicon glyphicon-user"></span>
					    							<!--  <span class="caret"></span>-->
					  				</button>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								    	 <li><a href="#"><span class="glyphicon glyphicon-off"></span> Logoff</a></li>
										 <li role="separator" class="divider"></li>
									</ul>
								</div>
							 </li>
							 <li>
								<div class="dropdown">
					  				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					   						<span class="glyphicon glyphicon-search"></span>
					    							<!--  <span class="caret"></span>-->
					  				</button>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
									    <li>
										    <form method="get" action="buscar" >
		  										<input name="procurar" type="text" placeholder="Pesquisar..." />
		  									</form>
										</li>
										<li role="separator" class="divider"></li>
									</ul>
								 </div>
							   </li>
							    
						  </ul>
				     </div>
			<!-- /.navbar-collapse -->
			
			
			</div>
		</nav>
     	

		<div class="container">
     
					 <ul class="nav nav-tabs" role="tablist">
					    <li role="presentation" class="active"><a href="#sessao0" aria-controls="sessao0" role="tab" data-toggle="tab">Software</a></li>
			            <li role="presentation"><a href="#sessao1" aria-controls="sessao1" role="tab" data-toggle="tab">Hardware</a></li>
					    <li role="presentation"><a href="#sessao2" aria-controls="sessao2" role="tab" data-toggle="tab">Inventário</a></li>
					    <li role="presentation"><a href="#sessao3" aria-controls="sessao3" role="tab" data-toggle="tab">Status</a></li>
					 </ul>
	
			 		<!-- Tab panes -->
					<div class="tab-content">
			    			 <div role="tabpanel" class="tab-pane active" id="sessao0">
			     					<div class="row">
			   		   
											<br><br>
					      
					      					<div class="panel-group" id="accordion">
									
													<div class="panel panel-default">
									    				<div class="panel-heading">
									      					 <h4 class="panel-title">
									              			 <a data-toggle="collapse" data-parent="#accordion1" href="#so">
									              			  	Sistema Operacional</a>
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
																				</tr>
																											
																				<tr>
																					<td><c:out value="${maquina.sistemaOperacional.nome}" /></td>
																					<td><c:out value="${maquina.sistemaOperacional.arquitetura}" /></td>
																					<td><c:out value="${maquina.sistemaOperacional.versao}" /></td>
																					<td><c:out value="${maquina.sistemaOperacional.atualizacao}" /></td>
																					
																					
																				</tr>
																						
																		</table>
																	</div>
														</div>
													</div>
													
													<div class="panel panel-default">
										 				<div class="panel-heading">
														      <h4 class="panel-title">
														      <a data-toggle="collapse" data-parent="#accordion1" href="#licenca">
															        Licenças</a>
														      </h4>
														</div>
									    				 <div id="licenca" class="panel-collapse collapse">
										      					<div class="panel-body">
			
															           <table class="table">
																					
																			<tr>
																				<th>Produto </th>
																				<th>Serial </th>
																				<th>Chave </th>
																				<th>Local</th>
																				<th>Atualização</th>
																				<th>Data</th>
																			</tr>
																							
																			<tr>
																				<td>Windows 7 Ultimate</td>
																				<td>00426-OEM-8992662-00400</td>
																				<td>342DG-6YJR8-X92GV-V7DCV-P4K27 </td>
																				<td>C:\Windows</td>
																				<td>Service Pack 1</td>
																						
																				<td>3/04/2015 04:27:27</td>
																								
																			</tr>
																							
																			<tr>
																				<td>Microsoft Office Professional Edição 2003  </td>
																				<td>00426-OEM-8992662-00400</td>
																				<td>342DG-6YJR8-X92GV-V7DCV-P4K27 </td>
																				<td>C:\Windows</td>
																				<td>Service Pack 1</td>
																								
																				<td>3/04/2015 04:27:27</td>
																			</tr>
																							
																							
																			<tr>
																				<td>Internet Explorer</td>
																				<td>00426-OEM-8992662-00400</td>
																				<td>342DG-6YJR8-X92GV-V7DCV-P4K27 </td>
																				<td></td>
																				<td></td>
																								
																				<td>19/09/2011 01:06:27</td>
																								
																			</tr>
																							
																							
																	  </table>
													            
											  					</div>
														</div>
													</div>
									
															  
													<div class="panel panel-default">
														 <div class="panel-heading">
														      <h4 class="panel-title">
														            <a data-toggle="collapse" data-parent="#accordion1" href="#programas">
															        Programas Instalados</a>
															  </h4>
														 </div>
														 <div id="programas" class="panel-collapse collapse">
														      <div class="panel-body">
									
												                 <table class="table">
																					
																	<tr>
																		<th>Nome </th>
																		<th>Arquitetura </th>
																		<th>Data De Instalação</th>
																	</tr>
																	<c:forEach items="${maquina.listaSoftwares}" var="software">						
																	<tr>
																		<td><c:out value="${software.nome}" default=" " /> </td>
																		<td><c:out value="${software.arquitetura}" default=" " /></td>
																		<td><c:out value="${software.dataInstalacao}" default=" " /></td>
																	</tr>
																	</c:forEach>						
														        </table>
															  </div>
														  </div>
													  </div>
								
						  					</div>
	             					</div> <!-- /row> -->
			   				 </div>
			     			 <div role="tabpanel" class="tab-pane" id="sessao1">
	            	 				<div class="row">
											<br><br>
								
											<div class="panel-group" id="accordion">
									  				<div class="panel panel-default">
										    				<div class="panel-heading">
										     						 <h4 class="panel-title">
										       						 <a data-toggle="collapse" data-parent="#accordion2" href="#cpu">
										        						CPU</a>
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
																					<th>Arquitetura</th>
																					<th>Status</th>
																				</tr>
																				
																				<tr>
																						
																					<td><c:out value="${maquina.hardware.cpu.nome}" default="?"/></td>
																					<td><c:out value="${maquina.hardware.cpu.fabricante}" default="?"/></td>
																					<td><c:out value="${maquina.hardware.cpu.frequenciaMaxima}" default="?"/></td>
																					<td><c:out value="${maquina.hardware.cpu.numeroNucleos}" default="?"/></td>
																					<td><c:out value="${maquina.hardware.cpu.numeroProcessadoresLogicos}" default="?" /></td>
																					<td><c:out value="${maquina.hardware.cpu.arquitetura}" default="?" /></td>
																					<td><c:out value="${maquina.hardware.cpu.status}" default="?" /></td>
																					
																					
																				</tr>
																				
																				
																				
																				
																			</table>
												
										    						  </div>
										  					</div>
													 </div>
									  				<div class="panel panel-default">
														    <div class="panel-heading">
															      <h4 class="panel-title">
															        <a data-toggle="collapse" data-parent="#accordion2" href="#ram">
															        Memória RAM</a>
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
																					<c:forEach items="${maquina.hardware.listaMemorias}" var="memoria">
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
															        <a data-toggle="collapse" data-parent="#accordion2" href="#placamae">
															        	Placa Mãe</a>
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
															        <a data-toggle="collapse" data-parent="#accordion2" href="#hd">
															        	Unidades de Armazenamento</a>
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
																				<c:forEach items="${maquina.hardware.listaUnidadesArmazenamento}" var="unidade">
																					
																				
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
			    			 <div role="tabpanel" class="tab-pane" id="sessao2">
							        <div class="row">
											<!--	
											<div class="submenu">
												<ul class="nav navbar-nav navbar-left">
														
														<a href="#" title="Editar"> <span class="glyphicon glyphicon-edit"></span>  </a>							   
														  < href="editarInventario.jsp">  Editar  <span class="glyphicon glyphicon-edit"></span></a>
																	
														</li>
																		    
												</ul>
											  
											   
											</div>-->
											<div class="submenu">
														  			<ul class="nav nav-pills navbar-left">
																			  <li role="presentation" class="active"><a href="#">Editar</a></li>
																			  
					    											</ul>
				    						</div>	 
												 <br><br>
												<div class="panel-group" id="accordion">
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
																							<th>Nome Usuário :</th> <td><c:out value="${maquina.usuario.nome}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Login	:</th> <td><c:out value="${maquina.usuario.login}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Localização	:</th> <td><c:out value="${maquina.usuario.localizacao}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Tel	:</th> <td><c:out value="${maquina.usuario.telefone}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Email	:</th> <td><c:out value="${maquina.usuario.email}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Patrimônio	:</th> <td><c:out value="${maquina.patrimonio}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Número de Série	:</th> <td><c:out value="${maquina.serie}" default=" "/></td>
																						</tr>
																						<tr>	
																							<th>Fabricante	:</th> <td><c:out value="${maquina.fabricante}" default=" "/></td>
																						</tr>
																						
																						<tr>	
																							<th>Modelo	:</th> <td><c:out value="${maquina.modelo}" default=" "/></td>
																						</tr>
																						
																								
																					
																				</table>
														 
																    		</div>
																</div>
														</div>
												 
				   								</div>
			   						</div>	
			    
			    
							</div>
							 <div role="tabpanel" class="tab-pane" id="sessao3">
			
									<div class="row">
												<br><br>
												
												<div class="panel-group" id="accordion">
													  <div class="panel panel-default">
														    <div class="panel-heading">
															      <h4 class="panel-title">
															        <a data-toggle="collapse" data-parent="#accordion2" href="#status">
															        	Informações adicionais
															        </a>
															      </h4>
														    </div>
														    <div id="status" class="panel-collapse collapse in">
														     	 <div class="panel-body">
														      		         <table class="table">
																		
																					<tr>
																					    <th>Último logado	:</th> <td>vagner</td>
																					</tr>
																					<tr>
																					    <th>Último login	:</th> <td>09/04/2016 10:25</td>
																					</tr>
																					
																					<tr>    
																						<th>Online	:</th> <td>Não</td>
																					</tr>
																					<tr>	
																						<th>Logs de Erro	:</th> <td>Sim</td>
																					</tr>
																				
																				
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
    
   
	    <footer>
	    		<span class="label label-default">Default</span>
				<span class="label label-primary">Primary</span>
				<span class="label label-success">Success</span>
				<span class="label label-info">Info</span>
				<span class="label label-warning">Warning</span>
				<span class="label label-danger">Danger</span>
					<p>&copy; Company 2017</p>
		</footer>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- ><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script>  

		   $('#myTab a[href="#status"]').click(function (e) {
		         e.preventDefault();
		         $(this).tab('show');
		         $('#status').load('status.html');
		   });
	</script> 
        
	</BODY>
</HTML>
