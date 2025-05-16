package servicio;

import modelo.CuentaBancaria;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<CuentaBancaria> cuentas = new ArrayList<>();

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public void borrarCuenta(CuentaBancaria cuenta) {
        cuentas.remove(cuenta);
    }

    public void modificarCuenta(CuentaBancaria cuenta) {
        cuentas.set(cuentas.indexOf(cuenta), cuenta);
    }

    public void mostrarCuentas() {
        for (CuentaBancaria cuenta : cuentas) {
            cuenta.imprimir();
            System.out.println("-----------------");
        }
    }
}
