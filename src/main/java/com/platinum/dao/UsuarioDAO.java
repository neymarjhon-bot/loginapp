package com.platinum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.platinum.model.Usuario;

public class UsuarioDAO {

    public Usuario validarLogin(String nombreUsuario, String password) {

        Usuario user = null;

        try (Connection cn = ConexionBD.getConexion()) {

            if (cn == null) {
                System.out.println("❌ Error: No hay conexión a la base de datos");
                return null;
            }

            String sql = "SELECT id, nombreUsuario, password FROM usuario WHERE nombreUsuario=? AND password=?";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, nombreUsuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setPassword(rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
