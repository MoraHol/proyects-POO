package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
/**
 * @version 2.0 23/04/2018
 * @author Alexis Holguin
 * 
 */
public class InterfazLista extends JFrame {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * guarda todos los paneles a mostrar en pantalla
	 */
	private ArrayList<panelCheque> paneles;
	/**
	 * ventana principal del programa
	 */
	private InterfazCheque interfazPrincipal;
	/**
	 * la altura predefinida para el JFrame
	 */
	private int altura = 100;
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * crea la interfaz de paneles de cheques
	 * 
	 * @param principalP
	 *            - comunicación con la JFrame principal
	 */
	public InterfazLista(InterfazCheque principalP) {
		setType(Type.POPUP);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(InterfazLista.class.getResource("/data/bank-icon_31875.png")));
		interfazPrincipal = principalP;
		paneles = interfazPrincipal.MostrarCheques();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1000, 161);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1));
		if (paneles == null) {
			return;
		}

		for (int i = 0; i < paneles.size(); i++) {
			panel.add(paneles.get(i));
			if (altura > 600) {
				setSize(1000, 600);
			} else {
				setSize(1000, altura += 200);
			}

			panel.updateUI();
		}

	}

	// -----------------------------------------------------------------
	// Métodos 
	// -----------------------------------------------------------------
	/**
	 * obtiene los paneles de cheques realizados por una persona
	 * 
	 * @return panel cheque asociados a una persona
	 */
	public ArrayList<panelCheque> getPaneles() {
		return paneles;
	}
}
