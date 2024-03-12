package etc_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectionPage {
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	
	public RedirectionPage(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
	}
	
	public void goMain(String msg) {
		request.setAttribute("move", "/alienProtector/");
		request.setAttribute("msg", msg);
	}
	
	public void movePage(String msg, String url) {
		request.setAttribute("move", url);
		request.setAttribute("msg", msg);
	}
	
	
	
}
