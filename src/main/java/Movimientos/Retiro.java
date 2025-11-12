package Movimientos;

public class Retiro {
    private final String TipoMovimiento;
    private int NoCuenta;
    private double Saldo;

    public Retiro(int NoCuenta, double Saldo) {
        this.TipoMovimiento = "Retiro";
        this.NoCuenta = NoCuenta;
        this.Saldo = Saldo;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public int getNoCuenta() {
        return NoCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setNoCuenta(int NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
}
