package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class principal {
	// ------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------
	private ArrayList<Persona> personas;

	// ------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------
	/**
	 * carga el Arraylist con todas las personas y los cheques encontrados en los
	 * archivos
	 * 
	 * @throws Exception - por si es generado algún error
	 */
	public principal() throws Exception {
		personas = new ArrayList<Persona>();
		cargarPersonas("src/data/usuarios.txt");
		cargarCheques("src/data/Cheques.txt");
	}

	// ------------------------------------------------------------------------------
	// Métodos
	// ------------------------------------------------------------------------------
	/**
	 * buscar a una persona por nombre,apellido,fecha de nacimiento,identificación.
	 * @param sNombre - nombre de la persona a buscar	
	 * @param sApellido - apellido de la persona a buscar
	 * @param sFechaNacimento - fecha de nacimiento de la persona a buscar
	 * @param sIdentificacion - numero de identificación de la persona a buscar
	 * @return null si no la encuentra y la persona si la encuentra
	 */
	public Persona buscarPersona(String sNombre, String sApellido, String sFechaNacimento, String sIdentificacion) {
		Persona unaPersona = null;
		for (int i = 0; i < personas.size() && unaPersona == null; i++) {
			Persona sPersona = personas.get(i);
			if (sPersona.getNombre().equals(sNombre) && sPersona.getApellido().equals(sApellido)
					&& sPersona.getFnacimiento().equals(sFechaNacimento)) {
				unaPersona = sPersona;
			}
		}
		return unaPersona;

	}
	/**
	 * buscar persona solo por numero de identificación
	 * @param sIdentificacion - numero de identificación de la persona a buscar
	 * @return null si no la encuentra y la persona si la encuentra
	 */
	public Persona buscarPersona(String sIdentificacion) {
		Persona unaPersona = null;
		for (int i = 0; i < personas.size() && unaPersona == null; i++) {
			Persona sPersona = personas.get(i);
			if (sPersona.getIdentificacion().equals(sIdentificacion)) {
				unaPersona = sPersona;
			}
		}
		return unaPersona;

	}
	/**
	 * si la persona no se encuentra la adiciona
	 * @param unaPersona persona a adicionar o no
	 */
	private void adicionarPersona(Persona unaPersona) {
		if (buscarPersona(unaPersona.getNombre(), unaPersona.getApellido(), unaPersona.getFnacimiento(),
				unaPersona.getIdentificacion()) == null) {
			personas.add(unaPersona);
		}
	}
	/**
	 * cargar todas las personas leídas en el archivo
	 * @param archivo - ruta del archivo
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private void cargarPersonas(String archivo) throws Exception {
		Persona persona;
		BufferedReader lector;
		String texto, valores[], sNombre, sApellido, sFecha, sDireccion, sTelefono, sIdentificacion;
		double valor;

		try {
			File datos = new File(archivo);
			lector = new BufferedReader(new FileReader(datos));
			texto = lector.readLine();
		} catch (Exception e) {
			throw new Exception("Error al cargar los datos almacenados de usuarios");
		}

		while (texto != null) {
			// Si comienza con # es comentario
			if (!texto.startsWith("#") && !texto.equals("")) {
				// Lee los datos
				valores = texto.split(",");

				if (valores.length < 6) {
					throw new Exception("Faltan datos línea: " + texto);
				}

				sNombre = valores[0];
				sApellido = valores[1];
				sIdentificacion = valores[2];
				sFecha = valores[3];
				sDireccion = valores[4];
				sTelefono = valores[5];
				try {
					valor = Double.parseDouble(valores[6]);
				} catch (Exception e) {
					throw new Exception("El valor de precio debe ser numerico: " + valores[6]);
				}
				persona = new Persona(sNombre, sApellido, sFecha, sDireccion, sTelefono, valor, sIdentificacion);
				adicionarPersona(persona);
			}
			try {
				// siguiente linea
				texto = lector.readLine();
			} catch (Exception e) {
				throw new Exception("Error al cargar los datos almacenados de vehiculos");
			}
		}
	}
	/**
	 * cargar todos los cheques leídos en el archivo
	 * @param archivo - ruta del archivo
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private void cargarCheques(String archivo) throws Exception {
		Cheque cheque;
		String texto, valores[], sIndentificacion, sFecha, sDestinatario;
		int sNumero;
		double sConsignacion;
		BufferedReader lector;
		try {
			File datos = new File(archivo);
			lector = new BufferedReader(new FileReader(datos));
			texto = lector.readLine();
		} catch (Exception e) {
			throw new Exception("Error al cargar los datos almacenados de cheques de usuarios");
		}
		while (texto != null) {
			// Si comienza con # es comentario
			if (!texto.startsWith("#") && !texto.equals("")) {
				// Lee los datos
				valores = texto.split(",");

				if (valores.length < 5) {
					throw new Exception("Faltan datos línea: " + texto);
				}
				sIndentificacion = valores[0];
				sNumero = Integer.parseInt(valores[1]);
				sFecha = valores[2];
				sDestinatario = valores[3];
				sConsignacion = Double.parseDouble(valores[4]);
				for (int i = 0; i < personas.size(); i++) {
					Persona persona = personas.get(i);
					if (persona.getIdentificacion().equals(sIndentificacion)) {
						cheque = persona.buscarCheque(sIndentificacion);
						cheque = new Cheque(sFecha, sNumero, sConsignacion, sIndentificacion, sDestinatario);
						persona.AgregarCheque(cheque);
					}
				}

			}
			try {
				// siguiente linea
				texto = lector.readLine();
			} catch (Exception e) {
				throw new Exception("Error al cargar los datos almacenados de cheques de usuarios");
			}
		}
	}
	/**
	 * Reescribe en el archivo los cheques que se han realizado y lo anterior
	 * @param archivo - ruta del archivo
	 */
	public void EscribirCheques(String archivo) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(archivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < personas.size(); i++) {
			Persona persona = personas.get(i);
			for (int j = 0; j < persona.getCheques().size(); j++) {
				Cheque cheque = persona.getCheques().get(j);
				try {
					bw.write(cheque.toString() + "\n");
				} catch (IOException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	public void EscribirUsuarios(String archivo) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(archivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < personas.size(); i++) {
			Persona persona = personas.get(i);
			try {
				bw.write(persona.toString() + "\n");
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}

		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	/**
	 * Obtiene la fecha en tiempo real utilizando las librerias de java
	 * @return fecha actual
	 */
	public String getFecha() {
		java.util.Date utilDate = new java.util.Date(); // fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		String fecha = sqlDate.toString();
		fecha = fecha.replace("-", "/");
		return fecha;
	}
}
