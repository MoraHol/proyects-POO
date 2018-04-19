package personas;

public class Persona {
	private String Nombre;
	private String direccion;
	private String Email;
	private String cedula;
	private String procedencia;
	private int NumHoras;
	
	public Persona(String nombre, String direccion, String email, String cedula, String procedencia, int numHoras) {
		super();
		Nombre = nombre;
		this.direccion = direccion;
		Email = email;
		this.cedula = cedula;
		this.procedencia = procedencia;
		NumHoras = numHoras;
	}
	

	public Persona(String cedula) {
		super();
		this.cedula = cedula;
	}


	public Persona() {
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public int getNumHoras() {
		return NumHoras;
	}

	public void setNumHoras(int numHoras) {
		NumHoras = numHoras;
	}

}
