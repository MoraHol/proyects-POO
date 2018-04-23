/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Minuto de Dios (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas 
 *
 * Ejercicio: CHEQUES
 * @author Alexis Holguin - Abr 20, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.Cheque;
import mundo.Persona;
import mundo.principal;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class InterfazCheque extends JFrame {
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------
	/**
	 * panel de datos
	 */
	private final panelDatos PanelDatos;
	/**
	 * objeto para llamar atributos y métodos de la clase principal
	 */
	private principal principal;
	/**
	 * panel para pedir los datos del cheque
	 */
	private PanelDatosCheque panelDatosCheque;
	/**
	 * guardaran los cheques hechos por la persona
	 */
	private ArrayList<panelCheque> paneles;
	/**
	 * panel para guardar el ultimo cheque realizado
	 */
	private JPanel panelCheque;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	public InterfazCheque() throws Exception {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(InterfazCheque.class.getResource("/data/bank-icon_31875.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal = new principal();
		// configura la información de la ventana
		setTitle("Cheques");
		setSize(800, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// crea los paneles y lo agrega a la ventana
		PanelDatos = new panelDatos(this);
		getContentPane().add(PanelDatos);
		panelCheque = new JPanel();
		panelCheque.setSize(800, 200);

		TitledBorder border = BorderFactory.createTitledBorder("Ultimo cheque");
		border.setTitleColor(Color.BLUE);
		panelCheque.setBorder(border);

	}

	/**
	 * mostrara el saldo de la cuenta de una persona
	 */
	public void calcularSaldoPresona() {
		// Pide la información dada por el usuario al respectivo panel

		String unNombre = PanelDatos.getNombre();
		String unApellido = PanelDatos.getApellido();
		String unaFecha = PanelDatos.getFechaNacimiento();
		String unaDireccion = PanelDatos.getDireccion();
		String unTelefono = PanelDatos.getTelefono();
		String unaIdentificacion = PanelDatos.getIdentificacion();
		double precio = 0;
		if (unNombre.equals("") || unApellido.equals("") || unaFecha.equals("")
				|| unaDireccion.equals(" numero de la calle Eje: 82 - 30") || unTelefono.equals("")
				|| unaIdentificacion.equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor llene todos los datos", "Cheque", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Persona persona = principal.buscarPersona(unNombre, unApellido, unaFecha, unaIdentificacion);
				precio = persona.getSaldo();
				// Pide al panel que refresque la informacion del precio
				PanelDatos.refrescarPrecio(precio);
				panelDatosCheque = new PanelDatosCheque(this);
				getContentPane().add(panelDatosCheque, BorderLayout.SOUTH);
				setSize(800, 400);
				setLocationRelativeTo(null);
			} catch (Exception e) {
				// Presenta al usuario el mensaje de la excepcion
				JOptionPane.showMessageDialog(this, "No se encuentra registrado", "Calculo de Impuestos",
						JOptionPane.WARNING_MESSAGE);
				PanelDatos.refrescarPrecio(precio);
			}
		}
	}

	/**
	 * agregara todos los cheques realizados por dicha persona y será almacenados en
	 * un ArrayList
	 * 
	 * @return el ArrayList con todos los cheques realizados
	 */
	public ArrayList<panelCheque> MostrarCheques() {
		paneles = new ArrayList<>();
		panelCheque panelCheck;
		String unNombre = PanelDatos.getNombre();
		String unApellido = PanelDatos.getApellido();
		String unaFecha = PanelDatos.getFechaNacimiento();
		String unaDireccion = PanelDatos.getDireccion();
		String unTelefono = PanelDatos.getTelefono();
		String unaIdentificacion = PanelDatos.getIdentificacion();
		if (unNombre.equals("") || unApellido.equals("") || unaFecha.equals("")
				|| unaDireccion.equals(" numero de la calle Eje: 82 - 30") || unTelefono.equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor llene todos los datos", "Cheque", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			Persona persona = principal.buscarPersona(unNombre, unApellido, unaFecha, unaIdentificacion);
			for (int i = 0; i < persona.getCheques().size(); i++) {
				persona.getCheques().get(i);
				String fecha = persona.getCheques().get(i).getFecha();
				int numero = persona.getCheques().get(i).getNumero();
				double consignacion = persona.getCheques().get(i).getCantidad();
				String destinatario = persona.getCheques().get(i).getDestinatario();
				String firma = persona.getNombre() + " " + persona.getApellido();
				panelCheck = new panelCheque(fecha, numero, consignacion, destinatario, firma);
				paneles.add(panelCheck);
			}
		}
		return paneles;
	}

	/**
	 * agrega cheque a una persona y los muestra en el panel
	 */
	public void agregarCheque() {
		double unMonto = panelDatosCheque.getMonto();
		String unDestinatario = panelDatosCheque.getDestinatario();
		String unaIdentificacion = PanelDatos.getIdentificacion();
		String unaFecha = principal.getFecha();
		Persona persona = principal.buscarPersona(unaIdentificacion);
		String firma = persona.getNombre() + " " + persona.getApellido();
		if (Double.toString(unMonto) == null || unDestinatario.equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor llene todos los datos", "Cheque", JOptionPane.ERROR_MESSAGE);
		} else {
			if (persona.generarCheque(unMonto) == -1) {
				JOptionPane.showMessageDialog(this, "No tienes suficientes fondos", "Cheque",
						JOptionPane.ERROR_MESSAGE);
			} else {
				getContentPane().add(panelCheque, BorderLayout.NORTH);
				int unNumero = persona.getCheques().size() + 1;
				Cheque unCheque = new Cheque(unaFecha, unNumero, unMonto, unaIdentificacion, unDestinatario);
				panelCheque panelCheck = new panelCheque(unaFecha, unNumero, unMonto, unDestinatario, firma);
				persona.AgregarCheque(unCheque);
				double precio = persona.getSaldo();
				PanelDatos.refrescarPrecio(precio);
				this.setSize(800, 600);
				this.setLocationRelativeTo(null);
				panelCheque.removeAll();
				panelCheque.updateUI();
				panelCheque.add(panelCheck);
			}

		}
		principal.EscribirCheques("src/data/Cheques.txt");
		principal.EscribirUsuarios("src/data/usuarios.txt");
	}

	/**
	 * limpiara todo
	 */
	public void limpiar() {
		remove(panelDatosCheque);
		remove(panelCheque);
		setSize(800, 250);
		setLocationRelativeTo(null);
		principal.EscribirCheques("src/data/Cheques.txt");
	}

	public static void main(String[] args) {
		try {
			InterfazCheque interfaz = new InterfazCheque();
			interfaz.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
