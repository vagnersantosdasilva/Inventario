<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<div="container">
	
		    <meta charset="utf-8">
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		    <meta name="description" content="">
		    <meta name="author" content="">
		    <link rel="icon" href="../../favicon.ico">
		
		    <title>Produtos</title>
		
		    <!-- Bootstrap core CSS -->
		    <link href="../css/bootstrap.min.css" rel="stylesheet">
		    <link href="../css/style.css" rel="stylesheet">
		
		    <!-- Custom styles for this template -->
		    <link href="..css/jumbotron.css" rel="stylesheet">
		
		    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
		    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
		    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
		
		    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		    <!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		    <![endif]-->
  </head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sistema de Inventário e Monitoração</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" method=post action="Autenticacao">
            <div class="form-group">
              <input type="text" placeholder="Login" class="form-control" name="login">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Senha" class="form-control" name="senha">
            </div>
            <button type="submit" class="btn btn-success">Entrar</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron" >
  <!-- 
      <button type="button" class="btn btn-default btn-lg">
  		<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	  </button>
  	  	
		<button type="button" class="btn btn-default btn-lg">
  		<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>
	  </button>
	  
	  <button type="button" class="btn btn-default btn-lg">
  		<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
	  </button>
	  
	  <button type="button" class="btn btn-default btn-lg">
  		<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
	  </button>
	  
	  	<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
	  	<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	  	<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>
	  	<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
	  	<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
	  -->
	</div>
	
	
<div class="container">
		
		  <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist">
		    <li role="presentation" class="active"><a href="#agenda" aria-controls="agenda" role="tab" data-toggle="tab">Agenda</a></li>
		    <li role="presentation"><a href="#produtos" aria-controls="produtos" role="tab" data-toggle="tab">Produtos</a></li>
		    <li role="presentation"><a href="#servicos" aria-controls="servicos" role="tab" data-toggle="tab">Serviços</a></li>
		    <li role="presentation"><a href="#clientes" aria-controls="clientes" role="tab" data-toggle="tab">Clientes</a></li>
		    <li role="presentation"><a href="#fornecedores" aria-controls="fornecedores" role="tab" data-toggle="tab">Fornecedores</a></li>
		  </ul>
		
		  <!-- Tab panes -->
		  <div class="tab-content">
		    <div role="tabpanel" class="tab-pane active" id="agenda">
		    	
		    	<div id="menu">
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingOne">
								      <h4 class="panel-title">
								        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
								          Collapsible Group Item #1
								        </a>
								      </h4>
								    </div>
								    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
								      <div class="panel-body">
								        
								        <ul>
											<li><a href="#">Função 1</a></li>
											<li><a href="#">Função 2</a></li>
											<li><a href="#">Função 3</a></li>
											<li><a href="#">Função 4</a></li>
											
										</ul>
								        
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingTwo">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
								          Collapsible Group Item #2
								        </a>
								      </h4>
								    </div>
								    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
								      <div class="panel-body">
								        <ul>
										<li><a href="#">Função 1</a></li>
										<li><a href="#">Função 2</a></li>
										<li><a href="#">Função 3</a></li>
										<li><a href="#">Função 4</a></li>
										
									</ul>
								        
								        
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading" role="tab" id="headingThree">
								      <h4 class="panel-title">
								        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
								          Collapsible Group Item #3
								        </a>
								      </h4>
								    </div>
								    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
								      <div class="panel-body">
								        
								        		 <ul>
													<li><a href="#">Edição de Registro</a></li>
													<li><a href="#">Edição de Banco de Dados</a></li>
													<li><a href="#">Edição MySQL !</a></li>
													<li><a href="#">Edição PostGres !</a></li>
													
												</ul>
								      </div>
								    </div>
								  </div>
								</div>

				</div>
				<h4>Selecione no menu ao lado ou faça uma pesquisa geral usando o campo de busca no canto superior da tela</h4>            
					

		    			    
		    </div>
		    
		    <div role="tabpanel" class="tab-pane" id="produtos">
		    
		    
		    
		    
		    	
		    		
		    		
		    		<div id="menu">
		    			
		    				<div class="panel-group" id="accordion">
								  <div class="panel panel-default">
								    <div class="panel-heading">
								      <h4 class="panel-title">
								        <a data-toggle="collapse" data-parent="#accordion1" href="#collapse1">
								        Collapsible Group 1</a>
								      </h4>
								    </div>
								    <div id="collapse1" class="panel-collapse collapse in">
								      <div class="panel-body">
								      		
								      		<ul>
													<li><a href="#">Função 1</a></li>
													<li><a href="#">Função 2</a></li>
													<li><a href="#">Função 3</a></li>
													<li><a href="#">Função 4</a></li>
													
											</ul>
								      
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading">
								      <h4 class="panel-title">
								        <a data-toggle="collapse" data-parent="#accordion1" href="#collapse2">
								        Collapsible Group 2</a>
								      </h4>
								    </div>
								    <div id="collapse2" class="panel-collapse collapse">
								      <div class="panel-body">

								      		<ul>
													<li><a href="#">Função 1</a></li>
													<li><a href="#">Função 2</a></li>
													<li><a href="#">Função 3</a></li>
													<li><a href="#">Função 4</a></li>
													
											</ul>								      
								      
								      </div>
								    </div>
								  </div>
								  <div class="panel panel-default">
								    <div class="panel-heading">
								      <h4 class="panel-title">
								        <a data-toggle="collapse" data-parent="#accordion1" href="#collapse3">
								        Collapsible Group 3</a>
								      </h4>
								    </div>
								    <div id="collapse3" class="panel-collapse collapse">
								      <div class="panel-body">

								      		<ul>
													<li><a href="#">Função 1</a></li>
													<li><a href="#">Função 2</a></li>
													<li><a href="#">Função 3</a></li>
													<li><a href="#">Função 4</a></li>
													
											</ul>
								      
								      </div>
								    </div>
								  </div>
						</div>
					</div>
		    		
		     <!-- Paragrafo do tab -->
		    
		    <h3>Teste de conteudo aba 2</h3>
		    
		    </div>
		    
		   
		    
		    
		    <div role="tabpanel" class="tab-pane" id="servicos">
		    	
		    	<p>Teste de conteudo aba 3</p>
		    	
		    </div>
		    <div role="tabpanel" class="tab-pane" id="clientes">
		    	
		    	<p>Teste de conteudo aba 4</p>
		    
		    </div>
		    <div role="tabpanel" class="tab-pane" id="fornecedores">
		    	
		    	<p>Teste de conteudo aba 5</p>
		    
		    </div>
		    
		  </div>
	</div>	  
 



 <!-- Bootstrap core JavaScript
    ================================================== -->
    
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    
    
</body>
</html>