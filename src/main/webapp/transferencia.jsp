<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transferencia</title>
</head>
<body>

<h2>Realizar Transferencia</h2>

<form action="TransferenciaServlet" method="post">

    <label>ID Cuenta Origen:</label>
    <input type="number" name="idCuenta" required><br>

    <label>RUT Cliente:</label>
    <input type="text" name="rutCliente" required><br>

    <label>RUT Dueño Cuenta:</label>
    <input type="text" name="rutDueno" required><br>

    <label>Monto a Transferir:</label>
    <input type="number" step="0.01" name="monto" required><br>

    <label>Cuenta Destino:</label>
    <input type="text" name="cuentaDestino" required><br>

    <label>Tipo Cuenta:</label>
    <select name="tipoCuenta" required>
        <option value="Ahorro">Ahorro</option>
        <option value="Corriente">Corriente</option>
    </select><br><br>

    <button type="submit">Realizar Transferencia</button>
</form>

<%  
    if(request.getAttribute("msg") != null){
        out.println("<p>"+ request.getAttribute("msg") +"</p>");
    }
%>

</body>
</html>
