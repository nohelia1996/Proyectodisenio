package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrarEncargado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int idEncargado;
	private String nombreEncargado;
	private String fechaNacimiento;
	private String email;
	private String descripcionEncargado;
	private static ConexionDB conexion;
	
	public RegistrarEncargado(){
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		idEncargado=generarCodigo();
		nombreEncargado = request.getParameter("nombreEncargado");
		fechaNacimiento=request.getParameter("fechaNacimiento");
		email=request.getParameter("email");
		descripcionEncargado=request.getParameter("descripcionEncargado");
		
		
		if(nombreEncargado.equals("") || fechaNacimiento.equals("")||email.equals("") || descripcionEncargado.equals("")){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Error, se deben completar los campos del registro');");
			out.println("location='RegistrarEncargado.jsp';");
			out.println("</script>");
			
		}
		else{
			conexion = new ConexionDB();
			java.sql.Connection conn= conexion.getConexion();
			Statement st;
			String query="{call agregarEncargado('"+idEncargado+"', '"+nombreEncargado+"', '"+fechaNacimiento+"', '"+email
					+"','"+descripcionEncargado+"')}";
			try{
				st=conn.createStatement();
				st.executeUpdate(query);
				conn.close();
				st.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			
			out.println("<script type=\"text/javascript\">");
			out.println("confirm('Se registró el encargado "+nombreEncargado+" exitosamente');");
			out.println("location='RegistrarEncargado.jsp';");
			out.println("</script>");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected int generarCodigo(){
		int codigo = (int) (Math.random() * 9999) + 1;
		return codigo;
	}

}
