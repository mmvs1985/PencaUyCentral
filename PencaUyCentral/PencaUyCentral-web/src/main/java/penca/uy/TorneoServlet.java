package penca.uy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.interfaces.FasePersistenceRemote;
import beans.interfaces.TorneoPersistenceRemote;
import entidades.Torneo;

/**
 * Servlet implementation class TorneoServlet
 */
@WebServlet("/TorneoServletEJB")
public class TorneoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
	 @EJB
	 TorneoPersistenceRemote torneoBean;
	 @EJB
	 FasePersistenceRemote faseBean;
	
    public TorneoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw=response.getWriter();
		
		 pw.println("Voy a obtener el torneo de la copa mundial");
		 Torneo t = torneoBean.obtenerTorneoPorNombre("mundial");
		 
		 pw.println("Este es el torneo "+t.getId()+" el nombre "+t.getNombre()+" la fecha "+t.getComienzo());
		 
		
		 
		 pw.close(); 
		 
		 //List<Torneo> torneos = torneoBean.obtenerTodos();
		 //pw.println("obuve todos ");
		 
		 /*
		 int i = torneos.size();
		 pw.println("tamaño  "+i);

		 Torneo t;
		 for (int j = 1; j < i ; j++) {
			 t = torneos.get(j);
			 
			 pw.println(j+") Torneo - " + t.getNombre());
			 
           
         }
         */
		 //pw.println("Cree la fase fase de grupos");
		
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
