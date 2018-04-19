package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import habitaciones.Habitacion;
import personas.Persona;

public class Menu {
	Main mn = new Main();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean exit = true;

	/**
	 * muestra el menu de opciones
	 * 
	 * @return el valor escojido como punto a seguir
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public int mostar() throws NumberFormatException, IOException {
		System.out.println("Bienvenido que desea realizar:");
		System.out.println("1. Ingreso de persona \n" + "2. salida de persona \n" + "3. Habitaciones disponibles \n"
				+ "4. cabiar la tarifa del hotel \n" + "5. salir\n" + "Ingresa la opcion:");
		return Integer.parseInt(br.readLine());
	}

	/**
	 * toma la desicion de que es lo que se va a hacer
	 * 
	 * @param option
	 *            lo que el usuario quiere hacer
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void Parameters(int option) throws NumberFormatException, IOException {

		switch (option) {
		case 1:
			registrar();
			break;
		case 2:
			System.out.println("usted debe pagar: " + salida());
			break;
		case 3:
			System.out.println("las habitaciones disponibles son:");
			verificarDisponibilidad();
			break;
		case 4:
			System.out.println("ingrese la nueva tarifa:");
			double tarifa = Double.parseDouble(br.readLine());
			for (int i = 0; i < mn.hb.length; i++) {
				mn.hb[i].setTarifa(tarifa);
			}
			break;
		case 5:
			exit = false;
			break;
		}
	}

	/**
	 * este metdo pide todos los datos de una persona y crea el registro
	 * 
	 * @throws IOException
	 */
	public void registrar() throws IOException {
		mn.pr[Main.posicion] = new Persona();
		System.out.println("por favor Ingrese su nombre:");
		mn.pr[Main.posicion].setNombre(br.readLine());
		System.out.println("por favor Ingrese su direccion:");
		mn.pr[Main.posicion].setDireccion(br.readLine());
		System.out.println("por favor Ingrese su correo electronico:");
		mn.pr[Main.posicion].setEmail(br.readLine());
		System.out.println("por favor Ingrese su cedula:");
		mn.pr[Main.posicion].setCedula(br.readLine());
		System.out.println("por favor Ingrese su procedencia:");
		mn.pr[Main.posicion].setProcedencia(br.readLine());
		System.out.println("por favor Ingrese el numero de horas que va a estar:");
		mn.pr[Main.posicion].setNumHoras(Integer.parseInt(br.readLine()));
		System.out.println("en que habitacion se desea quedar");
		verificarDisponibilidad(Integer.parseInt(br.readLine()));

	}

	/**
	 * asigna el la habitacion a la persona y el numero de cedula
	 * 
	 * @param NumHabitacion
	 *            entra el numero de la habitacion donde se desea revisar
	 * @return si la habitacion esta o no ocupada
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public boolean verificarDisponibilidad(int NumHabitacion) throws NumberFormatException, IOException {
		boolean aux = false;
		for (int i = 0; i < mn.hb.length; i++) {
			if (Integer.parseInt(mn.hb[i].getNumHAbitacion()) == NumHabitacion - 1) {
				if (mn.hb[i].isDiponibilidad() == false) {
					aux = true;
				} else {
					aux = false;
				}
			}
		}
		if (aux) {
			System.out.println("Se ha asignado correctamente");
			mn.hb[NumHabitacion - 1].setCedula(mn.pr[Main.posicion].getCedula());
			mn.hb[NumHabitacion - 1].setDiponibilidad(true);
			return true;
		} else {
			System.out.println("Esta ocupada");
			System.out.println("en que habitacion se desea quedar");
			return verificarDisponibilidad(Integer.parseInt(br.readLine()));
		}

	}

	/**
	 * muestra todas las habitaciones que estan disponibles en una lista
	 */
	public void verificarDisponibilidad() {
		for (int i = 0; i < mn.hb.length; i++) {
			if (mn.hb[i].isDiponibilidad() == false) {
				System.out.print("- habitacion " + (i + 1) + "\n");
			}
		}
	}

	/**
	 * inicia los registros: el numero de la habitacion a cada una y ademas
	 * inicializa una primera tarifa e inicializa todas las personas
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void inicializar() throws NumberFormatException, IOException {
		for (int i = 0; i < mn.hb.length; i++) {
			mn.hb[i] = new Habitacion(String.valueOf(i + 1), false);
		}
		System.out.println("ingrese la nueva tarifa:");
		double tarifa = Double.parseDouble(br.readLine());
		for (int i = 0; i < mn.hb.length; i++) {
			mn.hb[i].setTarifa(tarifa);
		}
		for (int i = 0; i < mn.pr.length; i++) {
			mn.pr[i] = new Persona("0");

		}

	}

	/**
	 * cobra el costo de la habitacion y ademas deja la habitacion disponible
	 * nuevamente
	 * 
	 * @return el costo a pagaar por la persona
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public double salida() throws NumberFormatException, IOException {
		System.out.println("por favor introduzca el numero de habitacion:");
		int nHabitacion = Integer.parseInt(br.readLine());
		if (!mn.hb[nHabitacion].isDiponibilidad()) {
			System.err.println("Esta habitacion esta vacia");
			salida();
		}
		int posicion = 0;
		for (int i = 0; i < mn.pr.length; i++) {
			if (mn.pr[i].getCedula() == mn.hb[nHabitacion - 1].getCedula()) {
				posicion = i;
			}
		}
		if (mn.pr[posicion].getNumHoras() < 12) {
			return mn.hb[nHabitacion - 1].getTarifa();
		} else {
			double ntarifas = (mn.pr[posicion].getNumHoras() / 12);
			mn.hb[nHabitacion - 1].setDiponibilidad(false);
			mn.hb[nHabitacion - 1].setCedula("0");
			return (double) (mn.hb[nHabitacion - 1].getTarifa() * ntarifas);
		}

	}
}
