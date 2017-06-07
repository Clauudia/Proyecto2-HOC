package src;

public class Algoritmo{

	public double tamAuto = 3.33; //Tamaño de un auto estándar en metros.
	calle Calle = new Calle();
	public int capacidad = Math.floor(calle.longitud/tamAuto)*2; //Cálculo aproximado de la capacidad de una calle o tramo. 
	
	public double TiempoVerde(){
		return 0;
	}

	public double TiempoAmarillo(){
		return 0;
	}

	public double TiempoRojo(){

	}

	//Método que nos dice si dos calles se intersectan
	public boolean seIntersectan(Calle x, Calle y){
		return false;
	} 	
}