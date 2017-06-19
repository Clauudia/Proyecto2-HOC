package jar;

//Clase para las funciones auxiliares que se requieran
public class Funciones{
	
	//función heaviside 
	public static int heaviside(double x){
		if(x >= 0)
			return 1;
		return 0;
	}


	 //función que calcula el factorial de un número n
	 public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    } 

}