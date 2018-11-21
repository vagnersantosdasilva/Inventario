(function($) {
		  remove = function(item,contador) {
			
		    $("#confirm").modal();
		    $("#confirm-delete")
			$.get('removerUsuario',{codigo_usuario:contador},function(responseText) {
				
            	atert(responseText);
                     	
            });
            var tr = $(item).closest('tr');
		    var contador=contador;
			tr.fadeOut(400, function() {
		      tr.remove();  
		    });

		    return false;
		  }
		})(jQuery);