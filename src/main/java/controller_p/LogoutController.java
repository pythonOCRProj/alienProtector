package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LoginService;
import service_p.LogoutService;

import java.io.IOException;

@WebServlet("/logout/*")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String incFolder = "logout/";
		String incJsp = request.getRequestURI().substring((request.getContextPath()+"/"+incFolder).length());
		System.out.println(incJsp);
		request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		try {
			LogoutService ls = (LogoutService)Class.forName("logout_p."+incJsp).newInstance();
			ls.execute(request, response);
			
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
