package com.platinum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.platinum.model.Ejecutivo;

public class EjecutivoDAO {

    public Ejecutivo validarEjecutivo(String rut, String nombre) {
        Ejecutivo ej = null;

        try {
            Connection cn = ConexionBD.getConexion();
            String sql = "SELECT * FROM ejecutivo WHERE rut = ? AND nombre = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ej = new Ejecutivo();
                ej.setId(rs.getInt("id"));
                ej.setRut(rs.getString("rut"));
                ej.setNombre(rs.getString("nombre"));
                ej.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ej;
    }
}
