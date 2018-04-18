import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
public class buscaminas{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Random rd = new Random();
	
	public static void main(String[]args) throws IOException{
		System.out.println("de que tamaño quiere que sea el buscaminas");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Cuantas minas quieres");
		int nMines = Integer.parseInt(br.readLine());
		int[][] matrix = new int [n][n];
		int[][] bufferMatrix = new int [n][n];
		RandomFillMine(bufferMatrix,nMines);
		Juego(matrix,bufferMatrix);
		
		
	}
	public static int[][] RandomFillMine(int[][] tablero,int NumberMines){
		for(int x = 0; x < NumberMines;x++){
			int i = rd.nextInt(tablero.length - 1);
			int j = rd.nextInt(tablero.length - 1);
			if(tablero[i][j] == 0){
				tablero[i][j] = 2;
			}
		}
		return tablero;
	}
	public static int[][] PreguntaPosicion(int[][] tablero,int[][] buffer) throws NumberFormatException, IOException {
		int i, j;
		System.out.print("eliga la fila en donde quiere jugar:");
		i = (Integer.parseInt(br.readLine())) - 1;
		System.out.print("eliga la columna en donde quiere jugar:");
		j = (Integer.parseInt(br.readLine())) - 1;
		System.out.println();
		tablero = fillMatrixUser(tablero, i, j,buffer);
		return tablero;
	}
	public static int[][] fillMatrixUser(int[][] tablero, int i, int j,int[][] buffer) throws NumberFormatException, IOException {
		if (buffer[i][j] == 0) {
			buffer[i][j] = 1;
			tablero[i][j] = 1;
		} else if(buffer[i][j] == 1){
			System.out.println("este lugar ya esta ocupado");
			PreguntaPosicion(tablero, buffer);
		} else if (buffer[i][j]==2){
			tablero[i][j]=2;
		}
		return tablero;
	}
	public static void PrintMatrix(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + " |");
			}
			System.out.println();
		}
	}
	public static boolean end(int[][] matrix){
		boolean z = false;
		for(int i = 0; i < matrix.length;i++){
			for(int j = 0; j < matrix.length;j++){
				if(matrix[i][j] == 2){
					z = true;
				}
			}
		}
		return z;
	}
	public static void Juego(int[][] matrix, int[][] bufferMatrix)throws IOException{
		PrintMatrix(matrix);
		while(true){
			PreguntaPosicion(matrix,bufferMatrix);
			PrintMatrix(matrix);
			if(end(matrix) == true){
				System.err.println("has perdido");
				System.out.println("las minas estan:");
				PrintMatrix(bufferMatix);
				break;
			}
		}
		
		
	}
}
