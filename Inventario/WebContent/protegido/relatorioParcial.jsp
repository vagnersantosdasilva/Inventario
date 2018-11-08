<%@page import="DAO.Maquinas"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listagem de Máquinas</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <!-- Bootstrap -->
        
        
		<script src="/Inventario/suporte/js/bootstrap.js"></script>
        <link href="/Inventario/suporte/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="/Inventario/suporte/css/bootstrap2.css" rel="stylesheet">
	    <link href="/Inventario/suporte/css/dataTables.bootstrap.css" rel="stylesheet">
      	<link href="/Inventario/suporte/css/dataTables.responsive.css" rel="stylesheet">
      	<!--  <link href="/Inventario/dash/dist/css/sb-admin-2.css" rel="stylesheet">-->
</head>
<body>
<!-- ########################################## NAV ############################################################## -->
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
        	<ul class="nav navbar-nav navbar-right">
           		
	           	<li><a href="/Inventario/protegido/index.html"><i class="fa fa-home fa-fw"></i> Início</a> </li>	
                
                   
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
<!-- ########################################## Fim NAV############################################################## -->

<!-- ########################################## Body ############################################################## -->

		<div class="container">
			<br>
			
			<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Relatório Parcial de Inventários</h2>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                     <i class="fa fa-list-alt fa-5x"></i> 
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${maquinas.totalMaquinas}" default=""/></div>
                                   					 
                                    <div>Total de Máquinas </div>
                                </div>
                            </div>
                        </div>
                        <a href="listarMaquinas?filtro=todos">
                            <div class="panel-footer">
                                <span class="pull-left">Ver Lista</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                   <i class="fa fa-list-alt fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${maquinas.maquinasComInventario}" default=""/></div>
                                    <div>Com Inventário!</div>
                                </div>
                            </div>
                        </div>
                        <a href="listarMaquinas?filtro=comInventario">
                            <div class="panel-footer">
                                <span class="pull-left">Ver Lista</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-warning fa-5x "></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${maquinas.maquinasComPendencias}" default=""/></div>
                                    <div>Com Pendências!</div>
                                </div>
                            </div>
                        </div>
                        <a href="listarMaquinas?filtro=comPendencias">
                            <div class="panel-footer">
                                <span class="pull-left">Ver Lista</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                     <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${maquinas.maquinasSemInventario}" default=""/></div>
                                    <div>Não Inventariadas!</div>
                                </div>
                            </div>
                        </div>
                        <a href="listarMaquinas?filtro=semInventarios">
                            <div class="panel-footer">
                                <span class="pull-left">Ver Lista</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
			
			
			<br>
			
			
			
			
		
		
		</div>
		
		
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- ><script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/Inventario/suporte/js/jquery.js"></script>
	<script src="/Inventario/suporte/js/bootstrap.min.js"></script>

	
	<!-- DataTables JavaScript -->
    <script src="/Inventario/suporte/js/jquery.dataTables.min.js"></script>
    <script src="/Inventario/suporte/js/dataTables.bootstrap.js"></script>
    <script src="/Inventario/suporte/js/dataTables.responsive.js"></script>
	<script src="/Inventario/suporte/js/dataTables.responsive.js"></script>
	<script src="/Inventario/suporte/js/dataTables.buttons.min.js"></script>
	<!-- Os proximos scripts devem ser transferidos para arquivos .js -->
	<script src="/Inventario/suporte/js/tabelas.js"></script>
	<script charset="UTF-8">
    
    </script>
   <!-- Reset modal caso seja fechado -->
	<!--  <script type="text/javascript">
			$(document).ready(function(){
				comeca();
			})
			var timerI = null;
			var timerR = false;
 
			function para(){
    			if(timerR)
        			clearTimeout(timerI)
    			timerR = false;
			}
			function comeca(){
    			para();
    			lista();
			}
			function lista(){
				$.ajax({
					url:"listarMaquinas",
   					success: function (textStatus){
 						$('#container').html(textStatus); //mostrando resultado
 					}
 				})
 				timerI = setTimeout("lista()", 5);//tempo de espera
    			        timerR = true;
 
			}
		</script>
		-->
</body>
</html>