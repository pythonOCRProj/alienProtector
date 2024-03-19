package dashboard_p;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao_p.DashBoardDAO;
import dao_p.WorkerDAO;
import dto_p.CommuteDTO;
import dto_p.PatrolDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashUtills {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfY = new SimpleDateFormat("yyyy-MM-dd 20:00:00");
	private Calendar today = Calendar.getInstance();    
	private String todayStr = sdf.format(today.getTime());
	
	

	
	public DashUtills(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		System.out.println("DashUtills");
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
				WorkerDTO res = new WorkerDTO();
				res.setId(request.getParameter("id"));
				res = new WorkerDAO().getWorkerInfo(res);
				request.setAttribute("dto", res);
			}
		}catch (NullPointerException e) {
			System.out.println("Exception (WorkerModify) - dto 값 없음");
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
	}
	public void getTodayGo() {		
		today.add(Calendar.DATE, -1);
		String yesterdayStr = sdfY.format(today.getTime());
		ArrayList<CommuteDTO> dto = new DashBoardDAO().todayGo(yesterdayStr);
		request.setAttribute("todayGo", dto);
	}
	public void getTodayLeave() {	
		
		ArrayList<CommuteDTO> dto = new DashBoardDAO().todayLeave(todayStr);
		request.setAttribute("todayLeave", dto);
	}
	public void getTodayPatrol() {			
		ArrayList<PatrolDTO> dto = new DashBoardDAO().todayPatrol(todayStr);
		request.setAttribute("todayPatrol", dto);
		today.add(Calendar.DATE, 1);
		request.setAttribute("clockDate", new SimpleDateFormat("yyyy-MM-dd(E)").format(today.getTime()));
	}
}
