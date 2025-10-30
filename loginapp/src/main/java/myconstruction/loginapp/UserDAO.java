package myconstruction.loginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/myconstruction";
    private String jdbcUsername = "root";
    private String jdbcPassword = "tu_contraseña";

    public boolean validate(String username, String password) {
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}