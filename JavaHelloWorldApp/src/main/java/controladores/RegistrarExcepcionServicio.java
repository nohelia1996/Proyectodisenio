package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrarExcepcionServicio
 */
@WebServlet("/RegistrarExcepcionServicio")
public class RegistrarExcepcionServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Date fechaInicio;
	private Date fechaFinalizacion;
	private String horaInicio;
	private String horaFin;
	private String comentario;
	private ConexionDB conexion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarExcepcionServicio() {
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
		SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/yy");
		try {
			fechaInicio = formatoFecha.parse(request.getParameter("fechaInicio"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fechaFinalizacion = formatoFecha.parse(request.getParameter("fechaFinalizacion"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		horaInicio=request.getParameter("horaInicio");
		horaFin=request.getParameter("horaFin");
		comentario=request.getParameter("comentario");
		
		//encargado=Integer.parseInt(request.getParameter("encargado"));
		
		if(fechaInicio.equals("")||fechaFinalizacion.equals("")||horaInicio.equals("")||horaFin.equals("")||comentario.equals("")){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Error, se deben completar todos los campos del registro');");
			out.println("location='RegistrarExcepcionServicio.jsp';");
			out.println("</script>");
			
		}
		else{
			conexion= ConexionDB.obtenerConexion();
			java.sql.Connection conn= conexion.getConexion();
			Statement st;
			String query="{call agregarExepciones('"+fechaInicio+"', '"+fechaFinalizacion+"', '"+horaInicio+"', '"+horaFin+"', '"+comentario+"')}";
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
			out.println("confirm('Se registrara un nueva excepción de servicio');");
			out.println("location='RegistrarExcepcionServicio.jsp';");
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
