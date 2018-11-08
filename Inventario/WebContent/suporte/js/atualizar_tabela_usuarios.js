$(".novo").on('click', function(){
		var nome="";
		var telefone="";
		var email="";
		var contexto="incluir";
	    $("#mcontexto").val(contexto);
		$("#mnome").val(nome);
		$("#memail").val(email);
		$("#mtelefone").val(telefone);
		
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
		
		$("#myModalUsuarios").modal();
	});
	
	
	/*Envio do formulario para servlet*/
	/* must apply only after HTML has loaded */
	$(document).ready(function () {
	    $("#submitForm").on('click', function() {
	    		 $("#inventario_form").submit();	 
	        
	    });
	});