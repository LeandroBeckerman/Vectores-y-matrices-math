/*Supongamos que el paquete se llama vectorMath*/
package vectorMath;

import java.io.*;

public class VectorMath {
	private int longitud;
	private double ar[];

	public VectorMath() {
		this.longitud = 0;
	}

	public VectorMath(int largo) {
		this.longitud = largo;
		this.ar = new double[largo];
	}

	public VectorMath(String path) {
		File Archivo;
		BufferedReader br;
		FileReader fr;
		try {
			Archivo = new File(path);
			fr = new FileReader(Archivo);
			br = new BufferedReader(fr);
			this.longitud = Integer.parseInt(br.readLine());
			this.ar = new double[this.longitud];
			for (int i = 0; i < this.longitud; i++) {
				ar[i] = Integer.parseInt(br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VectorMath suma(VectorMath v1) throws Exception {
		if (this.longitud != v1.longitud) {
			/** lanza la excepcion para arriba */
			throw new Exception();
		}
		VectorMath aux = new VectorMath(this.longitud);
		for (int i = 0; i < this.longitud; i++) {
			aux.ar[i] = this.ar[i] + v1.ar[i];
		}
		return aux;
	}
	
	public VectorMath resta(VectorMath v1) throws Exception {
		if (this.longitud != v1.longitud) {
			/** lanza la excepcion para arriba */
			throw new Exception();
		}
		VectorMath aux = new VectorMath(this.longitud);
		for (int i = 0; i < this.longitud; i++) {
			aux.ar[i] = this.ar[i] - v1.ar[i];
		}
		return aux;
	}
	
	public VectorMath multiplicacion(double escalar){
		VectorMath v1=new VectorMath(this.longitud);
		for(int i=0; i<this.longitud;i++){
			v1.ar[i]=this.ar[i]*escalar;
		}
		return v1;
	}
	
	public VectorMath division(double escalar) throws Exception{
		if(escalar==0){
			throw new Exception();
		}
		return this.multiplicacion(1/escalar);
	}
	
	public double productoPunto(VectorMath v1) throws Exception{
		if(v1.longitud!=this.longitud){
			throw new Exception();
		}
		int acum=0;
		for(int i=0; i<this.longitud;i++){
			acum+=this.ar[i]*v1.ar[i];
		}
		return acum;
	}
	
	public double getNorma(){
		double acumulador=0;
		for(int i=0;i<this.longitud;i++){
			acumulador+=Math.pow(this.ar[i],2);
		}
		return Math.sqrt(acumulador);
	}
	
	public VectorMath vectorNormalizado(){
		VectorMath vmath= new VectorMath(this.longitud);
		double norma=this.getNorma();
		for(int i=0; i<this.longitud;i++){
			vmath.ar[i]=this.ar[i]/norma;
		}
		return vmath;
	}
	
	public int getLongitud(){
		return this.longitud;
	}
	
	public double getElemento(int index) throws Exception{
		if(index-1>this.longitud){
			throw new Exception();
		}
		return this.ar[index];
	}
}
