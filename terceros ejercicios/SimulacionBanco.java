
class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}


class CuentaBancaria {
    private double saldo;


    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }


    public void retirar(double cantidad) throws FondosInsuficientesException {
        if (cantidad > saldo) {
            throw new FondosInsuficientesException("Fondos insuficientes. Saldo actual: " + saldo);
        }
        saldo -= cantidad;
        System.out.println("Retiro exitoso. Saldo restante: " + saldo);
    }

 
    public double getSaldo() {
        return saldo;
    }
}


public class SimulacionBanco {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000.0); 

        try {
  
            cuenta.retirar(500.0); 
            cuenta.retirar(600.0); 
        } catch (FondosInsuficientesException e) {
         
            System.out.println("Error: " + e.getMessage());
        }
    }
}
