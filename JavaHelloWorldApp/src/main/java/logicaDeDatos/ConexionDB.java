package logicaDeDatos;

import java.sql.*;
import java.sql.Connection;

public class ConexionDB {

	private String _servidor;
	private String _claveServidor;
	private String _baseDeDatos;
	private String _direccionConexion;
	private Connection conn=null;
	private static ConexionDB conexion=null;
	
	public static ConexionDB obtenerConexion(){
		if (conexion==null){
			conexion=new ConexionDB();
		}
		return conexion;
	}
	
	public ConexionDB(){
		setServidor("root");
		setClaveServidor("LosQuerubines2017");
		setBaseDeDatos("DisenioDeSoftware");
		setDireccionConexion("jdbc:mysql://35.202.229.255:3306/"+getBaseDeDatos());
		establecerConexion();
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public String getBaseDeDatos(){
		return this._baseDeDatos;
	}

	public void setConnection(Connection pConnection){
		this.conn = pConnection;
	}
	
	public void setServidor(String pServidor){
		this._servidor = pServidor;
	}

	public void setClaveServidor(String pClaveServidor){
		this._claveServidor = pClaveServidor;
	}

	public void setBaseDeDatos(String pBaseDatos){
		this._baseDeDatos = pBaseDatos;
	}
	
	public void setDireccionConexion(String pDireccionConexion){
		this._direccionConexion = pDireccionConexion;
	}
	
	public void establecerConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			setConnection(DriverManager.getConnection(_direccionConexion, _servidor, _claveServidor));
		}
		catch (SQLException ex){
			System.out.println("No se pudo realizar la conexion");
		}
		catch (ClassNotFoundException ex){
			System.out.print("Error: "+ex);
		}
	}
	
	public ResultSet getQuery(String _query){
		Statement state=null;
		ResultSet resultado=null;
		try{
			state=(Statement) getConnection().createStatement();
			resultado=state.executeQuery(_query);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void setQuery(String _query){
		
		Statement state=null;
		try{
			state=(Statement) getConnection().createStatement();
			state.execute(_query);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}