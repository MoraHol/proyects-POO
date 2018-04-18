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
	private InterfazCheque principal;
	private JTextField txtDestinatario;
	private JTextField txtMonto;
	private static final String ACEPTAR = "aceptar";
	private JButton butAceptar;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

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

		label_2 = new JLabel("");
		add(label_2);

		label_3 = new JLabel("");
		add(label_3);

		label_4 = new JLabel("");
		add(label_4);

		label_5 = new JLabel("");
		add(label_5);

		label_6 = new JLabel("");
		add(label_6);

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
