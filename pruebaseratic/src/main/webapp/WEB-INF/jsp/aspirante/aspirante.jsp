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
            <title>Aspirante</title>
            </head>
        <body>
             <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="home.htm" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                     <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <!-- <li><a href="user.htm"><span class="lime-text text-accent-2">Usuario1</span></a></li>-->
                        <li><a href="user.htm"><span class="lime-text text-accent-2">Usuarios</span></a></li>
                        <li><a href="player.htm"><span class="lime-text text-accent-2">Aspirantes</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Pruebas</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Reportes</span></a></li>
                    </ul>
                </div>
                 
            </nav>
            
            <!--Buscar -->
         <!-- <nav>
  
            <div class="nav-wrapper">
                <form name="ejemplo" action="buscarUser.htm" method="POST">
                    <div class="input-field">
                        Ingrese la cedula del usuario: <input type="search" name="cedula1"><br>
                        <input type="submit" value="Buscar">
                    </div>    
                </form>
            </div>
          </nav>    -->
                <h2 class="center"><span class="yellow-text text-darken-4">Gestión de Usuarios</span></h2>
                    <div class="container"> 
                     <table id="tabla" class="highlight centered responsive-table">
                         <thead>
                            <tr>
                              <th>Cedula</th>
                              <th>Nombre</th>
                              <th>Carrera</th>
                              <th>Telefono</th>
                              <th>Correo</th>
                              <th>Acciones</th>
                              <th></th>
                            </tr>

                         </thead>
                         
                         <tbody>
                            <c:forEach items="${aspirantes}" var="aspirante" >
                                <tr>
                            <td><c:out value="${aspirante.cedula}"/></td>
                            <td><c:out value="${aspirante.nombre}"/></td>
                            
                            <td><c:out value="${aspirante.carrera}"/></td>
                            <td><c:out value="${aspirante.telefono}"/></td>
                            <td><c:out value="${aspirante.correo}"/></td>
                                                    
                            <td> 
                                <a  href="<c:url value="editaspirante.htm?id=${aspirante.cedula}"/> "> <i class="material-icons right">edit</i></a>
                                <a href="<c:url value="delaspirante.htm?id=${aspirante.cedula}"/>" ><i class="material-icons right">delete</i></a>
                            </td>
                            </tr>    
                            </c:forEach>    
                         </tbody>
                         
                         </table>
                 </div>
                     
                                 
            <div class="row">
                <!--<div class="col s12"-->
                    <a href="addaspirante.htm" class="btn large waves-effect waves-light btn"><i class="material-icons right">add_circle</i>Adicionar</a> 
                <!--</div>    -->
            </div>        
        </body>
    </html>
