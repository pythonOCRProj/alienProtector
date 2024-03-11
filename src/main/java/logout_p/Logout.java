package logout_p;

import java.util.Date;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.LogoutService;

public class Logout implements LogoutService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
		dto.setLeaveTime(new Date());
		
		if(new WorkerDAO().getOutWork(dto) != 0) {
			request.setAttribute("msg", "퇴근하였습니다. 고생하셨습니다.");
			request.setAttribute("move", "/alienProtector/");
			request.getSession().invalidate();
		}else {
			request.setAttribute("msg", "더 일해라 노예야!");
			request.setAttribute("move", "/alienProtector/dashboard");
			
		}
		
	}
}
