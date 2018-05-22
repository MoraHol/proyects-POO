package interfaz;

import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @version 2.0 23/04/2018
 * @author Alexis Holguin
 * 
 */
public class InterfazConsignar extends JFrame implements ActionListener {

	// ---------------------------------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 8191939362571594574L;

	/**
	 * ventana principal del programa
	 */
	private InterfazCheque Principal;

	// ---------------------------------------------------------------------------------
	// Atributos de la ventana
	// ---------------------------------------------------------------------------------

	/**
	 * comando utilizado para hacer consignaciones
	 */
	public final static String CONSIGNAR = "consignar";
	/**
	 * campo para escribir y visualizar el numero de identificación
	 */
	private JTextField txtidentificacion;
	/**
	 * campo para escribir y visualizar el monto de la consignación
	 */
	private JTextField txtMonto;
	/**
	 * Botón para generar la consignación
	 */
	private JButton butConsignar;
	/**
	 * Etiqueta para ubicar el campo de monto
	 */
	private JLabel labMonto;
	/**
	 * Etiqueta para ubicar el campo de identificación
	 */
	private JLabel labIdentificacion;
	// ---------------------------------------------------------------------------------
	// Constructor
	// ---------------------------------------------------------------------------------

	/**
	 * generar una nueva ventana para hacer consignaciones
	 * 
	 * @param pricipalP
	 *            - ventana principal del programa
	 */
	public InterfazConsignar(InterfazCheque pricipalP) {
		setSize(446, 190);
		Principal = pricipalP;
		getContentPane().setLayout(new MigLayout("", "[][][][][][][][][][grow][][grow]", "[][][][][][][][]"));

		labIdentificacion = new JLabel("Identificacion de la persona a consignar");
		labMonto = new JLabel("Monto a consignar");
		txtidentificacion = new JTextField();
		txtidentificacion.setColumns(10);
		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		butConsignar = new JButton("Consignar");
		butConsignar.setActionCommand(CONSIGNAR);
		butConsignar.addActionListener(this);

		getContentPane().add(labIdentificacion, "cell 1 2");
		getContentPane().add(txtidentificacion, "cell 5 2 7 1,growx");
		getContentPane().add(labMonto, "cell 1 3");
		getContentPane().add(txtMonto, "cell 5 3 7 1,growx");
		getContentPane().add(butConsignar, "cell 9 7");
	}

	// ------------------------------------------------------------------------------------------
	// Métodos
	// ------------------------------------------------------------------------------------------
	/**
	 * devuelve la identificación de la persona que recibirá el dinero
	 * @return - identificación del receptor
	 */
	public String getIdentificacion() {
		return txtidentificacion.getText();
	}
	/**
	 * devuelve el monto de la consignación
	 * @return - el monto a consignar
	 */
	public double getMonto() {
		return Double.parseDouble(txtMonto.getText());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Apéndice de método generado automáticamente
		String comando = e.getActionCommand();
		if (comando.equals(CONSIGNAR)) {
			Principal.consignar();
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
	}

}
