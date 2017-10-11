package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControladorValidarEncargado
 */
@WebServlet("/ControladorValidarEncargado")
public class ControladorValidarEncargado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String correo;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorValidarEncargado() {
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
		
		correo = request.getParameter("correo");
		
		
		if (correo==""){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Se deben completar todos los espacios');");
			out.println("location='LogginEncargado.jsp';");
			out.println("</script>");
		}

		else{
			ConexionDB conexion= new ConexionDB();
			java.sql.Connection conn= conexion.getConexion();
			Statement st;
			String query="call validarIngresoEncargado('" + correo + "')";
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
			out.println("confirm('Se va a iniciar sesión');");
			out.println("location='MenuEncargado.jsp';");
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
