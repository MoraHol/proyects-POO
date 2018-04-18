package mundo;

import java.util.ArrayList;

public class Persona {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	private String nombre;
	private String apellido;
	private String fnacimiento;
	private String Direccion;
	private String Telefono;
	private String Identificacion;
	private double Saldo;
	// private ArrayList cheques;
	private ArrayList<Cheque> cheques;

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

	public String getIdentificacion() {
		return Identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFnacimiento() {
		return fnacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public double getSaldo() {
		return Saldo;
	}

	public ArrayList<Cheque> getCheques() {
		return cheques;
	}

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

	public Cheque buscarCheque(String Numero) {
		Cheque cheque = null;
		for (int i = 0; i < cheques.size() && cheque == null; i++) {
			Cheque chequeAux = cheques.get(i);
			if (chequeAux.getNumero()== Integer.parseInt(Numero)) {
				cheque = chequeAux;
			}
		}
		return cheque;
	}

	public void AgregarCheque(Cheque unCheque) {
		if (buscarCheque(unCheque.getNumero()) == null) {
			cheques.add(unCheque);
		}
	}

	public double generarCheque(double monto) {
		if (monto > Saldo) {
			return -1;
		} else {
			return Saldo -= monto;
		}
	}

	public double consignar(double monto) {
		return Saldo += monto;
	}
	@Override
	public String toString() {
		return nombre+","+apellido+","+Identificacion+","+fnacimiento+","+Direccion+","+Telefono+","+Double.toString(Saldo);	
	}
}
