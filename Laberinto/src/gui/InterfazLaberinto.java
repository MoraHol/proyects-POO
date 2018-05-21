package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class InterfazLaberinto extends JFrame implements ActionListener {
	private static final long serialVersionUID = 3214745126105075521L;
	private JTextField textTamaño;
	private lab laberinto;
	private static final String ACTUALIZAR = "actualizar";
	private static final String NEXTSTEP = "siguientes paso";
	private static final String PLAY = "play";
	private static final String STOP = "stop";
	private JPanel panel_Laberinto;
	int x = 0;
	private Timer timer;
	JScrollPane scroll;

	public InterfazLaberinto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrar2();
			}
		});
		setSize(700, 700);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(2, 5, 0, 0));

		JLabel lblTamaño = new JLabel("Tama\u00F1o");
		panel_1.add(lblTamaño);

		textTamaño = new JTextField();
		panel_1.add(textTamaño);
		textTamaño.setColumns(10);

		JButton btnActualizar = new JButton("actualizar");
		panel_1.add(btnActualizar);
		btnActualizar.setActionCommand(ACTUALIZAR);
		btnActualizar.addActionListener(this);

		JLabel label = new JLabel("");
		panel_1.add(label);

		JButton btnSiguientePaso = new JButton("Siguiente paso");
		panel_1.add(btnSiguientePaso);
		btnSiguientePaso.setActionCommand(NEXTSTEP);
		btnSiguientePaso.addActionListener(this);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		btnStop.setActionCommand(STOP);
		panel_1.add(btnStop);
		JButton btnPlay = new JButton("Play");
		panel_1.add(btnPlay);
		btnPlay.setActionCommand(PLAY);
		btnPlay.addActionListener(this);
		panel_Laberinto = new JPanel();

		scroll = new JScrollPane();
		panel.add(scroll, BorderLayout.CENTER);
		scroll.setViewportView(panel_Laberinto);
		for (int i = 0; i < 100; i++) {
			panel_Laberinto.add(new ImagenMuro());
		}

		timer = new Timer(300, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (x < laberinto.getRecorridos().size() - 1) {
						x += 1;
						pasos(x);
					} else {
						timer.stop();
						cerrar();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Crea primero el laberinto", "laberinto",
							JOptionPane.ERROR_MESSAGE);
					timer.stop();
				}
			}
		});
	}

	public static void main(String[] args) {
		InterfazLaberinto rd = new InterfazLaberinto();
		while (rd.isVisible() == false) {
			rd.setVisible(true);
		}
	}

	private void mostarLaberinto(int[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == 1) {
					panel_Laberinto.add(new ImagenMuro());
					panel_Laberinto.updateUI();
				} else if (maze[i][j] == 2) {
					panel_Laberinto.add(new ImagenJugador());
					panel_Laberinto.updateUI();
				} else if (maze[i][j] == 3) {
					panel_Laberinto.add(new ImagenMeta());
					panel_Laberinto.updateUI();
				} else {
					panel_Laberinto.add(new JPanel());
					panel_Laberinto.updateUI();
				}
			}
		}
	}

	private void actualizarPanel() {
		try {
			laberinto = new lab(Integer.parseInt(textTamaño.getText()), Integer.parseInt(textTamaño.getText()));
			x = 0;
			int[][] maze = laberinto.getMaze();
			panel_Laberinto.removeAll();
			panel_Laberinto.setLayout(new GridLayout(Integer.parseInt(textTamaño.getText()), 0));
			scroll.setViewportView(panel_Laberinto);
			mostarLaberinto(maze);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ingrese solo numeros", "Laberinto", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void pasos(int x) {
		int[][] maze = laberinto.getRecorridos().get(x);
		panel_Laberinto.removeAll();
		mostarLaberinto(maze);
	}

	private void cerrar() {
		if (JOptionPane.showConfirmDialog(this, "Se ha alzanzado la meta ¿Deseas generar otro laberinto?", "laberinto",
				JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			actualizarPanel();
		} else {
			cerrar2();
		}
	}

	private void cerrar2() {
		if (JOptionPane.showConfirmDialog(this, "¿Deseas salir?", "laberinto",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Apéndice de método generado automáticamente
		String comando = arg0.getActionCommand();
		if (comando.equals(ACTUALIZAR)) {
			actualizarPanel();
		}
		if (comando.equals(NEXTSTEP)) {
			try {
				timer.stop();
				if (x < laberinto.getRecorridos().size() - 1) {
					x += 1;
					pasos(x);
				} else {
					cerrar();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Crea primero el laberinto", "laberinto",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (comando.equals(PLAY)) {
			timer.start();
		}
		if (comando.equals(STOP)) {
			timer.stop();
		}
	}
}
