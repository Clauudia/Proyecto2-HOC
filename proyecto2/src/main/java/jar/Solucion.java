package jar;

public class Solucion{

	private int[] solucion;
	private double valor;
	public static final double fcosto = 2;
	private static double mejora = (valor*100)/tiempoInicial;

	public Solucion(int[] solucion){
		this.solucion = solucion;
		this.valor = this.obtenTiempo();
	}

	public Solucion(int[] solucion, double v){
		this.solucion = solucion;
		this.valor = v;
	}

	/*public Solucion vecino(){
		int x = 0;
		int y = 0;

		while(x == y){
			x = BusquedaTabu.random.nextInt(solucion.length);
			y = BusquedaTabu.random.nextInt(solucion.length);

		}

		int[] nSolucion = new int[solucion.length];
		System.arraycopy(solucion, 0, nSolucion, 0, solucion.length);
		double nValor = this.valor;

	if(x-1 >= 0)
	    nValor -= costo(nSolucion[x-1], nSolucion[x])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	if(y-1 >= 0)
	    nValor -= costo(nSolucion[y-1], nSolucion[y])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	if(x+1 < nSolucion.length)
	    nValor -= costo(nSolucion[x], nSolucion[x+1])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	if(y+1 < nSolucion.length)
	    nValor -= costo(nSolucion[y], nSolucion[y+1])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
		int temp = nSolucion[x];
		nSolucion[x] = nSolucion[y];
		nSolucion[y] = temp;
	if(x-1 >= 0)
	    nValor += costo(nSolucion[x-1], nSolucion[x])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	if(y-1 >= 0)
	    nValor += costo(nSolucion[y-1], nSolucion[y])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	if(x+1 < nSolucion.length)
	    nValor += costo(nSolucion[x], nSolucion[x+1])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	if(y+1 < nSolucion.length)
	    nValor += costo(nSolucion[y], nSolucion[y+1])/(Optimizacion.probabilidadLlegadas(x, y)*Optimizacion.tiempoLlegada(double t0));
	return new Solucion(nSolucion, nValor);

	}*/

	public double getValor(){
		return this.valor;
	}

	public int[] getSolucion(){
		return this.solucion;
	}

	public double obtenTiempo(){
		return 0;
	}

	@Override public String toString(){
		String r = "";
		r += "Tiempo:" + this.getValor() "\n";
		r += "Mejora:" + mejora + "%" "\n";
		for(int s: this.solucion)
			r += Semaforo.getNombre() + s + ",";
		r += "\n";
		return r;
	}
}