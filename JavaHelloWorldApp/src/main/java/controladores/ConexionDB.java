	package controladores;

import java.sql.*;
import java.sql.Connection;

public class ConexionDB {
	/**
	 * Los siguientes atributos realizan conexion con una BD por lo que sus valores no podran presentar alteraciones,
	 * entre estos se encuentran nombre
	 */
	private String _servidor="root";//
	private String _claveServidor="LosQuerubines2017";
	private static String _baseDeDatos="DisenioDeSoftware";
	static String _direccionConexion="jdbc:mysql://35.202.229.255:3306/"+_baseDeDatos;
	private Connection conn=null;
	private static ConexionDB conexion=null;
	
	public static ConexionDB obtenerConexion(){
		if (conexion==null){
			conexion=new ConexionDB();
		}
		return conexion;
	}
	
	public ConexionDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(_direccionConexion, _servidor, _claveServidor);
		}
		catch (SQLException ex){
			System.out.println("No se pudo realizar la conexion");
		}
		catch (ClassNotFoundException ex){
			System.out.print("Error: "+ex);
		}

	}
	public Connection getConexion(){
		return conn;
	}
	
	
	public ResultSet getQuery(String _query){
		Statement state=null;
		ResultSet resultado=null;
		try{
			state=(Statement) conn.createStatement();
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
			state=(Statement) conn.createStatement();
			state.execute(_query);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
