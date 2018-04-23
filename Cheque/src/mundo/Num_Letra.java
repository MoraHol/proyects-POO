package mundo;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Num_Letra {
	boolean flag = false;

	public Num_Letra() {
		// TODO Apéndice de constructor generado automáticamente
	}

	private String unidad(int numero) {

		String num = null;
		switch (numero) {
		case 9:
			num = "nueve";
			break;
		case 8:
			num = "ocho";
			break;
		case 7:
			num = "siete";
			break;
		case 6:
			num = "seis";
			break;
		case 5:
			num = "cinco";
			break;
		case 4:
			num = "cuatro";
			break;
		case 3:
			num = "tres";
			break;
		case 2:
			num = "dos";
			break;
		case 1:
			if (flag == true) {
				num = "uno";
			} else {
				num = "un";
			}

			break;
		case 0:
			num = "";
			break;
		}
		return num;
	}

	private String decena(int numero) {

		String num_letra = null;
		if (numero >= 90 && numero <= 99) {
			num_letra = "noventa ";
			if (numero > 90) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 90));
			}
		} else if (numero >= 80 && numero <= 89) {
			num_letra = "ochenta ";
			if (numero > 80) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 80));
			}

		} else if (numero >= 70 && numero <= 79) {
			num_letra = "setenta ";
			if (numero > 70) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 70));
			}

		} else if (numero >= 60 && numero <= 69) {
			num_letra = "sesenta ";
			if (numero > 60) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 60));
			}

		} else if (numero >= 50 && numero <= 59) {
			num_letra = "cincuenta ";
			if (numero > 50) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 50));
			}
		} else if (numero >= 40 && numero <= 49) {
			num_letra = "cuarenta ";
			if (numero > 40) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 40));
			}

		} else if (numero >= 30 && numero <= 39) {
			num_letra = "treinta ";
			if (numero > 30) {
				flag = true;
				num_letra = num_letra.concat("y ").concat(unidad(numero - 30));
			}

		} else if (numero >= 20 && numero <= 29) {
			if (numero == 20) {
				num_letra = "veinte ";
			} else {
				flag = true;
				num_letra = "veinti".concat(unidad(numero - 20));
			}
		} else if (numero >= 10 && numero <= 19) {
			switch (numero) {
			case 10:

				num_letra = "diez ";
				break;

			case 11:
				num_letra = "once ";
				break;
			case 12:
				num_letra = "doce ";
				break;
			case 13:
				num_letra = "trece ";
				break;
			case 14:
				num_letra = "catorce ";
				break;
			case 15:
				num_letra = "quince ";
				break;
			case 16:
				num_letra = "dieciseis ";
				break;
			case 17:
				num_letra = "diecisiete ";
				break;
			case 18:
				num_letra = "dieciocho ";
				break;
			case 19:
				num_letra = "diecinueve ";
				break;
			}
		} else {
			num_letra = unidad(numero);
		}
		return num_letra;
	}

	private String centena(int numero) {
		String num_letra = null;
		if (numero >= 100) {
			if (numero >= 900 && numero <= 999) {
				num_letra = "novecientos ";
				if (numero > 900)
					num_letra = num_letra.concat(decena(numero - 900));
			} else if (numero >= 800 && numero <= 899) {
				num_letra = "ochocientos ";
				if (numero > 800)
					num_letra = num_letra.concat(decena(numero - 800));
			} else if (numero >= 700 && numero <= 799) {
				num_letra = "setecientos ";
				if (numero > 700)
					num_letra = num_letra.concat(decena(numero - 700));
			} else if (numero >= 600 && numero <= 699) {
				num_letra = "seiscientos ";
				if (numero > 600)
					num_letra = num_letra.concat(decena(numero - 600));
			} else if (numero >= 500 && numero <= 599) {
				num_letra = "quinientos ";
				if (numero > 500)
					num_letra = num_letra.concat(decena(numero - 500));
			} else if (numero >= 400 && numero <= 499) {
				num_letra = "cuatrocientos ";
				if (numero > 400)
					num_letra = num_letra.concat(decena(numero - 400));
			} else if (numero >= 300 && numero <= 399) {
				num_letra = "trescientos ";
				if (numero > 300)
					num_letra = num_letra.concat(decena(numero - 300));
			} else if (numero >= 200 && numero <= 299) {
				num_letra = "doscientos ";
				if (numero > 200)
					num_letra = num_letra.concat(decena(numero - 200));
			} else if (numero >= 100 && numero <= 199) {
				if (numero == 100)
					num_letra = "cien ";
				else
					num_letra = "ciento ".concat(decena(numero - 100));
			}
		} else
			num_letra = decena(numero);

		return num_letra;
	}

	private String numeroAString(double numero) {
		DecimalFormat df = new DecimalFormat("#.##");
		String number = "";
		int primer;
		primer = (int) (numero / 100000000);
		number += primer;
		numero -= primer * 100000000;
		primer = (int) (numero / 10000000);
		number += primer;
		numero -= primer * 10000000;
		primer = (int) (numero / 1000000);
		number += primer;
		numero -= primer * 1000000;
		primer = (int) (numero / 100000);
		number += primer;
		numero -= primer * 100000;
		primer = (int) (numero / 10000);
		number += primer;
		numero -= primer * 10000;
		primer = (int) (numero / 1000);
		number += primer;
		numero -= primer * 1000;
		primer = (int) (numero / 100);
		number += primer;
		numero -= primer * 100;
		primer = (int) (numero / 10);
		number += primer;
		numero -= primer * 10;
		number += String.valueOf(df.format(numero));

		return number;
	}

	public String numletra(double num) {
		String[] valores;
		String number = numeroAString(num);
		number = number.replace(".", ",");
		if (number.indexOf(",") == -1) {
			number = number + ",00";
		}
		valores = number.split(",");
		String decimas = valores[1];
		String Millon, mil, centenas;
		DecimalFormat df = new DecimalFormat("###,###,###.##");
		number = String.valueOf(df.format(num));
		number = number.replace(".", ",");
		valores = number.split(",");
		number = df.format(num);
		if (num >= 1000000) {
			Millon = centena(Integer.parseInt(valores[0])) + " millones ";
			mil = centena(Integer.parseInt(valores[1])) + " mil ";
			centenas = centena(Integer.parseInt(valores[2]));
		} else {
			Millon = "";
			if (num >= 1000) {
				mil = centena(Integer.parseInt(valores[0])) + " mil ";
				centenas = centena(Integer.parseInt(valores[1]));
			} else {
				mil = "";
				centenas = centena(Integer.parseInt(valores[0]));
			}
		}
		String numero = Millon + mil + centenas + " " + decimas + "/100 pesos";
		return numero;
	}
}
