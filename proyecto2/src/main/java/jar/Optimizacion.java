package jar;

public class Optimización{

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
	private static int longitd = 0; //longitud de la cola 
	private static int hw = 2; //avance entre los vehículos a medida que salen de la intersección
	private static int lambda = 1/6; //tasa de entrada de autos por hora

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
	
	public double tasaEntrada(int x){
		return (lambda/(1-lambda*hw))*Math.pow(Math.E, (-lambda/(1-lambda*hw)))*Funciones.heaviside(x-hw);
	}

	//Método con el cuál calculamos cuántos autos avanzan con cada ciclo del semáforo
	public int tasaDeSalida(double t1, double t2){
		if(sem1.estaEnVerde() || sem3.estaEnVerde()){
			return Math.min(longitud, 1 + Math.floor((t2-t1)/hw));
		}
		return 0;
	}

	public double tiempoLlegada(double t1){
		double random = new Random().nextDouble(); //Generamos un número aleatorio entre 0 y 1
		return t1 + hw -((1/lambda)-hw)*Math.log(random);
	}

	//probabilidad de n entradas de autos en t segundos modelado con una variable aleatoria poisson
	public double probabilidadLlegadas(int t, int n){
		return (Math.pow(lambda*t, n)*Math.pow(Math.E, -(lambda*t)))/Funciones.factorial(n);
	}

	//Tiempo en segundos en que el semáforo está en verde.
	public double TiempoVerde(){
		return 0;
	}

	//Demora total de los autos
	public int demora(double t2, double t1, int q){
		return q(t2-t1)+((lambda*Math.pow(t2-t1, 2))/2);
	}


	//Condición de paro por máximo número de iteraciones.
	public void detener(){
		if(iteraciones == maxIteraciones || Soulucion<> solucionActual == Solucion<> mejorSolucion){
			
		} 
	}
}