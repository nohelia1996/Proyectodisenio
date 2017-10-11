package controladores;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.*;

/**
 * Servlet implementation class ControladorAgregarEntidad
 */

public class ControladorAgregarEntidad extends HttpServlet {

		private static final long serialVersionUID = 1L;
	       
		private String nombreEntidad;
		private String descripcionEntidad;
		private String tipoEntidad;
		
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ControladorAgregarEntidad() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			nombreEntidad = request.getParameter("nombreEntidad");
			descripcionEntidad = request.getParameter("descripcionEntidad");
			tipoEntidad=request.getParameter("tipoEntidad");
			
			if(nombreEntidad.equals("")||descripcionEntidad.equals("")||tipoEntidad.equals("")){
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Error, se deben completar los campos de:');");
				out.println("alert('Nombre Entidad');");
				out.println("alert('Descripci�n');");
				out.println("alert('Tipo');");
				out.println("location='RegistrarEntidad.jsp';");
				out.println("</script>");
				
			}
			else{
				
				ConexionDB conexion= new ConexionDB();
				java.sql.Connection conn= conexion.getConexion();
				Statement st;
				String query="{call agregarEntidad('"+nombreEntidad+"', '"+descripcionEntidad+"', '"+tipoEntidad+"')}";
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
				out.println("confirm('Se registrará una nueva entidad');");
				out.println("location='Menu.jsp';");
				out.println("</script>");
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}


}
