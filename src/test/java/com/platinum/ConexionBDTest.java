package com.platinum;



import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class ConexionBDTest {

    @Test
    public void testConexionBD() {
        Connection cn = null;

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con Laragon
            cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/if0_40472261_basededato",
                "root",
                ""     // contraseña VACÍA en Laragon
            );

            // Validar la conexión
            assertNotNull("La conexión es nula. MySQL no está corriendo o los datos están mal.", cn);

            System.out.println("✔ Conexión a la base de datos exitosa.");

        } catch (Exception e) {
            e.printStackTrace();
            fail("❌ Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
