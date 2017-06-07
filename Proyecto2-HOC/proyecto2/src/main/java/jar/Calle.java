package jar;

//Clase que representa las calles
Public class Calle{
	
	public int id;
	public String nombre;
	public int nSemaforos; //numero de semaforos que tiene la calle. 
	public int nIntersecciones; //número de intersecciones que tiene la calle.
	public int nCoches; //número de coches que se juntan en la calle en un cierto intervalo de tiempo.
	public double longitud; //longitud en metros del tramo.
	public int capacidad; //Número máximo de autómoviles por tramo.
	public boolean esLineal; //Tipo de flujo.
	public boolean esDivergente; //Tipo de flujo.

	//Constructor de la clase
	public Calle(int id,int nombre,int nSemaforos, int nIntersecciones, int nCoches, double longitud, int capacidad){
		this.id = id;
		this.nombre = nombre;
		this.nSemaforos = semaforos;
		this.nIntersecciones = nIntersecciones;
		this.nCoches = nCoches;
		this.longitud = longitud;
		this.capacidad = capacidad;
	}

}