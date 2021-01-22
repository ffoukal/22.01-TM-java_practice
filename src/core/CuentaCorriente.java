package core;

public class CuentaCorriente {

    private double saldo;
    private Integer numeroCuenta;

    public CuentaCorriente(){}
    public CuentaCorriente(CuentaCorriente cuenta){
        this.setNumeroCuenta(cuenta.getNumeroCuenta());
        this.setSaldo(cuenta.getSaldo());
    }
    public CuentaCorriente(double saldo, Integer numeroCuenta){
        this.setNumeroCuenta(numeroCuenta);
        this.setSaldo(saldo);
    }


    public void ingreso(double cantidad){
        this.saldo += cantidad;
    }
    public void egreso(double cantidad){
        if(this.saldo < cantidad) {
            //throw new Exception("Exception message");
            System.out.println("No tiene saldo suficiente");
        } else {
            this.saldo -= cantidad;
        }
    }
    public void reintegro(double cantidad){
        this.ingreso(cantidad);
    }

    public void transferencia(CuentaCorriente cuenta, double cantidad){
        if(this.saldo <= cantidad){
            System.out.println("No tiene saldo suficiente para la operacion");
        } else {
            this.egreso(cantidad);
            cuenta.ingreso(cantidad);
        }
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
