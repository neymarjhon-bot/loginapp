<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro Persona y Mascota</title>
</head>
<body>

<h2>Registro de Persona</h2>

<form action="RegistroPersonaServlet" method="post">

    <label>RUT:</label>
    <input type="text" name="rut" required><br>

    <label>Nombre:</label>
    <input type="text" name="nombre" required><br>

    <label>Apellido:</label>
    <input type="text" name="apellido" required><br>

    <label>Dirección:</label>
    <input type="text" name="direccion" required><br>

    <label>Correo:</label>
    <input type="email" name="correo" required><br>

    <label>Teléfono:</label>
    <input type="text" name="telefono" required><br>

    <h3>Datos Mascota</h3>

    <label>Nombre Mascota:</label>
    <input type="text" name="mascota" required><br><br>

    <button type="submit">Registrar</button>
</form>

<%  
    if(request.getAttribute("msg") != null){
        out.println("<p style='color:green;'>"+ request.getAttribute("msg") +"</p>");
    }
%>

</body>
</html>
