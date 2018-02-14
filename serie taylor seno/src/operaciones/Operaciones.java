package operaciones;

public class Operaciones {
	/**
	 * 
	 * @param terminos
	 * @param x
	 * @return
	 */
	public static double serie_taylor_seno(int terminos, double x) {
		double signo = 1, dividendo, divisor, seno = 0;
		int n;

		for (n = 0; n <= terminos; n++) {
			
			dividendo = potencia(x, 2 * n + 1);
			divisor = factorial_de_numero(2 * n + 1);
			
			if (n % 2 == 0) {
				signo = 1;
			} else {
				signo = -1;
			}
			seno += (dividendo / divisor) * signo;
		}
		return seno;
	}

	public static double factorial_de_numero(int numero) {
		double factorial = 1;

		while (numero != 0) {
			factorial *= numero;
			numero--;
		}
		return factorial;
	}

	public static double potencia(double x, int exponente) {
		double resultado = 1;

		if (exponente == 0) {
			resultado = 1;
		} else if (exponente == 1) {
			resultado = x;
		} else if (exponente > 1) {
			resultado = pow(x, exponente);
			//resultado = Math.pow(x, exponente);
		} else if (exponente < 0) {
			resultado = 1 / pow(x, exponente * (-1));
			//resultado = 1 / Math.pow(x, exponente * (-1));
		}
		return resultado;
	}

	public static double pow(double x, int exponente) {
		double resultado = 1;
		for (int i = 1; i <= exponente; i++) {
			resultado *= x;
			
		}
		return resultado;
	}
}
