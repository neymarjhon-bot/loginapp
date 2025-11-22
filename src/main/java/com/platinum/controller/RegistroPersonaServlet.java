package com.platinum.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class RegistroPersonaServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String mascota = request.getParameter("mascota");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/if0_40472261_basededato",
                "root",
                ""
            );

            PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO persona (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion);
            ps.setString(5, correo);
            ps.setString(6, telefono);
            ps.setString(7, mascota);

            ps.executeUpdate();

            request.setAttribute("mensaje", "Registro exitoso");
            request.getRequestDispatcher("registro.jsp").forward(request, response);

            cn.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
