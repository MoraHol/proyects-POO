package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Menu opc = new Menu();
		do {
			opc.mostar();
			opc.Parameters(Integer.parseInt(br.readLine()));
		}while(true);
		
		}

}
