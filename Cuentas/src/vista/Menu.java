package vista;

import operaciones.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import clientes.Cliente;

public class Menu {
	Movimientos mv = new Movimientos();
	Cliente cl = new Cliente();
	Main mn = new Main();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void Inicializar() throws IOException {
		System.out.println("Por favor ingrese su nombre:");
		cl.setNombre(br.readLine());
		System.out.println("Por favor ingrese nu numero de cuenta:");
		cl.setCuenta(br.readLine());
		cl.setValor(mv.setValor());
		cl.setInteres(mv.setInteres());
	}

	public void mostar() {
		System.out.println("Bienvenido que desea realizar:");
		System.out.println("1. Realizar un retiro \n" + "2. Realizar un ingreso \n" + "3. Obtener saldo \n"
				+ "4. mostrar el interes \n" + "5. mostrar sus datos\n" + "6. Ingresar nuevamente \n" + "Ingresa la opcion");
	}

	public void Parameters(int option) throws NumberFormatException, IOException {

		switch (option) {
		case 1:
			System.out.println("¿Que valor deseas retirar?");
			cl.setValor(mv.retiro(Double.parseDouble(br.readLine()), cl.getValor()));
			break;
		case 2:
			System.out.println("¿Que valor deseas ingresar?");
			cl.setValor(mv.ingreso(Double.parseDouble(br.readLine()), cl.getValor()));
			break;
		case 3:
			mv.mostarSaldo(cl.getValor());
			break;
		case 4:
			cl.setInteres(mv.setInteres());
			System.out.println("su interes es: %" + cl.getInteres());
			break;
		case 5:
			System.out.println(cl.toString());
			break;
		case 6:
			Main.procces = false;
			break;
		
		}
	}
}
