package copyFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class copy2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rutaOrigen, rutaDestino;
		System.out.println("ingrese la ruta del origen del archivo:");
		rutaOrigen = br.readLine();
		System.out.println("ingrese la ruta donde quiere copiar el archivo");
		rutaDestino = br.readLine();
		System.out.println(rutaOrigen);
		//String array[] = rutaOrigen.split("\\");
		//int a = array.length - 1;
		//String nombreArchivo = array[a];
		
		try {
			File origen = new File(rutaOrigen);
			//File destino = new File(rutaDestino + "\\" + nombreArchivo);
			File destino = new File(rutaDestino);
			InputStream in = new FileInputStream(origen);
			OutputStream out = new FileOutputStream(destino);

			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("el copiado se realizo correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("hubo un error en el copiado");
		}
		
	}

}
