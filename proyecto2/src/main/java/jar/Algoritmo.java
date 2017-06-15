package jar;

public class Algoritmo{

	private static double t0 = 0; //Tiempo inciial en segundos
	private static double tamAuto = 3.33; //Tamaño de un auto estándar en metros.
	private static Calle calle = new Calle();
	private static Semaforo sem1 =  new Semaforo();
	private static Semaforo sem2 = new Semaforo();
	private static Semaforo sem3 = new Semaforo();
	private static int capacidad = Math.floor(calle.longitud/tamAuto)*3; //Cálculo aproximado de la capacidad de una calle o tramo. 
	private static double tiempoAmarillo = 3; //Tiempo en segundos en que el semáforo está en amarillo, este tiempo siempre es fijo y varía entre los 3 y 4 segundos, en este caso usaremos 3 segundos.
	private static double tiempoRojo = 0; //Tiempo en segundos en que el semáforo está en rojo.
	private static double tiempoMinVerde = 0; //Cota mínima en que el semáforo está en verde.
	private static double tiempoMaxVerde = 0; //Cota máxima en que el semáforo está en rojo.


	//Restricción para que no haya 2 o más semáforos en verde al mismo tiempo
	public void aplicaRestriccion(Semaforo sem1, Semaforo sem2, Semaforo sem3){
		while(sem1.estaEnVerde() == true){ 
			sem2.estaEnVerde() == false;
			sem3.estaEnVerde() == false;
		}

		while(sem2.estaEnVerde() == true){
			sem1.estaEnVerde() == false;
			sem3.estaEnVerde() == false;
		}

		while(sem3.estaEnVerde() == true){
			sem1.estaEnVerde() == false;
			sem2.estaEnVerde() == false;
		}
	}

	//Tiempo en segundos en que el semáforo está en verde.
	public double TiempoVerde(){
		return 0;
	}


	//Condición de paro por máximo número de iteraciones.
	public void detener(){
		if(iteraciones == maxIteraciones || Soulucion<> solucionActual == Solucion<> mejorSolucion){
			
		} 
	}
}