package jar;

import java.util.*;

public class Optimizacion{

	private static double t0 = 0; //Tiempo inicial en segundos
	private static double tamAuto = 3.33; //Tamaño de un auto estándar en metros.
	//public static int capacidad = Math.floor(calle.longitud/tamAuto)*3; //Cálculo aproximado de la capacidad de una calle o tramo. 
	public static double tiempoAmarillo = 3; //Tiempo en segundos en que el semáforo está en amarillo, este tiempo siempre es fijo y varía entre los 3 y 4 segundos, en este caso usaremos 3 segundos.
	public static double tiempoRojo = 0; //Tiempo en segundos en que el semáforo está en rojo.
	public static double tiempoMinVerde = 15; //Cota mínima en que el semáforo está en verde.
	public static double tiempoMaxVerde = 120; //Cota máxima en que el semáforo está en rojo.
	public static int longitud = 0; //longitud de la cola 
	public static int hw = 2; //avance entre los vehículos a medida que salen de la intersección
	public static double lambda = 0.166666667; //entrada de autos por hora
	
	public double tasaEntrada(int x){
		return (lambda/(1-lambda*hw))*Math.pow(Math.E, (-lambda/(1-lambda*hw)))*Funciones.heaviside(x-hw);
	}

	//Método con el cuál calculamos cuántos autos avanzan con cada ciclo del semáforo
	public double tasaDeSalida(double t1, double t2, Semaforo sem1, Semaforo sem3){
		if(sem1.estaEnVerde() || sem3.estaEnVerde()){
			return Math.min(longitud, 1 + Math.floor((t2-t1)/hw));
		}
		return 0;
	}

	public double tiempoLlegada(double t0){
		double random = new Random().nextDouble(); //Generamos un número aleatorio entre 0 y 1
		return t0 + hw -((1/lambda)-hw)*Math.log(random);
	}

	//probabilidad de n entradas de autos en t segundos modelado con una variable aleatoria poisson
	public double probabilidadLlegadas(int t, int n){
		return (Math.pow(lambda*t, n)*Math.pow(Math.E, -(lambda*t)))/Funciones.factorial(n);
	}

	//Demora total de los autos
	public int demora(double t2, double t1, int q){
		return q*(t2-t1)+((lambda*Math.pow(t2-t1, 2))/2);
	}
 
}
