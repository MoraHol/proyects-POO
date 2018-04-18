package mundo;

public class Cheque {
	private String fecha;
	private int numero ;
	private double cantidad;
	private String Identificaion;
	private String Destinatario;

	/**
	 * 
	 * @param fecha
	 * @param numero
	 * @param cantidad
	 * @param nombre
	 */
	public Cheque(String fecha, int numero, double cantidad, String identificacion, String destinatario) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.cantidad = cantidad;
		Identificaion = identificacion;
		Destinatario = destinatario;
	}

	public String getFecha() {
		return fecha;
	}

	public int getNumero() {
		return numero;
	}

	public double getCantidad() {
		return cantidad;
	}

	public String getIdentificacion() {
		return Identificaion;
	}
	public String getDestinatario() {
		return Destinatario;
	}

	public String tostring() {
		return Identificaion + "," + Integer.toString(numero) + "," + fecha + "," + Destinatario + ","
				+ Double.toString(cantidad);

	}

}
