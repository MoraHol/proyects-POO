package interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class PanelDatosCheque extends JPanel implements ActionListener {
	// ---------------------------------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------------------------------
	/**
	 * ventana principal del programa
	 */
	private InterfazCheque principal;
	// ---------------------------------------------------------------------------------
	// Atributos del panel
	// ---------------------------------------------------------------------------------
	/**
	 * comando para generar cheque
	 */
	private static final String ACEPTAR = "aceptar";
	/**
	 * campo para escribir y visualizar el destinatario del cheque
	 */
	private JTextField txtDestinatario;
	/**
	 * Campo para escribir y visualizar el monto de cheque
	 */
	private JTextField txtMonto;
	/**
	 * Botón para generar cheque
	 */
	private JButton butAceptar;
	
	public PanelDatosCheque(InterfazCheque principalP) {
		principal = principalP;
		setPreferredSize(new Dimension(500, 150));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Cheque", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNombreDeLa = new JLabel("Nombre de la persona a consignar:");
		add(lblNombreDeLa);

		txtDestinatario = new JTextField();
		add(txtDestinatario);
		txtDestinatario.setColumns(10);

		JLabel lblMonto = new JLabel("Monto:");
		add(lblMonto);

		txtMonto = new JTextField();
		add(txtMonto);
		txtMonto.setColumns(10);

		add(new JLabel(""));

		add(new JLabel(""));

		add(new JLabel(""));

		add(new JLabel(""));

		add(new JLabel(""));

		butAceptar = new JButton("Aceptar");
		butAceptar.setActionCommand(ACEPTAR);
		butAceptar.addActionListener(this);
		add(butAceptar);

	}

	public double getMonto() {
		return Double.parseDouble(txtMonto.getText());
	}

	public String getDestinatario() {
		return txtDestinatario.getText();
	}

	private void agregarCheque() {
		principal.agregarCheque();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals(ACEPTAR)) {
			agregarCheque();
		}
	}
}
