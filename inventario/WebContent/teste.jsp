<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Estúdio FotoGráfica</title>

    <!-- Bootstrap Core CSS -->
    <link href="suporte/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="suporte/css/agency.css" rel="stylesheet">
</head>    
<body>
 <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Contato</h2>
                    <h3 class="section-subheading text-muted">Mande suas dúvidas que retornaremos pra você.</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form data-toggle="validator" role="form" action="salvar" method="post">
						  <div class="form-group">
						    <label for="inputName" class="control-label">Name</label>
						    <input type="text" class="form-control" id="inputName" placeholder="Cina Saffary" required>
						    <div class="help-block with-errors"></div>
						  </div>
						  <div class="form-group has-feedback">
						    <label for="inputTwitter" class="control-label">Twitter</label>
						    <div class="input-group">
						      <span class="input-group-addon">@</span>
						      <input type="text" pattern="^[_A-z0-9]{1,}$" maxlength="15" class="form-control" id="inputTwitter" placeholder="1000hz" required>
						    </div>
						    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						    <div class="help-block with-errors">Hey look, this one has feedback icons!</div>
						  </div>
						  <div class="form-group">
						    <label for="inputEmail" class="control-label">Email</label>
						    <input type="email" class="form-control" id="inputEmail" placeholder="Email" data-error="Bruh, that email address is invalid" required>
						    <div class="help-block with-errors"></div>
						  </div>
						  <div class="form-group">
						    <label for="inputPassword" class="control-label">Password</label>
						    <div class="form-inline row">
						      <div class="form-group col-sm-6">
						        <input type="password" data-minlength="6" class="form-control" id="inputPassword" placeholder="Password" required>
						        <div class="help-block">Minimum of 6 characters</div>
						      </div>
						      <div class="form-group col-sm-6">
						        <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Whoops, these don't match" placeholder="Confirm" required>
						        <div class="help-block with-errors"></div>
						      </div>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="radio">
						      <label>
						        <input type="radio" name="underwear" required>
						        Boxers
						      </label>
						    </div>
						    <div class="radio">
						      <label>
						        <input type="radio" name="underwear" required>
						        Briefs
						      </label>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="checkbox">
						      <label>
						        <input type="checkbox" id="terms" data-error="Before you wreck yourself" required>
						        Check yourself
						      </label>
						      <div class="help-block with-errors"></div>
						    </div>
						  </div>
						  <div class="form-group">
						    <button type="submit" class="btn btn-primary">Submit</button>
						  </div>
</form>
                </div>
            </div>
        </div>
    </section>
    <script src="suporte/js/jquery.js"></script>
	<script src="suporte/js/bootstrap.min.js"></script>
	<script src="suporte/js/jqBootstrapValidation.js"></script>
 	<script src="suporte/js/agency.js"></script>
 	
 	
 	
 	<script>
		/* must apply only after HTML has loaded */
		$(document).ready(function () {
		    $("#submitForm").on("click", function() {
		    	 var vnome = $('#nome').val();
		    	 if (vnome!="")
		    	 {
		    		 $("inventario_form").submit();	 
		    	 }
		    	 else
		    	 {
		    			 
		    	 }
		    });
		     
		    $("#submitForm").on('click', function() {
		    	
		        $("#inventario_form").submit();
		    });
		});
	</script>
	<script type="text/javascript">
        $("form").validate({
            showErrors: function (errorMap, errorList) {
                // Clean up any tooltips for valid elements
                $.each(this.validElements(), function (index, element) {
                    var $element = $(element);
                    $element.data("title", "") // Clear the title - there is no error associated anymore
                    .removeClass("error")
                    .tooltip("destroy");
                });
                // Create new tooltips for invalid elements
                $.each(errorList, function (index, error) {
                    var $element = $(error.element);
                    $element.tooltip("destroy") // Destroy any pre-existing tooltip so we can repopulate with new tooltip content
                    .data("title", error.message)
                    .addClass("error")
                    .tooltip(); // Create a new tooltip based on the error messsage we just set in the title
                });
            },
            submitHandler: function (form) {
                alert("This is a valid form!");
            }
        });
    </script>
 	<script src="/Inventario/suporte/js/validator.js"></script>
 </body>
 </html>       