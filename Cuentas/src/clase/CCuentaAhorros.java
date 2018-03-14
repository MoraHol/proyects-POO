package clase;

public class CCuentaAhorros extends CCuenta {
	// Atributos
	private double cuotaManteniminento;

	// Metodos
	public CCuentaAhorros() {
	} // constructor sin parametros

	public CCuentaAhorros(String nom, String cue, double sal, double tipo, double cuotaManteniminento) {
		super(nom, cue, sal, tipo); // invoca al constructor CCuenta de la clase base
		this.cuotaManteniminento = cuotaManteniminento;
	}

	public void asignarCoutaManten(double cantidad) {
		if (cantidad < 0) {
			System.out.println("Error: cantidad negativa");
			return;
		}
		cuotaManteniminento = cantidad;
	}

	public double obtenerCuotaManten() {
		return this.cuotaManteniminento;
	}

	public void reintegro(double cantidad) {
		double saldo = estado();
		double TipoDeInteres = obtenerTipoDeInteres();
		if (TipoDeInteres >= 3.5) {
			if (saldo - cantidad < 1500) {
				System.out.println("Error: no dispone de esa cantidad");
				return;
			}
			super.reintegro(cantidad);// Método reintegro de la clase base,
										// tambien llamada superclase
		}
	}
}
