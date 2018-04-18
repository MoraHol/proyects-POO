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
	private final static String LISTAR = "listar";
	/**
	 * Comando de busqueda
	 */
	public final static String BUSCAR = "buscar";
	/**
	 * comando limpiar
	 */
	public final static String LIMPIAR = "limpiar";
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
	 * Etiqueta para ubicar la palabra direccion antes del campo direccion
	 */
	private final JLabel labDireccion;
	/**
	 * Etiqueta para ubicar la palabra telefono antes del campo telefono
	 */
	private final JLabel labTelefono;
	/**
	 * etiqueta para ubicar la palabra saldo antes del campo saldo
	 */
	private final JLabel labSaldo;
	/**
	 * Botón para buscar
	 */
	private final JButton butBuscar;
	/**
	 * Botón para limpiar
	 */
	private final JButton butLimpiar;
	/**
	 * Selección multiple para el día
	 */
	private JComboBox<Integer> comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox<String> comboBoxAño;
	private JComboBox comboBoxcalle;
	private JTextField txtNumCalle;
	private JLabel labIndentificacion;
	private JTextField txtIdentificacion;
	/**
	 * Button para mostrar cheques
	 */
	private final JButton butCheques;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	public panelDatos(InterfazCheque principalP) {
		// establece referencia a la ventana principal
		principal = principalP;

		// Esyablece el tamaño del layout
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
		// comobo box para la fecha de nacimineto y el tipo de calle
		comboBoxMes = new JComboBox();
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		comboBoxcalle = new JComboBox();
		comboBoxcalle
				.setModel(new DefaultComboBoxModel(new String[] { "", "Avenida", "Calle", "Carrera", "Diagonal" }));
		comboBoxDia = new JComboBox();
		comboBoxDia.setModel(new DefaultComboBoxModel(
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
		add(new JLabel(""));
		add(butCheques);
		add(butBuscar);
		add(butLimpiar);
	}

	// meotodos
	public String getNombre() {
		return txtNombre.getText().toLowerCase();
	}

	public String getApellido() {
		return txtApellido.getText().toLowerCase();
	}

	public String getFechaNacimiento() {
		String conversion = "";
		conversion += Integer.toString(comboBoxDia.getSelectedIndex() + 1) + "/";
		conversion += comboBoxMes.getSelectedIndex() + 1 < 9
				? "0" + Integer.toString(comboBoxMes.getSelectedIndex() + 1) + "/"
				: Integer.toString(comboBoxMes.getSelectedIndex() + 1) + "/";
		conversion += comboBoxAño.getSelectedItem();
		System.out.println(conversion);
		return conversion;
	}

	public String getDireccion() {
		String conversion = "";
		conversion += comboBoxcalle.getSelectedItem() + " ";
		conversion += txtNumCalle.getText().toLowerCase() + " ";
		conversion += txtDireccion.getText().toLowerCase();
		return conversion;
	}

	public String getTelefono() {
		return txtTelefono.getText();
	}

	public String getIdentificacion() {
		return txtIdentificacion.getText();
	}

	public void refrescarPrecio(double precio) {
		// Despliega el valor del vehículo
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern("$ ###,###.##");
		txtSaldo.setText(df.format(precio));
	}

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
		principal.limpiar();
	}

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

	}
}
