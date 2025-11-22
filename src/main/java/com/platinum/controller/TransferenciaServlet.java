package com.platinum.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class TransferenciaServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rutCliente = request.getParameter("rutCliente");
        String rutDuenio = request.getParameter("rutDuenio");
        int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
        double monto = Double.parseDouble(request.getParameter("monto"));
        String cuentaDestino = request.getParameter("cuentaDestino");
        String tipoCuenta = request.getParameter("tipoCuenta");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/if0_40472261_basededato",
                "root",
                ""
            );

            PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO transaccion (rutCliente, rutDueño, idCuenta, montoTransferencia, cuentaTransferencia, tipoCuenta) "
              + "VALUES (?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, rutCliente);
            ps.setString(2, rutDuenio);
            ps.setInt(3, idCuenta);
            ps.setDouble(4, monto);
            ps.setString(5, cuentaDestino);
            ps.setString(6, tipoCuenta);

            ps.executeUpdate();

            request.setAttribute("mensaje", "Transferencia realizada");
            request.getRequestDispatcher("transferencia.jsp").forward(request, response);

            cn.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

