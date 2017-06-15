package jar;

//Clase para representar un semáforo 
public class Semaforo{

	public boolean verde;
	public boolean amarillo;
	public boolean rojo;

	//Constructor de la clase
	public Semaforo(boolean verde, boolean amarillo, boolean rojo, double tiempoVerde, double tiempoAmarillo, double tiempoRojo){
		this.verde = estaEnVerde();
		this.amarillo = estaEnAmarillo();
		this.rojo = estaEnRojo();		
	}

	public boolean estaEnVerde(){
		return verde;
	}

	public boolean estaEnRojo(){
		return rojo;
	}

	public boolean estaEnAmarillo(){
		return amarillo;
	}

}
