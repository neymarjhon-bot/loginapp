<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Inicio - My Construction</title>
</head>
<body>
    <h2>Bienvenido, <%= session.getAttribute("username") %>!</h2>
    <p>Has iniciado sesión correctamente.</p>
    <a href="login.jsp">Cerrar sesión</a>
</body>
</html>
