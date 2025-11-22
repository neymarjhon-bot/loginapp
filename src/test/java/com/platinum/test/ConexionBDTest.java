package com.platinum.test;

import static org.junit.Assert.assertNotNull;
import java.sql.Connection;
import org.junit.Test;
import com.platinum.dao.ConexionBD;

public class ConexionBDTest {

    @Test
    public void testConexionBD() {
        Connection con = ConexionBD.getConexion();
        assertNotNull("La conexión debe ser exitosa", con);
        System.out.println("Conexión exitosa a la base de datos");
    }
}
