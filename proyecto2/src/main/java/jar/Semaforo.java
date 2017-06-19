package jar;

//Clase para representar un semáforo 
public class Semaforo{

	public int id;
	public String nombre;

	//Constructor de la clase
	public Semaforo(int id, String nombre){
		this.id = id;
		this.nombre = nombre;		
	}

	public String getNombre(){
		return nombre;
	}

	public int getId(){
		return id;
	}

}
