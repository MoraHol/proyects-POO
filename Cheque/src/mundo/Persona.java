package mundo;

import java.util.ArrayList;

public class Persona {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * nombre de la persona
	 */
	private String nombre;
	/**
	 * apellido de la persona
	 */
	private String apellido;
	/**
	 * fecha de nacimiento de la persona
	 */
	private String fnacimiento;
	/**
	 * Dirección de la persona
	 */
	private String Direccion;
	/**
	 * Teléfono de la persona
	 */
	private String Telefono;
	/**
	 * Numero de identificación de la persona
	 */
	private String Identificacion;
	/**
	 * saldo de la cuenta de la persona
	 */
	private double Saldo;
	/**
	 * cheques realizados por la persona
	 */
	private ArrayList<Cheque> cheques;

	// ----------------------------------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------------------------------
	/**
	 * Construye una persona con todos sus atributos
	 * 
	 * @param nombre
	 *            - nombre de la persona
	 * @param apellido
	 *            - apellido de la persona
	 * @param fnacimiento
	 *            - fecha de nacimiento de la persona
	 * @param direccion
	 *            - dirección de la persona
	 * @param telefono
	 *            - teléfono de la persona
	 * @param saldo
	 *            - saldo de la cuenta de esta persona
	 * @param identificacion
	 *            - numero de identificación de la persona
	 */
	public Persona(String nombre, String apellido, String fnacimiento, String direccion, String telefono, double saldo,
			String identificacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		Direccion = direccion;
		Telefono = telefono;
		Saldo = saldo;
		cheques = new ArrayList<Cheque>();
		Identificacion = identificacion;
	}
	// ----------------------------------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------------------------------

	/**
	 * devuelve la identificación de la persona
	 * 
	 * @return identificación de la persona
	 */
	public String getIdentificacion() {
		return Identificacion;
	}

	/**
	 * devuelve el nombre de la persona
	 * 
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * devuelve el apellido de la persona
	 * 
	 * @return apellido de la persona
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * devuelve la fecha de nacimiento de la persona
	 * 
	 * @return fecha de nacimiento de la persona
	 */
	public String getFnacimiento() {
		return fnacimiento;
	}

	/**
	 * devuelve la dirección de la persona
	 * 
	 * @return dirección de la persona
	 */
	public String getDireccion() {
		return Direccion;
	}

	/**
	 * devuelve le teléfono de la persona
	 * 
	 * @return teléfono de la persona
	 */
	public String getTelefono() {
		return Telefono;
	}

	/**
	 * devuelve el saldo en cuenta de la persona
	 * 
	 * @return saldo en cuenta de la persona
	 */
	public double getSaldo() {
		return Saldo;
	}

	/**
	 * devuelve los cheques realizados por la persona
	 * 
	 * @return cheques realizados por la persona
	 */
	public ArrayList<Cheque> getCheques() {
		return cheques;
	}

	/**
	 * busca un cheque por su numero
	 * 
	 * @param numero
	 *            - numero de cheque a buscar
	 * @return - null si no existe y cheque si existe
	 */
	public Cheque buscarCheque(int numero) {
		Cheque cheque = null;
		for (int i = 0; i < cheques.size() && cheque == null; i++) {
			Cheque chequeAux = cheques.get(i);
			if (chequeAux.getNumero() == numero) {
				cheque = chequeAux;
			}
		}
		return cheque;
	}

	/**
	 * devuelve los cheques realizados por la persona
	 * 
	 * @param numero
	 *            - numero de identificación de la persona a buscar
	 * @return cheques realizados por la persona
	 */
	public Cheque buscarCheque(String numero) {
		Cheque cheque = null;
		for (int i = 0; i < cheques.size() && cheque == null; i++) {
			Cheque chequeAux = cheques.get(i);
			if (chequeAux.getNumero() == Integer.parseInt(numero)) {
				cheque = chequeAux;
			}
		}
		return cheque;
	}

	/**
	 * agrega un cheque si este numero de cheque no esta creado
	 * 
	 * @param unCheque
	 *            - cheque que desea agregar
	 */
	public void AgregarCheque(Cheque unCheque) {
		if (buscarCheque(unCheque.getNumero()) == null) {
			cheques.add(unCheque);
		}
	}

	/**
	 * genera cheque y descuento el monto del cheque al saldo de la cuenta
	 * 
	 * @param monto
	 *            - monto a descontar
	 * @return - saldo menos el monto
	 */
	public double generarCheque(double monto) {
		if (monto > Saldo) {
			return -1;
		} else {
			return Saldo -= monto;
		}
	}

	/**
	 * al consignar se agregara el monto a al saldo de la cuenta
	 * 
	 * @param monto
	 *            - monto a sumar a la cuenta
	 * @return - saldo mas monto
	 */
	public double consignar(double monto) {
		return Saldo += monto;
	}

	@Override
	public String toString() {
		return nombre + "," + apellido + "," + Identificacion + "," + fnacimiento + "," + Direccion + "," + Telefono
				+ "," + Double.toString(Saldo);
	}
}
