package apagado;

/**
 * @since 21/05/2018
 * @author Alexis Holguin
 */
public class apagado {
	public static void main(String[] args) {
		try {
			switch (args[0]) {
			case "-s":
				apagar();
				break;
			case "-n":
				System.out.println("El computador no se ha apagado");
				break;
			}
		} catch (Exception e) {
			System.out.println("comando para apagar: apagado -s");
		}

	}

	static void apagar() {
		try {
			Runtime.getRuntime().exec("shutdown /s /t 0");
		} catch (Exception e) {
			System.out.println("La sintaxis del comando no es correcta.");
		}

	}

}
