package habitaciones;

public class Habitacion {
	private String NumHAbitacion;
	private boolean diponibilidad;
	private double tarifa;
	private String cedula;
	
	
	public Habitacion(String numHAbitacion, boolean diponibilidad) {
		NumHAbitacion = numHAbitacion;
		this.diponibilidad = diponibilidad;
	}

	public String getNumHAbitacion() {
		return NumHAbitacion;
	}

	public void setNumHAbitacion(String numHAbitacion) {
		NumHAbitacion = numHAbitacion;
	}

	public boolean isDiponibilidad() {
		return diponibilidad;
	}

	public void setDiponibilidad(boolean diponibilidad) {
		this.diponibilidad = diponibilidad;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
}
