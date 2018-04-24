package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class panelDatos extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Ventana principal del programa
	 */
	private InterfazCheque principal;
	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------
	/**
	 * Comando para mostrar cheque
	 */
	private final static String LISTAR = "listar";
	/**
	 * Comando de búsqueda
	 */
	public final static String BUSCAR = "buscar";
	/**
	 * comando limpiar
	 */
	public final static String LIMPIAR = "limpiar";
	/**
	 * comando para consignar
	 */
	public final static String CONSIGNAR = "consignar";
	/**
	 * campo de texto para escribir y visualizar el nombre del usuario
	 */
	private final JTextField txtNombre;
	/**
	 * campo de texto para escribir y visualizar el apellido del usuario
	 */
	private final JTextField txtApellido;
	/**
	 * campo de texto para escribir y visualizar la direccion del usuario
	 */
	private final JTextField txtDireccion;
	/**
	 * campo de texto para escribir y visualizar el telefono del usuario
	 */
	private final JTextField txtTelefono;
	/**
	 * campo de texto para visualizar el saldo disponible en cuenta
	 */
	private final JTextField txtSaldo;
	/**
	 * campo de texto para visualizar la identificación
	 */
	private JTextField txtIdentificacion;
	/**
	 * campo de texto para visualizar el numero de la calle
	 */
	private JTextField txtNumCalle;
	/**
	 * Etiqueta para ubicar la palabra nombre antes del campo nombre
	 */
	private final JLabel labNombre;
	/**
	 * Etiqueta para ubicar la palabra apellido antes del campo apellido
	 */
	private final JLabel labApellido;
	/**
	 * Etiqueta para ubicar la palabra fecha de nacimiento antes del campo Fecha de
	 * nacimiento
	 */
	private final JLabel labFNacimineto;
	/**
	 * Etiqueta para ubicar la palabra dirección antes del campo dirección
	 */
	private final JLabel labDireccion;
	/**
	 * Etiqueta para ubicar la palabra teléfono antes del campo teléfono
	 */
	private final JLabel labTelefono;
	/**
	 * etiqueta para ubicar la palabra saldo antes del campo saldo
	 */
	private final JLabel labSaldo;
	/**
	 * Etiqueta para ubicar la palabra identificación antes del campo identificación
	 */
	private JLabel labIndentificacion;
	/**
	 * Botón para buscar
	 */
	private final JButton butBuscar;
	/**
	 * Botón para limpiar
	 */
	private final JButton butLimpiar;
	/**
	 * Button para mostrar cheques
	 */
	private final JButton butCheques;
	/**
	 * boton para consignar
	 */
	private final JButton butConsignar;
	/**
	 * Selección multiple para el día
	 */
	private JComboBox<Object> comboBoxDia;
	/**
	 * Selección multiple para el Mes
	 */
	private JComboBox<Object> comboBoxMes;
	/**
	 * Selección multiple para el año
	 */
	private JComboBox<String> comboBoxAño;
	/**
	 * Selección multiple para la calle
	 */
	private JComboBox<Object> comboBoxcalle;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * 
	 * @param principalP
	 *            - interfaz principal
	 */
	public panelDatos(InterfazCheque principalP) {
		// establece referencia a la ventana principal
		principal = principalP;

		// Establece el tamaño del layout
		setPreferredSize(new Dimension(800, 300));
		setLayout(new GridLayout(9, 4, 0, 0));

		// Adiciona u marco con titulo
		TitledBorder border = BorderFactory.createTitledBorder("Datos del usuario");
		border.setTitleColor(Color.BLUE);
		setBorder(border);

		// crea e inicializa los objetos del panel
		labNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		labApellido = new JLabel("Apellido");
		txtApellido = new JTextField();
		labIndentificacion = new JLabel("Numero de identificacion");
		txtIdentificacion = new JTextField();
		labTelefono = new JLabel("Telefono");
		txtTelefono = new JTextField();
		labDireccion = new JLabel("Dirección");
		txtDireccion = new JTextField("Eje: 82 - 30");
		txtDireccion.setForeground(Color.GRAY);
		txtDireccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDireccion.setText("");
				txtDireccion.setForeground(Color.BLACK);
			}
		});
		labFNacimineto = new JLabel("Fecha de nacimiento");
		txtNumCalle = new JTextField("numero de la calle");
		txtNumCalle.setForeground(Color.GRAY);
		txtNumCalle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNumCalle.setText("");
				txtNumCalle.setForeground(Color.black);

			}
		});

		labSaldo = new JLabel("Saldo");
		txtSaldo = new JTextField();
		txtSaldo.setText("$ 0");
		txtSaldo.setEditable(false);
		txtSaldo.setForeground(Color.blue);
		txtSaldo.setBackground(Color.WHITE);
		butLimpiar = new JButton("Limpiar");
		butLimpiar.setActionCommand(LIMPIAR);
		butLimpiar.addActionListener(this);
		butBuscar = new JButton("Buscar");
		butBuscar.setActionCommand(BUSCAR);
		butBuscar.addActionListener(this);
		butCheques = new JButton("Cheques Realizados");
		butCheques.setActionCommand(LISTAR);
		butCheques.addActionListener(this);
		butConsignar = new JButton("Consignar");
		butConsignar.setActionCommand(CONSIGNAR);
		butConsignar.addActionListener(this);
		// Combo box para la fecha de nacimineto y el tipo de calle
		comboBoxMes = new JComboBox<Object>();
		comboBoxMes.setModel(new DefaultComboBoxModel<Object>(new String[] { "Enero", "Febrero", "Marzo", "Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		comboBoxcalle = new JComboBox<Object>();
		comboBoxcalle.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "", "Avenida", "Calle", "Carrera", "Diagonal" }));
		comboBoxDia = new JComboBox<Object>();
		comboBoxDia.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
						"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		comboBoxAño = new JComboBox<String>();
		comboBoxAño.setModel(new DefaultComboBoxModel<String>(new String[] { "2008", "2007", "2006", "2005", "2004",
				"2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991",
				"1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983" }));

		// adiciona los objeto al panel

		add(labNombre);
		add(new JLabel(""));
		add(new JLabel(""));
		add(txtNombre);
		add(labApellido);
		add(new JLabel(""));
		add(new JLabel(""));
		add(txtApellido);
		add(labIndentificacion);
		add(new JLabel(""));
		add(new JLabel(""));
		add(txtIdentificacion);
		add(labFNacimineto);
		add(comboBoxMes);
		add(comboBoxDia);
		add(comboBoxAño);
		add(labDireccion);
		add(comboBoxcalle);
		add(txtNumCalle);
		add(txtDireccion);
		add(labTelefono);
		add(new JLabel(""));
		add(new JLabel(""));
		add(txtTelefono);
		add(labSaldo);
		add(new JLabel(""));
		add(new JLabel(""));
		add(txtSaldo);
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(butConsignar);
		add(butCheques);
		add(butBuscar);
		add(butLimpiar);
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * devuelve el nombre ingresado en el campo
	 * 
	 * @return nombre ingresado
	 */
	public String getNombre() {
		return txtNombre.getText().toLowerCase();
	}

	/**
	 * devuelve el apellido ingresado en el campo
	 * 
	 * @return apellido ingresado
	 */
	public String getApellido() {
		return txtApellido.getText().toLowerCase();
	}

	/**
	 * devuelve la fecha de nacimiento ingresada en el campo
	 * 
	 * @return fecha de nacimiento ingresado
	 */
	public String getFechaNacimiento() {
		String conversion = "";
		conversion += Integer.toString(comboBoxDia.getSelectedIndex() + 1) + "/";
		conversion += comboBoxMes.getSelectedIndex() + 1 < 9
				? "0" + Integer.toString(comboBoxMes.getSelectedIndex() + 1) + "/"
				: Integer.toString(comboBoxMes.getSelectedIndex() + 1) + "/";
		conversion += comboBoxAño.getSelectedItem();
		return conversion;
	}

	/**
	 * devuelve la dirección ingresada en el campo
	 * 
	 * @return dirección ingresado
	 */
	public String getDireccion() {
		String conversion = "";
		conversion += comboBoxcalle.getSelectedItem() + " ";
		conversion += txtNumCalle.getText().toLowerCase() + " ";
		conversion += txtDireccion.getText().toLowerCase();
		return conversion;
	}

	/**
	 * devuelve el teléfono ingresada en el campo
	 * 
	 * @return teléfono ingresado
	 */
	public String getTelefono() {
		return txtTelefono.getText();
	}

	/**
	 * devuelve la identificación ingresada en el campo
	 * 
	 * @return identificación ingresada
	 */
	public String getIdentificacion() {
		return txtIdentificacion.getText();
	}

	/**
	 * Despliega el saldo de la cuenta
	 * 
	 * @param precio
	 *            - el saldo que tiene la cuenta
	 */
	public void refrescarPrecio(double precio) {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern("$ ###,###,###.##");
		txtSaldo.setText(df.format(precio));
	}

	/**
	 * limpiara todos los campos, borrara los paneles de ultimo cheque y panel de
	 * datos de cheque
	 */
	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtDireccion.setText("Eje: 82 - 30");
		txtDireccion.setForeground(Color.GRAY);
		txtNumCalle.setText("numero de la calle");
		txtNumCalle.setForeground(Color.GRAY);
		txtSaldo.setText("$ 0");
		txtTelefono.setText("");
		comboBoxDia.setSelectedIndex(0);
		comboBoxMes.setSelectedIndex(0);
		comboBoxAño.setSelectedIndex(0);
		comboBoxcalle.setSelectedIndex(0);
		txtIdentificacion.setText("");
		principal.limpiar();
	}

	/**
	 * Abrirá la interfaz donde mostrará los cheques hechos por el usuario
	 */
	private void listar() {
		InterfazLista interfaz = new InterfazLista(principal);
		if (interfaz.getPaneles() != null) {
			interfaz.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals(BUSCAR)) {
			principal.calcularSaldoPresona();
		}
		if (comando.equals(LIMPIAR)) {
			limpiar();
		}
		if (comando.equals(LISTAR)) {
			listar();
		}
		if (comando.equals(CONSIGNAR)) {
			principal.InterfazConsig = new InterfazConsignar(principal);
			principal.InterfazConsig.setVisible(true);

		}

	}
}
