package com.platinum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.platinum.model.CuentaCorriente;

public class CuentaDAO {

    public CuentaCorriente obtenerCuenta(int usuarioId) {

        CuentaCorriente cuenta = null;

        try (Connection cn = ConexionBD.getConexion()) {

            String sql = "SELECT * FROM cuenta_corriente WHERE usuario_id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, usuarioId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cuenta = new CuentaCorriente();
                cuenta.setId(rs.getInt("id"));
                cuenta.setUsuarioId(rs.getInt("usuario_id"));
                cuenta.setSaldo(rs.getDouble("saldo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cuenta;
    }

    public boolean actualizarSaldo(int idCuenta, double nuevoSaldo) {

        try (Connection cn = ConexionBD.getConexion()) {

            String sql = "UPDATE cuenta_corriente SET saldo=? WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDouble(1, nuevoSaldo);
            ps.setInt(2, idCuenta);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean realizarTransferencia(String rutCliente, int monto, String ejecutivo) {

        try (Connection cn = ConexionBD.getConexion()) {

            String sql = "UPDATE cuenta_corriente SET saldo = saldo - ?, ejecutivo = ? WHERE rutCliente = ?";
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, monto);
            ps.setString(2, ejecutivo);
            ps.setString(3, rutCliente);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
