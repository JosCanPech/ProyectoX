package DAO;
import Movimientos.*;

public interface Movimiento {
    
    public double Transferencia(Transferencia transferencia, double saldo);
    
    public double Retiro(Retiro retiro, double saldo);
    
    public DatosSesion Consulta(int NoCuenta, String Contraseña);
    
    
}
