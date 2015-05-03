package vectorMath;

//import java.io.*;
//import java.util.Scanner;

public class Matriz {
	int filas;
	int columnas;
	double matriz[][];

	// private Scanner lectura;

	public Matriz() {
		this.filas = 0;
		this.columnas = 0;
	}

	public Matriz(int rows, int cols) {
		this.filas = rows;
		this.columnas = cols;
		this.matriz = new double[this.filas][this.columnas];
	}

	public Matriz suma(Matriz mat) throws Exception {
		if (this.filas != mat.filas || this.columnas != mat.columnas) {
			throw new Exception();
		}
		Matriz m1 = new Matriz(this.filas, this.columnas);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				m1.matriz[i][j] = new Double(this.matriz[i][j]
						+ mat.matriz[i][j]);
			}
		}
		return m1;
	}

	public Matriz resta(Matriz mat) throws Exception {
		if (this.filas != mat.filas || this.columnas != mat.columnas) {
			throw new Exception();
		}
		Matriz m1 = new Matriz(this.filas, this.columnas);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				m1.matriz[i][j] = new Double(this.matriz[i][j]
						- mat.matriz[i][j]);
			}
		}
		return m1;
	}

	public Matriz multiplicacion(double escalar) {
		Matriz m1 = new Matriz(this.filas, this.columnas);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.filas; j++) {
				m1.matriz[i][j] = escalar * this.matriz[i][j];
			}
		}
		return m1;
	}

	public Matriz multiplicacion(Matriz m1) throws Exception {
		if (this.columnas != m1.filas) {
			throw new Exception();
		}
		Matriz m2 = new Matriz(this.filas, m1.columnas);
		for (int k = 0; k < m2.filas; k++) {
			for (int i = 0; i < m2.columnas; i++) {
				for (int j = 0; j < this.columnas; j++) {
					m2.matriz[k][i] = this.matriz[i][j] * m1.matriz[j][i];
				}
			}
		}
		return m2;
	}

	public Matriz multiplicacion(VectorMath vmath) throws Exception {
		if (this.filas != vmath.getLongitud() && this.columnas == 1) {
			throw new Exception();
		}
		Matriz m2 = new Matriz(this.filas, vmath.getLongitud());
		for (int i = 0; i < m2.filas; i++) {
			for (int j = 0; j < m2.columnas; j++) {
				m2.matriz[i][j] = this.matriz[j][i] * vmath.getElemento(j);
			}
		}
		return m2;
	}

	public void restarFilas(int minuendo, int sustraendo) {
		for (int i = 0; i < this.columnas; i++) {
			this.matriz[minuendo][i] -= this.matriz[sustraendo][i];
		}
	}

	public void dividirFila(int a, double cociente) {
		for (int i = 0; i < this.columnas; i++) {
			this.matriz[a][i] /= cociente;
		}
	}

	public void cargarMatriz() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				this.matriz[i][j] = (double) i + j;
			}
		}
	}

	public void mostrarMatriz() {
		for (int i = 0; i < this.filas; i++) {
			String cadena = "";
			for (int j = 0; j < this.columnas; j++) {
				cadena += Double.toString(this.matriz[i][j]) + "  |";
			}
			System.out.println(cadena);
		}
	}

	public double getFila() {
		return this.filas;
	}

	public double getColumna() {
		return this.columnas;
	}

	public Matriz getMatrizTranspuesta() {
		Matriz m2 = new Matriz(this.columnas, this.filas);
		for (int i = 0; i < m2.filas; i++) {
			for (int j = 0; j < m2.columnas; j++) {
				m2.matriz[i][j] = this.matriz[j][i];
			}
		}
		return m2;
	}
	
	
	/**************************************************
	 * Solo sirve para matrices que estan trianguladas* 
	 **************************************************/

	public boolean intercambiarFilas(int columnaARevisar){
		int filaSinCero=columnaARevisar+1;
		while( filaSinCero <this.filas && this.matriz[filaSinCero++][columnaARevisar]!=0){
		}
		if(this.filas <= filaSinCero )
			return false;
		
		double auxiliar;
		for(int i =columnaARevisar; i<this.columnas;i++){
			auxiliar=this.matriz[filaSinCero][i];
			this.matriz[filaSinCero][i]=this.matriz[columnaARevisar][i];
			this.matriz[columnaARevisar][i]=auxiliar;
		}
		return true;
	}

	public Matriz matrizInversa throws Exception(){
		if(this.filas!=this.columnas)
			return new Matriz(this.filas,this.columnas);
		Matriz m2 = new Matriz(this.filas, this.columnas * 2);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				m2.matriz[i][j] = this.matriz[i][j];
			}
		}
		for (int i = 0; i < this.filas; i++) {
			m2.matriz[i][this.columnas + i] = 1;
		}
		for (int i = 0; i < this.filas; i++) {
			if(this.matriz[i][i] !=0 || this.intercambiarFilas(i)){
				this.dividirFila(i, this.matriz[i][i]);
			}
			else{
					
					Matriz mReturn=new Matriz(this.filas,this.columnas);
					for(int k=0;k<mReturn.filas;k++){
						for(int j=0;j<mReturn.columnas;j++){
							this.matriz[k][j]=0;
					}
					throw new Exception();
				}
			}
		return m2;
	}

	/*
	 * public Matriz multiplicacion(Matriz m1) throws Exception{
	 * 
	 * 
	 * 
	 * ///matrizResultante }
	 */

	/*
	 * public String toString(){ String cadena=new String(); for(int
	 * i=0;i<this.columnas;i++){ for(int j=0; j<this.columnas;j++){
	 * cadena+=Double.toString(matriz[i][j]); } } return cadena; }
	 */
	}
}
