package jar;

//Clase que representa las calles
Public class Calle{
	
	public int id;
	public String nombre;
	public int nSemaforos; //numero de semaforos que tiene la calle 
	public int nIntersecciones; //número de intersecciones que tiene la calle
	public int nCoches; //número de coches que se juntan en la calle en un cierto intervalo de tiempo.

	//Constructor de la clase
	public Calle(int id,int nombre,int nSemaforos, int nIntersecciones, int nCoches){
		this.id = id;
		this.nombre = nombre;
		this.nSemaforos = semaforos;
		this.nIntersecciones = nIntersecciones;
		this.nCoches = nCoches;
	}

}