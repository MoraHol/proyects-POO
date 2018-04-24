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

import mundo.Num_Letra;
import net.miginfocom.swing.MigLayout;

public class panelCheque extends JPanel {
	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------
	/**
	 * etiqueta para ubicar la palabra banco al inicio del panel
	 */
	private final JLabel labBanco;
	/**
	 * etiqueta para ubicar la palabra numero de cheque
	 */
	private final JLabel lblNoCheque;
	/**
	 * campo para visualizar el numero del cheque
	 */
	private JTextField txtNoCheque;
	/**
	 * etiqueta para ubicar la palabra año encima del campo año
	 */
	private JLabel lblAño;
	/**
	 * etiqueta para ubicar la palabra día encima del campo día
	 */
	private JLabel lblDia;
	/**
	 * etiqueta para ubicar la palabra mes encima del campo mes
	 */
	private JLabel lblMes;
	/**
	 * campo para visualizar el día de la realización del cheque
	 */
	private JTextField textDia;
	/**
	 * campo para visualizar el mes de la realización del cheque
	 */
	private JTextField textMes;
	/**
	 * campo para visualizar el año de la realización del cheque
	 */
	private JTextField textAño;
	/**
	 * etiqueta para ubicar la palabra páguese a 
	 */
	private JLabel lblPagueseALa;
	/**
	 * campo para visualizar la persona quien va a recibir el cheque
	 */
	private JTextField txtPaguese;
	/**
	 * etiqueta para ubicar la palabra $ demostrando el monto del cheque
	 */
	private JLabel labDinero;
	/**
	 * campo para visualizar el monto del cheque
	 */
	private JTextField txtDinero;
	/**
	 * etiqueta para ubicar la palabra la suma de en el cheque
	 */
	private JLabel lblLaSumaDe;
	/**
	 * campo para visualizar el monto en palabras
	 */
	private JTextField txtSumade;
	/**
	 * etiqueta para ubicar la palabra firma dentro del cheque
	 */
	private JLabel lblFirma;
	/**
	 * campo para visualizar la firma de la persona
	 */
	private JTextField txtFirma;

	/**
	 * 
	 * @param fecha - trae la fecha de la realización del cheque
	 * @param numero - contiene el numero del cheque
	 * @param consignacion - contiene el monto a consignar
	 * @param destinatario - persona a quien se consigno
	 * @param firma - firma del propietario de la cuenta
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
	// Métodos
	// ----------------------------------------------------------------
	/**
	 * Despliega el monto del cheque formateado
	 * @param precio - monto del cheque
	 */
	private void refrescarPrecio(double precio) {
		// Despliega el valor del vehículo
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern(" ###,###,###.##");
		txtDinero.setText(df.format(precio));
	}
	/**
	 * convierte un numero a letra para mostrarlo en el cheque
	 * @param numero - numero a convertir
	 * @return numero convertido a letra
	 */
	private String Nummero_Letra(double numero) {
		Num_Letra nm = new Num_Letra();
		String letra = nm.numletra(numero);
		return letra;
	}
	
}
