package interfaz;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazConsignar extends JFrame implements ActionListener {
	public final static String CONSIGNAR = "consignar";
	private JTextField txtidentificacion;
	private JTextField txtMonto;
	private JButton butConsignar;
	private JLabel labMonto;
	private JLabel labIdentificacion;
	private InterfazCheque Principal;

	public InterfazConsignar(InterfazCheque pricipalP) {
		setSize(446,190);
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
	//------------------------------------------------------------------------------------------
	//Métodos
	//------------------------------------------------------------------------------------------
	public String getIdentificacion() {
		return txtidentificacion.getText();
	}
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
