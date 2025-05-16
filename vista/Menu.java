package vista;

import modelo.CuentaBancaria;
import servicio.Banco;

import java.util.Scanner;

public class Menu {
    private Banco banco = new Banco();
    private Scanner sc = new Scanner(System.in);

    public void mostrar(){
        cuentasEjemplo();

            int opcion;
            do {
                System.out.println("\n===MENU BANCO===");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Transferir");
                System.out.println("4. Mostrar informacion");
                System.out.println("5. Salir");
                System.out.println("Seleccione una opcion: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpia salto de linea

                switch (opcion) {
                    case 1:
                        realizarDeposito();
                    case 2:
                        realizarRetiro();
                    case 3:
                        realizarTransferencia();
                    case 4:
                        banco.mostrarCuentas();
                    case 5:
                        System.out.println("Gracias por usar el sistema");
                    default:
                        System.out.println("Opcion no valida");

                }
            } while (opcion != 5);
        }
        private void realizarDeposito(){
            System.out.println("Numero de cuenta: ");
                String numero = sc.nextLine();
                CuentaBancaria cuenta  = banco.buscarCuenta(numero);
                if (cuenta != null) {
                    System.out.println("Valor a depositar: ");
                    double valor = sc.nextDouble();
                    cuenta.depositar(valor);
                } else {
                    System.out.println("Cuenta no encontrada");
                }
        }

        private void realizarRetiro(){
            System.out.println("Numero de cuenta: ");
            String numero = sc.nextLine();
            CuentaBancaria cuenta  = banco.buscarCuenta(numero);
            if (cuenta != null) {
                System.out.println("Valor a retirar: ");
                double valor = sc.nextDouble();
                cuenta.retirar(valor);
            } else {
                System.out.println("Cuenta no encontrada");
            }

        }

        private void realizarTransferencia(){
        System.out.println("Cuenta Origen: ");
        String origen = sc.nextLine();
        CuentaBancaria cOrigen  = banco.buscarCuenta(origen);

        System.out.println("Cuenta Destino: ");
        String destino = sc.nextLine();
        CuentaBancaria cDestino = banco.buscarCuenta(destino);
        if (cOrigen != null && cDestino != null) {
            System.out.println("Valor a transferir: ");
            double valor = sc.nextDouble();
            cOrigen.transferir(cDestino, valor);
           } else {
            System.out.println("Una o ambas cuentas no existen");
        }
    }

    private void cuentasEjemplo() {
        banco.agregarCuenta(new CuentaBancaria("01", "Jose", 1500));
        banco.agregarCuenta(new CuentaBancaria("02", "David", 1000));
    }
}
