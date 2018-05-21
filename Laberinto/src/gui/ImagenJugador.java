package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenJugador extends JPanel {
	public ImagenJugador() {
		this.setSize(200, 200); // tamaño del panel
	}

	// Se crea un método cuyo parámetro debe ser un objeto Graphics
	public void paint(Graphics grafico) {
		Dimension height = getSize();

		// Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

		ImageIcon img = new ImageIcon("src/Images/jugador.png");

		// se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

		grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);

		setOpaque(false);
		super.paintComponent(grafico);
	}
}
