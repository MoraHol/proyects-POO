package test;

import clase.CCuenta;
import clase.CCuentaAhorros;

public class Test {

	public static void main(String[] args) {
		CCuenta cuenta01 = new CCuenta();
		CCuenta cuenta02 = new CCuenta("Pedro", "000000001", 6000, 3.5);

		cuenta01.asignarNombre("Maria");
		cuenta01.asignarCuenta("0000000009");
		cuenta01.asignarTipoDeInteres(2.5);

		cuenta01.ingreso(12000);
		cuenta01.reintegro(3000);

		System.out.println(cuenta01.ObtenerNombre());
		System.out.println(cuenta01.ObtenerCuenta());
		System.out.println(cuenta01.estado());
		System.out.println(cuenta01.obtenerTipoDeInteres());
		System.out.println();
		System.out.println(cuenta02.ObtenerNombre());
		System.out.println(cuenta02.ObtenerCuenta());
		System.out.println(cuenta02.estado());
		System.out.println(cuenta02.obtenerTipoDeInteres());
		// herencia
		CCuentaAhorros cuenta03 = new CCuentaAhorros("Alonso", "000000002", 1600, 3.5, 0.80);
		// cobrar cuota de mantenimiento
		cuenta03.reintegro(cuenta03.obtenerCuotaManten());
		// ingreso
		cuenta03.ingreso(6000);
		// reintegro
		cuenta03.reintegro(10000);
		// ...
		System.out.println(cuenta03.ObtenerNombre());
		System.out.println(cuenta03.ObtenerCuenta());
		System.out.println(cuenta03.estado());
		System.out.println(cuenta03.obtenerTipoDeInteres());
	}

}
