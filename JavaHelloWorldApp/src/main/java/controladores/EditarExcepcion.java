package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexiones.ConexionBD;

/**
 * Servlet implementation class EditarExcepcion
 */
@WebServlet("/EditarExcepcion")
public class EditarExcepcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Date inicio;
	private Date fin;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarExcepcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URLEncoder.encode(" ", "UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String descripcion = request.getParameter("descripcion");
		int encargado= Integer.parseInt(request.getParameter("encargado"));
		inicio = request.getParameter("codigo");
		fin = request.getParameter("codigo");
		
		System.out.println("NOMBRE: " +nombreCurso);
		System.out.println("PROFESOR: " +profesorAsignado);
		System.out.println("CODIGO: " +codigo);
		
		ConexionBD conexion = new ConexionBD();
		ResultSet resultado = conexion.getQuery("CALL actualizarCurso('" + codigo + "','" + nombreCurso + "','" + profesorAsignado + "');");
		
		request.getRequestDispatcher("PrincipalAdministrador.jsp").forward(request, response);
		
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
