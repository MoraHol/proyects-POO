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

public class InterfazLista extends JFrame {

	private ArrayList<panelCheque> paneles;
	private InterfazCheque interfazPrincipal;
	private int altura = 100;

	public InterfazLista(InterfazCheque principalP) {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfazLista.class.getResource("/data/bank-icon_31875.png")));
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
		panel.setLayout(new GridLayout(0,1));
		if (paneles == null) {
			return;
		}
		
		for (int i = 0; i < paneles.size(); i++) {
			panel.add(paneles.get(i));
			if(altura > 600) {
				setSize(1000,600);
			}else {
				setSize(1000, altura += 200);
			}
			
			panel.updateUI();
		}

	}

	public ArrayList<panelCheque> getPaneles() {
		return paneles;
	}
}
