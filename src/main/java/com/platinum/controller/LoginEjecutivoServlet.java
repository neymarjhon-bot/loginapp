package com.platinum.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginEjecutivoServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/if0_40472261_basededato",
                "root",
                ""
            );

            PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM ejecutivo WHERE rutEjecutivo = ?"
            );
            ps.setString(1, rut);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "RUT incorrecto");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            cn.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
