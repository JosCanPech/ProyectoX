package Movimientos;

public class DatosSesion {

    private int NoCuenta;
    private double Saldo;
    private String Nombre; 

    public DatosSesion(int NoCuenta,String Nombre) {
        this.NoCuenta = NoCuenta;
        this.Nombre = Nombre;
    }
    
    public DatosSesion(int NoCuenta, double Saldo, String Nombre) {
        this.NoCuenta = NoCuenta;
        this.Nombre = Nombre;
        this.Saldo = Saldo;
    }

    public void setNoCuenta(int NoCuenta) {
        this.NoCuenta = NoCuenta;
    }
    
    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public int getNoCuenta() {
        return NoCuenta;
    }
    
    public String getNombre(){
        return Nombre;
    }

    public double getSaldo() {
        return Saldo;
    }

}
