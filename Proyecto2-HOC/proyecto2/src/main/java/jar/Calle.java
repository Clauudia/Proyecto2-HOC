package jar;

//Clase que representa las calles
public class Calle{
	
	public int id;
	public String nombre;
	public int nSemaforos; //numero de semaforos que tiene la calle. 
	public int nCoches; //número de coches que se juntan en la calle en un cierto intervalo de tiempo.
	public double longitud; //longitud en metros del tramo.
	public int nCarriles; //Número de carrilles.

	//Constructor de la clase
	public Calle(int id,String nombre, int nSemaforos, int nCoches, double longitud, int nCarriles){
		this.id = id;
		this.nombre = nombre;
		this.nSemaforos = nSemaforos;
		this.nCoches = nCoches;
		this.longitud = longitud;
		this.nCarriles = nCarriles;
	}

	public Calle(int id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}

}