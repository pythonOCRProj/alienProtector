package dashboard_p;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashUtills {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public DashUtills(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

	}
}
