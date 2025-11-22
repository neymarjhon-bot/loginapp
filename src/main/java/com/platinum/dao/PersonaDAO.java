package com.platinum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.platinum.model.Persona;

public class PersonaDAO {

    public boolean registrarPersona(Persona p) {

        try (Connection cn = ConexionBD.getConexion()) {

            String sql = "INSERT INTO personas (nombre, apellido, correo, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
