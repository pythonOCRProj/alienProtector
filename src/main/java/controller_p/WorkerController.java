package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LoginService;
import service_p.LogoutService;
import service_p.WorkerService;

import java.io.IOException;

@WebServlet("/worker/*")
@MultipartConfig()
public class WorkerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public WorkerController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String incFolder = "worker/";
		String incJsp = request.getRequestURI().substring((request.getContextPath()+"/"+incFolder).length());

		request.setAttribute("incUrl", incFolder+incJsp+".jsp");
		try {
			WorkerService ws = (WorkerService)Class.forName("worker_p."+incJsp).newInstance();
			ws.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			dispatcher.forward(request, response);
		} catch (InstantiationException e) {
		
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
