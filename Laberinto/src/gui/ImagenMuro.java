package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenMuro extends JPanel {
	public ImagenMuro() {
		this.setSize(200, 200); // tama�o del panel
	}

	// Se crea un m�todo cuyo par�metro debe ser un objeto Graphics
	public void paint(Graphics grafico) {
		Dimension height = getSize();

		// Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

		//ImageIcon Img = new ImageIcon(getClass().getResource("src/Images/muro_laberinto.png"));
		ImageIcon img = new ImageIcon("src/Images/muro_laberinto.png");

		// se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

		grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);

		setOpaque(false);
		super.paintComponent(grafico);
	}
}
