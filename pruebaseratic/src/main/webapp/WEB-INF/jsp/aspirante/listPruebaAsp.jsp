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
            <title>lista prueba individual</title>
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
           
            <div class="container">
             <div class="nav-wrapper">
                <form name="ejemplo" action="listPruebaAsp.htm" method="POST">
                    <div class="input-field">
                        <i class="material-icons">search</i>Ingrese la cedula del aspirante: <input type="search" name="cedula1"><br>
                       
                        <input type="submit" value="Buscar">
                    </div>    
                </form>
                </div>
            </div>    
                 
         <h2 class="center"><span class="yellow-text text-darken-4">Lista de pruebas realizadas</span></h2>
                    <div class="container"> 
                     <table id="tabla" class="highlight centered responsive-table">
                         <thead>
                            <tr>
                              <th>id</th>
                              <th>Cedula Aspirante</th>
                              <th>Nombre Aspirante</th>
                              <th>Carrera</th>
                              <th>Cedula Evaluador </th>
                              <th>Detales </th>
                              <th>Calificacion </th>
                              <th>Fecha de Registro</th>
                              <th></th>
                            </tr>

                         </thead>
                         
                         <tbody>
                            <c:forEach items="${pruebas}" var="pruebas" >
                                <tr>
                            <td><c:out value="${pruebas.id}"/></td>
                            <td><c:out value="${pruebas.cedulaAs}"/></td>
                            <td><c:out value="${pruebas.nombreA}"/></td>
                            <td><c:out value="${pruebas.carreraA}"/></td>
                            <td><c:out value="${pruebas.cedulaE}"/></td>
                            <td><c:out value="${pruebas.nombreE}"/></td>
                            <td><c:out value="${pruebas.detalle}"/></td>
                            <td><c:out value="${pruebas.calificacion}"/></td>
                            <td><c:out value="${pruebas.fecha}"/></td>
                            
                            </tr>    
                            </c:forEach>    
                         </tbody>
                         
                         </table>
                 </div>
                     
                                 
            <div class="row">
                <!--<div class="col s12"-->
                    <a href="homePrueba.htm" class="btn large waves-effect waves-light btn"><i class="material-icons right">add_circle</i>retornar</a> 
                <!--</div>    -->
            </div>  
        </body>
    </html>

