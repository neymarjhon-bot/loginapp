package com.platinum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.platinum.dao.EjecutivoDAO;
import com.platinum.model.Ejecutivo;

@WebServlet("/LoginEjecutivoServlet")
public class LoginEjecutivoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("usuario");
        String nombre = request.getParameter("password");

        EjecutivoDAO dao = new EjecutivoDAO();
        Ejecutivo ej = dao.validarEjecutivo(rut, nombre);

        if (ej != null) {
            request.getSession().setAttribute("ejecutivo", ej);
            response.sendRedirect("menu.jsp");
        } else {
            request.setAttribute("error", "Credenciales incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
