package jar;

//Clase que implementa la heurística búsqueda tabú
public class BusquedaTabu{

	private ListaTabu listaTabu;
	private Solucion solucion;
	private Algoritmo algoritmo;

	public BusquedaTabu(ListaTabu listaTabu, Solucion solucion){
		this.listaTabu = listaTabu;
		this.solucion = solucion;
	}

	public busqueda(Solucion solucionInicial){
		Solucion mejorSolucion = solucionInicial;
		Solucion solucionActual = solucionInicial;

		int iteracionActual = 0;

		while (algoritmo.detener(++iteracionActual, mejorSolucion)) {
			
			List<Solucion> vecinos = solucionActual.obtenVecinos;
			List<Solucion> solucionesEnTabu = IteratorUtils.toList(listaTabu.iterator());
			
			Solution mejorVecino = solucion.encuentraVecino(vecinos, solucionesEnTabu);
			if (encuentraVecino.obtenValor() < mejorSolucion.obtenValor()) {
				mejorSolucion = mejorVecino;
			}
			
			tabuList.agrega(solucionActual);
			solucionActual = mejorVecino;
			
			listaTabu.actualizaTamaño(iteracionActual, mejorSolucion);
		}
		
		return mejorSolucion;
	}
}
	