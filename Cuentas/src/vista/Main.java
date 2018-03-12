package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean procces = true;
	public static void main(String[] args) throws NumberFormatException, IOException {
		proceso();
		
	}
	public static void proceso() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Menu opc = new Menu();
		opc.Inicializar();
		do {
			opc.mostar();
			opc.Parameters(Integer.parseInt(br.readLine()));
		} while (procces == true);
		proceso();
	}

}
