package controladores;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class CargarUsuarios
 */
@WebServlet("/CargarUsuarios")
public class CargarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		URLEncoder.encode(" ", "UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		String nombreEntidad = request.getParameter("nombreEntidad");
		
		ConexionDB conexion = ConexionDB.obtenerConexion();
		
		java.sql.Connection conn= conexion.getConnection();
		Statement st;
		String query="{call verUsuarios('"+nombreEntidad+"')}";
		try {
			st=conn.createStatement();
			ResultSet resultado = st.executeQuery(query);
			ArrayList<String> listaUsuarios = new ArrayList<String>();
			String nombre = " ";
			while(resultado.next()){
				nombre = resultado.getString("nombreUsuario");
				listaUsuarios.add(nombre);
			}
			nombre= nombre.replaceAll(" ", "");
			
			request.setAttribute("listaUsuarios", listaUsuarios);
			request.getRequestDispatcher("VerUsuarios.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
