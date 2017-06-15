package jar;

//Clase para representar un semáforo 
public class Semaforo{

	public String nombre;
	public boolean verde;
	public boolean amarillo;
	public boolean rojo;

	//Constructor de la clase
	public Semaforo(String nombre, boolean verde, boolean amarillo, boolean rojo){
		this.verde = estaEnVerde();
		this.amarillo = estaEnAmarillo();
		this.rojo = estaEnRojo();		
	}

	public String getNombre(){
		return nombre;
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

	public void restriccion(){	
		while(estaEnVerde() == true){
			estaEnAmarillo() == false;
			estaEnRojo() == false;
		}
		
		while(estaEnRojo() == true){
			estaEnAmarillo() == false;
			estaEnVerde() == false;
		}	

		while(estaEnAmarillo() == true){
			estaEnVerde() == false;
			estaEnRojo() == false; 
		}
	}
}
