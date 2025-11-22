package com.platinum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.platinum.dao.PersonaDAO;
import com.platinum.model.Persona;

@WebServlet("/RegistroPersonaServlet")
public class RegistroPersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String mascota = request.getParameter("mascota");

        Persona p = new Persona(rut, nombre, apellido, direccion, correo, telefono, mascota);

        PersonaDAO dao = new PersonaDAO();
        boolean exito = dao.registrarPersona(p);

        if (exito) {
            request.setAttribute("mensaje", "Registro exitoso");
        } else {
            request.setAttribute("mensaje", "Error al registrar");
        }

        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
}
