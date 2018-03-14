package clase;

public class CCuenta {
	// Atributos son globales a la clase
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipoDeInteres;

	// Metodos
	// COnstructor
	public CCuenta() {
		System.out.println("Objeto CCuneta creado");
	}

	public CCuenta(String nombre, String cuenta, double saldo, double tipoDeInteres) {
		asignarNombre(nombre);
		this.cuenta = cuenta;
		this.saldo = saldo;
		this.tipoDeInteres = tipoDeInteres;
	}

	public void asignarNombre(String nom) {
		if (nom.length() == 0) {
			System.out.println("Error: cadena vacia");
			return;
		}
		nombre = nom;
	}

	public String ObtenerNombre() {
		return nombre;
	}

	public void asignarCuenta(String cue) {
		if (cue.length() == 0) {
			System.out.println("Error: cadena vacia");
			return;
		}
		this.cuenta = cue;
	}

	public String ObtenerCuenta() {
		return cuenta;
	}

	public double estado() {
		return saldo;
	}

	public void ingreso(double cantidad) {
		if (cantidad < 0) {
			System.out.println("Error: cantidad negativa");
			return;
		}
		saldo += cantidad;
	}

	public void reintegro(double cantidad) {
		if (saldo - cantidad < 0) {
			System.out.println("Error: no dispone de saldo");
			return;
		}
		saldo -= cantidad;
	}

	public void asignarTipoDeInteres(double tipo) {
		if (tipo < 0) {
			System.out.println("Error: tipo no válido");
			return;
		}
		tipoDeInteres = tipo;
	}

	public double obtenerTipoDeInteres() {
		return tipoDeInteres;
	}
}
