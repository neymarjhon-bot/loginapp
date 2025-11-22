<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Ejecutivo</title>
</head>
<body>

<h2>Inicio de Sesión - Ejecutivo</h2>

<form action="LoginEjecutivoServlet" method="post">
    <label>RUT Ejecutivo:</label>
    <input type="text" name="rut" required>

    <button type="submit" name="btnLogin">Ingresar</button>
</form>

<%  
    if(request.getAttribute("error") != null){
        out.println("<p style='color:red;'>"+ request.getAttribute("error") +"</p>");
    }
%>

</body>
</html>
