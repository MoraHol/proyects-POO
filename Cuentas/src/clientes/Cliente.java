package clientes;

public class Cliente {
	private String Nombre;
	private String Cuenta;
	private double valor;
	private double interes;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCuenta() {
		return Cuenta;
	}

	public void setCuenta(String cuenta) {
		Cuenta = cuenta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public Cliente(String nombre, String cuenta, double valor, double interes) {
		this.Nombre = nombre;
		this.Cuenta = cuenta;
		this.valor = valor;
		this.interes = interes;
		System.out.println("la persona se ha registrado.");
	}
	

}
