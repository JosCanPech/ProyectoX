package Movimientos;

public class Transferencia {
    private final String TipoMovimiento;
    private double Saldo;
    private int Nocuenta;
    private int NocuentaDestino;

    public Transferencia(double Saldo, int Nocuenta, int NocuentaDestino) {
        this.TipoMovimiento = "Transferencia";
        this.Saldo = Saldo;
        this.Nocuenta = Nocuenta;
        this.NocuentaDestino = NocuentaDestino;
    }
    
    

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public double getSaldo() {
        return Saldo;
    }

    public int getNocuenta() {
        return Nocuenta;
    }

    public int getNocuentaDestino() {
        return NocuentaDestino;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public void setNocuenta(int Nocuenta) {
        this.Nocuenta = Nocuenta;
    }

    public void setNocuentaDestino(int NocuentaDestino) {
        this.NocuentaDestino = NocuentaDestino;
    }
    
}
