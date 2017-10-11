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
 * Servlet implementation class CargarSalas
 */
@WebServlet("/CargarSalas")
public class CargarSalas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarSalas() {
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
			
				String identificador = request.getParameter("identificador");
				
				ConexionDB conexion = ConexionDB.obtenerConexion();
				
				java.sql.Connection conn= conexion.getConnection();
				Statement st;
				String query="select idSala, nombreSala, capacidad, descripcionSala from salasReuniones where idSala= '"+identificador+"';";
				try {
					st=conn.createStatement();
					ResultSet resultado = st.executeQuery(query);
					ArrayList<String> listaSala = new ArrayList<String>();
					String nombre = " ";
					while(resultado.next()){
						nombre = resultado.getString("nombreSala");
						listaSala.add(nombre);
					}
					nombre= nombre.replaceAll(" ", "");
					
					request.setAttribute("listaSala", listaSala);
					request.getRequestDispatcher("VerSalas.jsp").forward(request, response);
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
