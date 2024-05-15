<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilos.css">
    </head>
    <body>
        <div class="datos">

            <h3>SEGUNDO PARCIAL TEM-742</h3>
            <h3>Nombre: PAOLA PEREZ QUISPE</h3>
            <h3>Carnet: 15413327 LP</h3>

        </div>
        <h1 >Registro Día del Internet</h1>
        <p><a href="Inicio?action=add">Nuevo</a></p>

        <table border="1" class="tablac">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Seminario</th>
                <th>Confirmado</th>
                <th>Fecha</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="estudiante" items="${estudiantes}">
                <tr>
                    <td>${estudiante.id}</td>
                    <td>${estudiante.nombres}</td>
                    <td>${estudiante.apellidos}</td>
                    <td>${estudiante.seminario}</td>
                    <td><input type= "checkbox" ${estudiante.confirmado == 1 ? 'checked': ''} disabled /></td>
                    <td>${estudiante.fecha}</td>
                    <td><a href="Inicio?action=edit&id=${estudiante.id}">Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${estudiante.id}" onclick="return confirm('¿Está seguro de eliminar este estudiante?')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
