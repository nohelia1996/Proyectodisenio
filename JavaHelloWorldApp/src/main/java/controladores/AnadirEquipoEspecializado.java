package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AnadirEquipoEspecializado
 */
@WebServlet("/AnadirEquipoEspecializado")
public class AnadirEquipoEspecializado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String identificador;
	private String descripcion;
    private String salaDeReunion;
    private static ConexionDB conexion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirEquipoEspecializado() {
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
		identificador = request.getParameter("identificador");
		descripcion = request.getParameter("descripcion");
		salaDeReunion= request.getParameter("salaDeReunion");

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(identificador.equals("")||descripcion.equals("")||salaDeReunion.equals("")){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Error, se deben completar los campos de:');");
			out.println("location='RegistrarEquipoEspecializado.jsp';");
			out.println("</script>");
			
		}
		else{
			
			
			conexion= ConexionDB.obtenerConexion();
			
			java.sql.Connection conn= conexion.getConexion();
			Statement st;
			String query="{call agregarEquipoEspecializado('"+identificador+"', '"+descripcion+"', '"+salaDeReunion+"')}";
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
			out.println("confirm('Se registrará un nuevo activo');");
			out.println("location='RegistrarEquipoEspecializado.jsp';");
			out.println("</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
