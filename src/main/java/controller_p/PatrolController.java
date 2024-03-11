package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.PatrolService;

import java.io.IOException;

/**
 * Servlet implementation class WorkerController
 */
@WebServlet("/patrol/*")
public class PatrolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatrolController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = "patrol/";
		String service = request.getRequestURI().substring((request.getContextPath()+"/"+cate).length());
		System.out.println(cate+service);
		
		request.setAttribute("incUrl", cate+service+".jsp");
		try {
		
			PatrolService ser = (PatrolService)Class.forName("patrol_p."+service).newInstance(); //다형
			ser.service(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/templateSecurity.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
