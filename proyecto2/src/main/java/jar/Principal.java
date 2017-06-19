package jar;

public class Principal{
	public int[] semaforos;

	public static void configuraciónInicial(){
		
	}

	public static void archivo(Solucion solucion, long seed){
		try{
			File file = new File("target/Pruebas" + seed + ".txt");
			file.createNewFile();
			FileWriter fwriter = new FileWriter(file);
			fwriter.write(solucion.toString());
			fwriter.flush();
			fwriter.close();		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args){
		try{
	    	long seed = 28;
	    	configuraciónInicial();
	    	BúsquedaTabu.inicializa(seed);
	    	Solucion s = new Solucion(semaforos);
	    	Solucion sol = BúsquedaTabu.busquedaGuarda(4.0, s);
	    	System.out.println(sol);    
		}catch(Exception e){
	    	System.out.println("no"); 
		}
	}
}