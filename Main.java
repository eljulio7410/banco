import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CuentaBancaria cuenta1 = new CuentaBancaria("01", "Jose", 1500);
        CuentaBancaria cuenta2 = new CuentaBancaria("02", "David", 1000);

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

            switch (opcion) {
                case 1:
                    System.out.println("¿A que cuenta desea depositar? (1 o 2)");
                    int d = sc.nextInt();
                    System.out.println("indique el monto que desea depositar");
                    double montoD = sc.nextDouble();
                    if (d == 1) cuenta1.depositar(montoD);
                    else if (d == 2) cuenta2.depositar(montoD);
                    else System.out.println("cuenta invalida");
                    break;

                case 2:
                    System.out.println("¿A que cuenta desea retirar? (1 o 2)");
                    int r = sc.nextInt();
                    System.out.println("indique el monto que desea retirar");
                    double montoR = sc.nextDouble();
                    if (r == 1) cuenta1.retirar(montoR);
                    else if (r == 2) cuenta2.retirar(montoR);
                    else System.out.println("cuenta invalida");
                    break;

                case 3:
                    System.out.println("¿Desde que cuenta desea transferir? (1 o 2)");
                    int t = sc.nextInt();
                    System.out.println("indique el monto que desea transferir");
                    double montoT = sc.nextDouble();
                    if (t == 1) cuenta1.transferir(cuenta2, montoT);
                    else if (t == 2) cuenta2.transferir(cuenta1, montoT);
                    else System.out.println("cuenta invalida");
                    break;

                case 4:
                    cuenta1.imprimir();
                    cuenta2.imprimir();
                    break;

                case 5:
                    System.out.println("Gracias por usar el programa");
                    break;

                    default:
                        System.out.println("Opcion no valida");
            }
        } while (opcion != 5);
        sc.close();
    }
}
