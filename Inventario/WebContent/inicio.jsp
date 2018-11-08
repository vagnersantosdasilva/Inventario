<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HEAD>  
        <TITLE>Sistema de Inventário</TITLE>
        
        <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <!-- Bootstrap -->
        
        <link href="/Inventario/suporte/css/bootstrap2.css" rel="stylesheet">
        
        <link href="/Inventario/suporte/css/sb-admin-2.css" rel="stylesheet">
        <link href="/Inventario/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	    <link href="/Inventario/css/sb-admin-2.css" rel="stylesheet">
	    <link href="/Inventario/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>    

	    <![endif]-->
	    	
</HEAD>
    
<BODY>
	<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
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

           
           		<ul class="nav navbar-top-links navbar-right">
           		
	           		
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-search fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-search ">
                        <li>
							<form method="get" action="buscar" >
		  						<input name="procurar" id="procurar" type="text" placeholder="Pesquisar..." />
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
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
		</nav>
		
	</div>
	<!--<c:import url="teste.jsp" />-->
	
	<div class="container">
	<br><br><br><br>
		<div class="row" align="center">
	           <div class="col-md-4">
                    <a href="listar?*" class="btn page-scroll">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-square-o fa-stack-2x text-primary" ></i>
                        <i class="fa fa-laptop fa-stack-1x text-primary"></i>
                    </span></a>
                    <h4  >Listagem de Máquinas </h4>
                    
                </div>
                <div class="col-md-4"  >
                	<a href="dash/index.html" class="btn page-scroll">
                    <span class="fa-stack fa-4x" >
                        <i class="fa fa-square fa-stack-2x text-primary"  ></i>
                        <i class="fa fa-dashboard fa-stack-1x fa-inverse" ></i>
                    </span></a>
                    <h4  >Dashboard</h4>
                   
                </div>
                 <div class="col-md-4"  >
                 	<a href="contato.html" class="btn page-scroll">
                    <span class="fa-stack fa-4x" >
                        <i class="fa fa-square fa-stack-2x text-primary"  ></i>
                        <i class="fa fa fa-bar-chart fa-stack-1x fa-inverse" ></i>
                    </span></a>
                    <h4  >Estatísticas</h4>
                   
                </div>
		</div>
		<br><br>
		<div class="row" align="center">
	           <div class="col-md-4">
                    <a href="encomendas.html" class="btn page-scroll">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-square fa-stack-2x text-primary" ></i>
                        <i class="fa fa-database fa-stack-1x fa-inverse"></i>
                    </span></a>
                    <h4  >Base de Dados </h4>
                    
                </div>
                <div class="col-md-4"  >
                	<a href="kitfestas.html" class="btn page-scroll">
                    <span class="fa-stack fa-4x" >
                        <i class="fa fa-square fa-stack-2x text-primary"  ></i>
                        <i class="fa fa-heartbeat fa-stack-1x fa-inverse" ></i>
                    </span></a>
                    <h4 align="center">Monitorar Máquina</p>
                   
                </div>
                 <div class="col-md-4"  >
                 	<a href="/Inventario/listar" class="btn page-scroll">
                    <span class="fa-stack fa-4x" >
                        <i class="fa fa-square-o fa-stack-2x text-primary"  ></i>
                        <i class="fa fa-users fa-stack-1x text-primary" ></i>
                    </span></a>
                    <h4  >Gerenciar Usuários</h4>
                </div>
		</div>
		
	</div>
	<br><br>	
   	<footer>
   		<p align="center">&copy; Company 2017</p>
   	</footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/Inventario/suporte/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/Inventario/suporte/js/bootstrap.min.js"></script>
        
</BODY>
</HTML>
</html>