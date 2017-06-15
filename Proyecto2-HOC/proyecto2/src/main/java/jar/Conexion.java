package jar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//Clase para la conexion a la base de datos que aún no tengo.
public class Conexion{

static Connection connection = null;
	static Statement statement = null;	

	public Conexion(){   
       try{
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:db/semaforos.db");
		statement = connection.createStatement();
		}catch(Exception e){		
		System.out.println(e.getClass().getName() + ": " + e.getMessage());
		System.exit(0);
		}
	}


	public ResultSet consulta(String consulta){
		ResultSet resultSet = null;
		try{
	    	resultSet = statement.executeQuery(consulta);
		}catch(SQLException e){
	    	System.err.println(e.getMessage());
		}
		return resultSet;

	}

	public boolean valida(){
	try{
	    return this.connection.isValid(0);
		}catch(SQLException e){
	    	return false;
			}
    }

    public void cierraConexion(){
		try { 
			if (statement != null) statement.close(); 
		} catch (Exception e) {
			};
		try { 
			if (connection != null) connection.close(); 
		} catch (Exception e) {

			};
	}
	
}