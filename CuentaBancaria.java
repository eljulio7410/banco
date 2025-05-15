public class CuentaBancaria {
    //  atributos privados
    private String numeroCuenta;
    private String titular;
    private double saldo;
    //    constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }
    //    metodo publico depositar
    public void depositar(double valor) {
        this.saldo += valor;
    }
    //    metodo publico retirar
    public void retirar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        }else {
            System.out.println("Saldo insuficiente");
        }
    }
    //    metodo mostrar saldo
    public void imprimir() {
        System.out.println("Numero Cuenta: " + this.numeroCuenta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("-----------------");
    }
    //    transferir saldo
    public void transferir(CuentaBancaria destino, double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.println("transferencia de $ " + valor + " realizada a la cuenta de " + destino.titular);
        }else {
            System.out.println("Saldo insuficiente");
        }
    }
}
