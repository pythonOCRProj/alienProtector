package logout_p;

import java.util.Date;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.LogoutService;

public class Logout implements LogoutService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
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
			
		}catch(NullPointerException e) {
			System.out.println("Exception (WorkerModify) - dto 값 없음");
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
	}
}
