package taylorSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import operaciones.*;

public class senoTaylor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#0.00");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// instanciando objeto
		Operaciones op = new Operaciones();

		System.out.println("serie taylor para seno " );

		System.out.println("¿cuantas iteraciones desea hacer?");

		int iteration = Integer.parseInt(br.readLine());
		System.out.println("¿Que valor va tener x?");

		int x = Integer.parseInt(br.readLine());

		double conversion = x * 3.141592 / 180.0;
		System.out.println("El seno de " + x + " segun la serie de taylor es:"
				+ (df.format(op.serie_taylor_seno(iteration, conversion))) + "\n");
		
	}

}
