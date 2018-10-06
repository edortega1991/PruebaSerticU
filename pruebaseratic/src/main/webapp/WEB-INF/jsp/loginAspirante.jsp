<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
            <!-- para utliazar materialize -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
            <!-- css, para cargar css al proyecto -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link href="<c:url value='/css/materialize.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            <link href="<c:url value='/css/style.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
        <title>Login</title>

    <!-- Bootstrap CSS -->
    <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
    <!-- My CSS -->
    <!--<link rel="stylesheet" href="css/style.css">-->
  </head>
  <body>
      
      <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="home.htm" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                </div>
      </nav>  
    <left>
     <div class="had-container logueo ">
      <!--<div class="parallax"><img src="https://alistapart.com/d/438/fig-6--background-blend-mode.jpg"></div>-->
      	<div class="row"><br>
      		
      		<div class="col m4 s12 offset-m2 offset-s2">
      			<h4 class="truncate bg-card-user">
      				                              
                                        <div class="row login">
                                              <h4>
                                                  
                                                  <span class="blue-grey-text"> Iniciar sesión Aspirante</span>
                                                  
                                              </h4>
                                              <form:form method="post" modelAttribute="aspirante" >  <!--class="col s12">-->
					      <div class="row">
					         <div class="input-field col m12 s12">
					          <i class="large material-icons iconis prefix">account_box</i>
                                                    <form:label for="icon_prefix" path="correo">E-mail:</form:label>
                                                    <form:input id="icon_prefix" type="text" class="validate" required="true" aria-required="true" path="correo"/>
					          </div>
					      </div>
					      <div class="row">
					        <div class="input-field col m12 s12">
					          <i class="material-icons iconis prefix">enhanced_encryption</i>
                                                  <form:label for="icon_prefix" path="cedula" name="cedula1">Cedula:</form:label>
                                                  <form:input id="icon_prefix" type="text" class="validate" required="true" aria-required="true" path="cedula" name="cedula1" />
                                                  
                                                </div>
					      </div>
					      <div class="row">
					      	<button type="submit" value="Enviar" name="submit" class='col s12 btn btn-large waves-effect indigo'>Login</button> 
					      </div>
					    </form:form>
					  </div>
                                
                                
                     			</h4>
		   	  </div>
	    	</div>
	</div>
        
        
            <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="home.htm" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                </div>
            </nav>  
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
            <!--  Scripts-->
            <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
            <script src="<c:url value='/js/materialize.js'/>"></script>
            <script src="<c:url value='/js/init.js'/>"></script>  
  </body>
</html>
