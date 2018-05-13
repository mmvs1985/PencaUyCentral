package penca.uy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 TorneoPersistenceRemote bean;
	
    public TorneoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Torneo t = new Torneo("Copa LiguilladeServlet", "copa", new Date());
		bean.crearTorneo(t);
		PrintWriter pw=response.getWriter();
		 pw.println("Cree el torneo");
		 Torneo t1 =bean.obtenerTorneo(25);
		 Torneo t2 =bean.obtenerTorneo(1);
		 Torneo t3 =bean.obtenerTorneo(36);
		 Torneo t4 =bean.obtenerTorneo(23);
		 Torneo t5 =bean.obtenerTorneo(38);
		 
		 pw.println("obtuve el torneo "+t1.getNombre());
		 pw.println("obtuve el torneo "+t2.getNombre());
		 pw.println("obtuve el torneo "+t3.getNombre());
		 pw.println("obtuve el torneo "+t4.getNombre());
		 pw.println("obtuve el torneo "+t5.getNombre());
		 
		 
		 pw.close();
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
