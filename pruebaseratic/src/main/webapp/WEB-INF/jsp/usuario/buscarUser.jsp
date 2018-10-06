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
            
            <h2 class="center"><span class="yellow-text text-darken-4">Asignar Cita</span></h2>
            <div class="container"> 
                     <table id="tabla" class="highlight centered responsive-table">
                         <thead>
                            <tr>
                              <th>Cedula</th>
                              <th>Nombre</th>
                              <th>Apellido</th>
                              <th>Usuario</th>
                              <th>Clave</th>
                              <th>Tipo</th>
                              <th>Fecha de Registro</th>
                              <th>Acciones</th>
                              <th></th>
                            </tr>

                         </thead>
                         
                         <tbody>
                            <c:forEach items="${usua}" var="usuarios" >
                                <tr>
                            <td><c:out value="${usuarios.cedula}"/></td>
                            <td><c:out value="${usuarios.nombre}"/></td>
                            <td><c:out value="${usuarios.apellido}"/></td>
                            <td><c:out value="${usuarios.usuario}"/></td>
                            <td><c:out value="${usuarios.clave}"/></td>
                            <td><c:out value="${usuarios.tipo}"/></td>
                            <td><c:out value="${usuarios.fecha}"/></td>
                            <br></br>
                            <td> 
                                <a href="user.htm" class="waves-effect waves-light btn"><i class="material-icons left">assignment</i>Asignar cita</a>
                             
                            </td>
                            </tr>    
                            </c:forEach>    
                         </tbody>
                         
                         </table>
                 </div>
            
            <c:forEach items="${usua}" var="usua" >
            <form>                           
                <div class="row">                    
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value="<c:out value="${usua.nombre}"/>"><c:out value="${usua.nombre}"/></label>                        
                    </div>
                 
                                       
                
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usua.apellido}"/></label>                        
                    </div>
                
                    
                
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usua.cedula}"/></label>                        
                    </div>
                </div>     
            </form>  
                    
            </c:forEach>    
            
            <c:forEach items="${usua1}" var="usua1" >
            <form>                           
                <div class="row">                    
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value="<c:out value="${usua1.nombre}"/>"><c:out value="${usua1.nombre}"/></label>                        
                    </div>
                 
                                       
                
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usua1.apellido}"/></label>                        
                    </div>
                
                    
                
                    <div class="input-field col s4">
                        <i class="material-icons prefix">person</i>
                        <input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true" disabled/>
                        <label for="icon_prefix" path="nombre" value=""><c:out value="${usua1.id}"/></label>                        
                    </div>
                </div>     
            </form>  
            </c:forEach>     
            
            <!--<div class="row">
            <ul id="dropdown2" class="dropdown-content">
            <li><a href="#!">one<span class="badge">1</span></a></li>
            <li><a href="#!">two<span class="new badge">1</span></a></li>
            <li><a href="#!">three</a></li>
            </ul>
            <a class="btn dropdown-trigger" href="#!" data-target="dropdown2">Dropdown<i class="material-icons right">arrow_drop_down</i></a>
            </div>   
            
            <!--<div class="row">
                <!--<div class="col s12"-->
                <!--    <a href="adduser.htm" class="btn large waves-effect waves-light btn"><i class="material-icons right">add_circle</i>Agregar</a> 
                <!--</div>    -->
                   
        </body>
    </html>



