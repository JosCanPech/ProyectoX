package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Movimientos.*;

/**
 *
 * @author octav
 */
public class MovimientoDAO implements Movimiento {

    private static final String URL = "jdbc:mysql://localhost:3306/banco_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    public double Transferencia(Movimientos.Transferencia transferencia, double saldo) {
        try {
            // Intentar conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            if (transferencia.getSaldo() <= saldo) {
                double SaldoOrigen = this.RestarSaldo(saldo, transferencia.getSaldo());
                String sql = "SELECT Saldo FROM Cuentas WHERE NoCuenta = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, transferencia.getNocuentaDestino());
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    double SaldoOriginalDestino = rs.getDouble("Saldo");
                    double SaldoNuevoDestino = this.SumarSaldo(SaldoOriginalDestino, transferencia.getSaldo());

                    sql = "UPDATE Cuentas SET Saldo = ? WHERE NoCuenta = ?";

                    // Preparar la sentencia
                    pstmt = con.prepareStatement(sql);
                    pstmt.setDouble(1, SaldoOrigen); // primer parámetro: nuevo saldo
                    pstmt.setInt(2, transferencia.getNocuenta());// segundo parámetro: número de cuenta

                    // Ejecutar la actualización
                    pstmt.executeUpdate();
                    
                    sql = "UPDATE Cuentas SET Saldo = ? WHERE NoCuenta = ?";

                    // Preparar la sentencia
                    pstmt = con.prepareStatement(sql);
                    pstmt.setDouble(1, SaldoNuevoDestino); // primer parámetro: nuevo saldo
                    pstmt.setInt(2, transferencia.getNocuentaDestino());// segundo parámetro: número de cuenta

                    // Ejecutar la actualización
                    pstmt.executeUpdate();
                    
                    return SaldoOrigen;
                }

            }
        } catch (SQLException e) {

        }
        return saldo;
    }

    @Override
    public double Retiro(Movimientos.Retiro retiro, double saldo) {
        try {
            // Intentar conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            if (retiro.getSaldo() <= saldo) {
                double NuevoSaldo = this.RestarSaldo(saldo, retiro.getSaldo());

                // Consulta SQL con parámetro
                String sql = "UPDATE cuentas SET Saldo = ? WHERE NoCuenta = ?";

                // Preparar la sentencia
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setDouble(1, NuevoSaldo); // primer parámetro: nuevo saldo
                pstmt.setInt(2, retiro.getNoCuenta());// segundo parámetro: número de cuenta

                // Ejecutar la actualización
                pstmt.executeUpdate();

                return NuevoSaldo;
            }
        } catch (SQLException e) {

        }
        return saldo;
    }

    @Override
    public DatosSesion Consulta(int NoCuenta, String Contraseña) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            // 1. Verificar contraseña
            String sql = "SELECT Contraseña FROM usuarios WHERE NoCuenta = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, NoCuenta);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String consultaContraseña = rs.getString("Contraseña");
                if (consultaContraseña.equals(Contraseña)) {

                    // 2. Obtener nombre
                    sql = "SELECT Nombre FROM usuarios WHERE NoCuenta = ?";
                    pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, NoCuenta);
                    rs = pstmt.executeQuery();
                    String nombre = rs.next() ? rs.getString("Nombre") : "Desconocido";

                    // 3. Obtener saldo
                    sql = "SELECT Saldo FROM cuentas WHERE NoCuenta = ?";
                    pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, NoCuenta);
                    rs = pstmt.executeQuery();
                    double saldo = rs.next() ? rs.getDouble("Saldo") : 0.0;

                    DatosSesion datos = new DatosSesion(NoCuenta, saldo, nombre);
                    return datos;
                }
            }
        } catch (SQLException e) {

        }

        return null;
    }

    public double RestarSaldo(double saldo, double costo) {
        return saldo - costo;
    }

    public double SumarSaldo(double saldo, double agregado) {
        return saldo + agregado;
    }

}
