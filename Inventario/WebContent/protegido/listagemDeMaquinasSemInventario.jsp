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
        <link href="/Inventario/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="/Inventario/suporte/css/bootstrap2.css" rel="stylesheet">
	    <link href="/Inventario/suporte/css/dataTables.bootstrap.css" rel="stylesheet">
      	<link href="/Inventario/suporte/css/dataTables.responsive.css" rel="stylesheet">
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
			<br><br>
			
			
			
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <b>Listagem de Máquinas</b>
                        </div>
                        <!-- /.panel-heading -->
                        
                        <div class="panel-body">
                        	
                            <table width="99%" class="table table-striped table-bordered table-hover" id="dataTables">
                              
                                <thead>
                                    <tr>
                                        <th>Código de Máquina</th>
                                        <th>Hostname</th>
                                       
                                        <th></th>
                                      
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${maquinas.listaDeMaquinasSemInventario}" var="objeto" >
                                    <tr >
                                        <td ><c:out value="${objeto.codigoMaquina}"  /></td>
                                        <td ><c:out value="${objeto.hostname}" /></td>
                                        <td align="center"><a href="buscar?procurar=${objeto.hostname}" class="btn btn-xs btn-info editar">Editar Inventário</a></td>
            					
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
	
		
</body>
</html>