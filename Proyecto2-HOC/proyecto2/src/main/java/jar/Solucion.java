package jar;

public class Solucion{

	private int[] solucion;
	private double valor;
	public static final double fcosto = 2;
	private static double maximo;

	public Solucion(int[] solucion){
		this.solucion = solucion;
		this.valor = this.obtenCosto();
	}

	public Solucion(int[] solucion, double v){
		this.solucion = solucion;
		this.valor = v;
	}

	public Solucion vecino(){

	}

	public double getCosto(){
		return this.valor;
	}

	public int[] getSolucion(){
		return this.solucion;
	}

	public double obtenCosto(){
		
	}


	public static double costo(int i, int j){

	}

	@Override public String toString(){
		String r = "";
		r += "Tiempo:" + this.getCosto() "\n";
		r += "Mejora:" + "" "\n";
		for(int c: this.solucion)
			r += Semaforo.getNombre() + c + ",";
		r += "\n";
		return r;
	}
}