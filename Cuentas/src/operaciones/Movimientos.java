package operaciones;

import java.util.Random;

public class Movimientos {
	Random rd = new Random();

	public double retiro(double valor, double saldo) {
		if (valor > saldo) {
			System.err.println("el proceso no se pudo completar por falta de fondos");
			return 0;
		} else {
			System.out.println("Su valor de su cuenta ahora es: " + (saldo - valor));
			return saldo - valor;
		}

	}

	public double ingreso(double valor, double saldo) {
		System.out.println("Su valor de su cuenta ahora es: " + (saldo + valor));
		return saldo + valor;
	}

	public double setInteres() {
		return rd.nextInt(3) + rd.nextDouble();
	}

	public void mostarSaldo(double saldo) {
		System.out.println("Su cuenta tiene: $" + saldo);
	}

	public double setValor() {
		return rd.nextInt(500000) + 500000;

	}

}
