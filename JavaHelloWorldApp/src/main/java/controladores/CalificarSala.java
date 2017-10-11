package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CalificarSala
 */
public class CalificarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int idCalificacion;
	private String comentario;
	private int calificacion;
	private String sala;
	private ConexionDB conexion;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalificarSala() {
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
		idCalificacion = generarCodigo();
		comentario = request.getParameter("comentario");
		calificacion=Integer.parseInt(request.getParameter("calificacion"));
		sala=request.getParameter("sala");
		
		if( comentario.equals("")||calificacion==0 || sala.equals("")){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Error, se deben completar los campos del registro');");
			out.println("location='CalificarSala.jsp';");
			out.println("</script>");
			
		}
		else{
			
			conexion= new ConexionDB();
			java.sql.Connection conn= conexion.getConexion();
			Statement st;
			String query="CALL calificarSala("+idCalificacion+", '"+comentario+"', "+calificacion+", '"+sala+"');";
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
			out.println("confirm('Gracias por su evaluación');");
			out.println("location='CalificarSala.jsp';");
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
	
	protected int generarCodigo(){
		int codigo = (int) (Math.random() * 9999) + 1;
		return codigo;
	}

}
