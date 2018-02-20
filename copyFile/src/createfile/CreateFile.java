package createfile;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateFile {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		try {
		System.out.println("escriba la ruta donde desea crear la carpeta:");
		String ruta = br.readLine();
		System.out.println("escriba el nmbre que desea para la carpeta:");
		String nombre = br.readLine();
		File folder = new File(ruta+"\\"+nombre);
		folder.mkdirs();
		System.out.println("la carpeta se creo correctamente");
		}catch (Exception e) {
			System.err.println("no se puedo crear la carpeta");
		}
		
	}

}
