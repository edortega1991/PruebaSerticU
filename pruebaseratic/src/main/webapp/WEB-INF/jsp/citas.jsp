<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
            <!-- css -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link href="<c:url value='/css/materialize.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            <link href="<c:url value='/css/style.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            
            
            
            <title>Citas</title>
        </head>
        
        <body>
             <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="home.htm" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                     <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <!-- <li><a href="user.htm"><span class="lime-text text-accent-2">Usuario1</span></a></li>-->
                        <li><a href=""><span class="lime-text text-accent-2">Jugador1</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Repote1</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Salir</span></a></li>
                    </ul>
                </div>
              </nav>
            
            </br>
            </br>
            
            <h5><i class="material-icons">search</i>Ingrese la cédula del usuario:</h5>
            <div class="container">
            <div class="nav-wrapper">
                <form name="ejemplo" action="citas.htm" method="POST">
                    <div class="input-field">
                        Ingrese la cedula del usuario: <input type="search" name="cedula1"><br>
                        Ingrese la cedula del doctor: <input type="search" name="cedula2"><br>
                        <input type="date" class="datepicker">
                        <input type="time" class="datepicker">
                        
                        
                        <input type="submit" value="AGREGAR CITA">
                    </div>    
                </form>
            </div>
            
            
            </div>    
           
            <!--
            <h2 class="center"><span class="yellow-text text-darken-4">Asignar Cita</span></h2>
            
            
            <c:forEach items="${usua1}" var="usua" >
            <form>                           
                <div class="row">                    
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usua.nombre}"/></label>                        
                </div>
                
                <div class="row">                    
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="apellido" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="apellido" value=""><c:out value="${usua.apellido}"/></label>                        
                </div>
                
                <div class="row">                    
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="id" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="id" value=""><c:out value="${usua.cedula}"/></label>                        
                </div>
                    
                </div>     
            </form>  
                    
            </c:forEach>  
            
            
            
            
            <c:forEach items="${usua1l}" var="usual" >
            <form>                           
                <div class="row">                    
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value="<c:out value="${usual.nombre}"/>"><c:out value="${usual.nombre}"/></label>                        
                </div>
                          
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usual.apellido}"/></label>                        
                    </div>
                
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usual.cedula}"/></label>                        
                    </div>
                </div>     
                  
                    <h5 class="container">Fecha</h5>
            
            <div class="container">
                <div class="row">
                    <form>    
                    <input type="date" class="datepicker">
                    <input type="time" class="datepicker">
                </form>
                </div>    
            </div>  
             <center><button class="waves-effect waves-yellow btn black" type="submit" name="submit">Agregar</button></center>       
            </form>  
                    
            </c:forEach> 
            
            <h5 class="container">Fecha</h5>
            
            <div class="container">
                <div class="row">
                    <form>    
                    <input type="date" class="datepicker">
                    <input type="time" class="datepicker">
                </form>
                </div>    
            </div>    
               
            -->
            <script>
                document.addEventListener('DOMContentLoaded', function() {
                 var elems = document.querySelectorAll('.datepicker');
                 var instances = M.Datepicker.init(elems, options);
                    });

                // Or with jQuery

                 $(document).ready(function(){
               $('.datepicker').datepicker();
                 });
            </script>    
        
        </body>
    </html>

