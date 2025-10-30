<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - My Construction</title>
</head>
<body>
    <h2>Iniciar sesión</h2>

    <form action="login" method="post">
        <label>Usuario:</label>
        <input type="text" name="username" required><br><br>

        <label>Contraseña:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Ingresar">
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Usuario o contraseña incorrectos</p>
    <% } %>
</body>
</html>
