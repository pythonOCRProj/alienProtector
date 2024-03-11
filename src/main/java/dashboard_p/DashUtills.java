package dashboard_p;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao_p.DashBoardDAO;
import dto_p.CommuteDTO;
import dto_p.PatrolDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashUtills {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date today = new Date();
	private String todayStr = sdf.format(today);
	
	
	
	public DashUtills(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	public void getTodayGo() {		
		ArrayList<CommuteDTO> dto = new DashBoardDAO().todayGo(todayStr);
		request.setAttribute("todayGo", dto);
	}
	public void getTodayLeave() {		
		ArrayList<CommuteDTO> dto = new DashBoardDAO().todayLeave(todayStr);
		request.setAttribute("todayLeave", dto);
	}
	public void getTodayPatrol() {		
		ArrayList<PatrolDTO> dto = new DashBoardDAO().todayPatrol(todayStr);
		request.setAttribute("todayPatrol", dto);
	}
}
