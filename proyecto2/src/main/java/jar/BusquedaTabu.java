package jar;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


//Clase que implementa la heurística búsqueda tabú
public class BusquedaTabu{

	public static ListaTabu listaTabu;
	public static Solucion solucion;
	public static Random random = new Random();
	public static Semaforo[] semaforos;
	public static long semilla;
	public static double epsilon = 0.0001;
	public static double epsilonp = 0.0001;
	public static double phi = 0.9;
	public static int l = 500;
	public static Conexion connection;

	public BusquedaTabu(ListaTabu listaTabu, Solucion solucion){
		this.listaTabu = listaTabu;
		this.solucion = solucion;		
	}

	public BusquedaTabu(Solucion solucionInicial){
		Solucion mejorSolucion = solucionInicial;
		Solucion solucionActual = solucionInicial;

		int iteracionActual = 0;

		while (optimizacion.detener(++iteracionActual, mejorSolucion)) {
			
			List<Solucion> vecinos = solucionActual.obtenVecinos;
			List<Solucion> solucionesEnTabu = IteratorUtils.toList(listaTabu.iterator());
			
			Solucion mejorVecino = solucion.encuentraVecino(vecinos, solucionesEnTabu);
			if (encuentraVecino.obtenValor() < mejorSolucion.obtenValor()) {
				mejorSolucion = mejorVecino;
			}
			
			tabuList.agrega(solucionActual);
			solucionActual = mejorVecino;
			
			listaTabu.actualizaTamaño(iteracionActual, mejorSolucion);
		}
		
		return mejorSolucion;
	}

	public static Conexion getConexion(){
		if(connection == null || !connection.valida())
	    	return new Conexion();
		return connection;
	}

	public static void semaforos(){
		connection = getConexion();
		ResultSet resultSet = null;
		try{
			int tam = getTam();
			ciudades = new Semaforo[tam+1];
			resultSet = connection.consulta("SELECT * FROM semaforos");
			while(resultSet.next()){
				Semaforo f = new Semaforo(resultSet.getInt("id"), resultSet.getString("name"));
				ciudades[c.getId()] = f;
			}
		} catch(SQLException e){
			System.out.println(e.getMessage());
		} finally{
			try{
				if(resultSet != null)
					resultSet.close();
			} catch (Exception e){

			};
		}
	}

	public static void inicializa(long sem){
		semilla = sem;
		random = new Random(sem);
		semaforos();
		connection.cierraConexion();
	}

	public static Solucion busquedaGuarda(double temperatura, Solucion solucion){
	Solucion minima = solucion; 
	try{
	    File file = new File("Pruebas/Semilla" + semilla + ".txt"); 
	    file.createNewFile();
	    FileWriter writer = new FileWriter(file, true);   
	    double p = Double.MAX_VALUE; 
	    double p1; 
	    while(temperatura > epsilon){
		p1 = 0;
		while(Math.abs(p-p1) > epsilonp){
		    p1 = p;
		    writer.write("E: "+ solucion.getCosto() + "\n"); 
		    if(solucion.getCosto() < minima.getCosto()){
			minima = solucion;
		    }
		}
		temperatura *= phi; 
	    }
	    writer.flush();
	    writer.close();
	}catch(IOException e){
	    System.out.println("guarda");
	}
		return minima;
	}

	public static int getTam(){
	connection = getConexion();
	int tam = -1;
	ResultSet resultSet = connection.consulta("SELECT COUNT(*) FROM semaforos"); 
       	try{
	    tam = resultSet.getInt(1);
	}catch(SQLException e){
	    System.out.println(e.getMessage());
	}finally{
	    try { 
	    	if (resultSet != null) resultSet.close(); 
	    } catch (Exception e) {
	    	};
		}
		return tam;
	}

	public double getCosto(){
		return 0;
	}


}
	