<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mostrar usuarios</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1 class="encabezado">Usuarios ingresados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>Nombre usuario</th>
            <th>Rut</th>
            <th>Edad</th>
        </tr>
        <c:forEach items="${usuarios}" var="usuario">
            <tr>
                <td><c:out value="${usuario.getNombre()}"></c:out> </td>
                <td> <c:out value="${usuario.getRut()}"></c:out> </td>
                <td> <c:out value="${usuario.getEdad()}"></c:out> </td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>