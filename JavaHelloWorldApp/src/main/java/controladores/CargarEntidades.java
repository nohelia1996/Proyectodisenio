package controladores;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicaDeDatos.ConexionDB;


/**
 * Servlet implementation class CargarEntidades
 */
@WebServlet("/CargarEntidades")
public class CargarEntidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConexionDB conexion;
    private ArrayList<String> listaEntidades = new ArrayList<String>();
    private String nombreEntidad = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarEntidades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URLEncoder.encode(" ", "UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/html");
		
		conexion = ConexionDB.obtenerConexion();
		java.sql.Connection conn= conexion.getConnection();
		Statement st;
		String query="{call cargarEntidad()}";
		try{
			st=conn.createStatement();
			ResultSet resultado = st.executeQuery(query);
			while(resultado.next()){
				nombreEntidad = resultado.getString("nombreEntidad");
				listaEntidades.add(nombreEntidad);
			}
			nombreEntidad= nombreEntidad.replaceAll(" ", "");
			request.setAttribute("listaEntidades", listaEntidades);
			request.getRequestDispatcher("verEntidades.jsp").forward(request, response);
		}
		
		catch(SQLException ex){
			ex.printStackTrace();
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
