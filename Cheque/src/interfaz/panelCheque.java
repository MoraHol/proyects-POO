package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import mundo.numaLetra;
import net.miginfocom.swing.MigLayout;

public class panelCheque extends JPanel {
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
	private final JLabel labBanco;
	private final JLabel lblNoCheque;
	private JTextField txtNoCheque;
	private JLabel lblAño;
	private JLabel lblDia;
	private JLabel lblMes;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAño;
	private JLabel lblPagueseALa;
	private JTextField txtPaguese;
	private JLabel labDinero;
	private JTextField txtDinero;
	private JLabel lblLaSumaDe;
	private JTextField txtSumade;
	private JLabel lblFirma;
	private JTextField txtFirma;

	/**
	 * Create the frame.
	 */
	public panelCheque(String fecha, int numero, double consignacion, String destinatario,
			String firma) {
		setBackground(Color.WHITE);

		// establece referencia a la ventana principal

		// Esyablece el tamaño del layout
		setPreferredSize(new Dimension(707, 200));
		// establecer titulo del borde
		TitledBorder border = BorderFactory.createTitledBorder("Cheques");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		// establecer layout
		setLayout(new MigLayout("", "[68px][grow][57px][][grow][][grow][][grow][][grow]", "[19px][][][][][][][]"));
		// separar la fecha}
		String[] sfecha = fecha.split("/");
		String dia, mes, año;
		dia = sfecha[2];
		mes = sfecha[1];
		año = sfecha[0];
		/*if (Integer.parseInt(dia) < 9) {
			dia = "0" + dia;
		}
		if (Integer.parseInt(mes) < 9) {
			mes = "0" + mes;
		}*/
		labBanco = new JLabel("Su Banco");
		labBanco.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));

		lblNoCheque = new JLabel("No. Cheque");

		txtNoCheque = new JTextField();
		txtNoCheque.setForeground(Color.BLACK);
		txtNoCheque.setEditable(false);
		txtNoCheque.setColumns(10);
		String numeroAux = Integer.toString(numero);
		numeroAux = numero < 9 ? "00" + numeroAux : "0" + numeroAux;
		txtNoCheque.setText(numeroAux);

		lblDia = new JLabel("Dia");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);

		lblMes = new JLabel("Mes");

		textDia = new JTextField();
		textDia.setForeground(Color.BLACK);
		textDia.setEditable(false);
		textDia.setText(dia);

		textMes = new JTextField();
		textMes.setForeground(Color.BLACK);
		textMes.setEditable(false);
		textMes.setText(mes);

		labDinero = new JLabel("$");

		txtDinero = new JTextField();
		txtDinero.setEditable(false);
		refrescarPrecio(consignacion);
		txtDinero.setColumns(10);

		lblPagueseALa = new JLabel("Paguese a la orden de:");

		txtPaguese = new JTextField();
		txtPaguese.setEditable(false);
		txtPaguese.setText(destinatario);
		txtPaguese.setColumns(10);

		lblLaSumaDe = new JLabel("La suma de:");

		txtSumade = new JTextField();
		txtSumade.setEditable(false);
		txtSumade.setText(Nummero_Letra(consignacion));

		lblFirma = new JLabel("Firma:");

		txtFirma = new JTextField();
		txtFirma.setEditable(false);
		txtFirma.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 23));
		txtFirma.setText(firma);
		txtFirma.setColumns(10);

		// añadir al panel
		add(labBanco, "cell 0 0,alignx left,aligny center");
		add(lblNoCheque, "cell 8 0,alignx center,aligny center");
		add(txtNoCheque, "cell 10 0,growx");
		add(lblDia, "cell 2 1,alignx center");
		add(lblMes, "cell 3 1,alignx center");
		
				lblAño = new JLabel("A\u00F1o");
				add(lblAño, "flowx,cell 4 1,alignx center");
		add(textDia, "cell 2 2,growx");
		add(textMes, "cell 3 2,alignx center,aligny center");
		
				textAño = new JTextField();
				textAño.setForeground(Color.BLACK);
				textAño.setEditable(false);
				textAño.setText(año);
				add(textAño, "cell 4 2,growx");
		add(labDinero, "cell 7 2,alignx trailing");
		add(txtDinero, "cell 8 2 3 1,growx");
		add(lblPagueseALa, "cell 0 3");
		add(txtPaguese, "cell 1 3 10 1,growx");
		add(lblLaSumaDe, "cell 0 4,alignx left");
		add(txtSumade, "cell 1 4 10 1,growx");
		add(lblFirma, "cell 5 7,alignx center");
		add(txtFirma, "cell 8 7 3 1,growx");
	}

	// ----------------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------------
	private void refrescarPrecio(double precio) {
		// Despliega el valor del vehículo
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern(" ###,###,###.##");
		txtDinero.setText(df.format(precio));
	}

	private String Nummero_Letra(double numero) {
		//Numero_a_Letra nm = new Numero_a_Letra();
		numaLetra nm = new numaLetra();
		String mn = nm.convertirLetras(numero);
		return mn;
	}
	
}
