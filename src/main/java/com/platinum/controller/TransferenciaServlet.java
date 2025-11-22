package com.platinum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.platinum.dao.CuentaDAO;

@WebServlet("/TransferenciaServlet")
public class TransferenciaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rutCliente = request.getParameter("rutCliente");
        int monto = Integer.parseInt(request.getParameter("monto"));
        String ejecutivo = request.getParameter("ejecutivo");

        CuentaDAO dao = new CuentaDAO();
        boolean ok = dao.realizarTransferencia(rutCliente, monto, ejecutivo);

        if (ok) {
            request.setAttribute("mensaje", "Transferencia realizada con éxito");
        } else {
            request.setAttribute("mensaje", "Error en la transferencia");
        }

        request.getRequestDispatcher("transferencia.jsp").forward(request, response);
    }
}

