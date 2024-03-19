package notice_p;

import java.util.ArrayList;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.NoticeService;

public class NoticePatrolList implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HttpSession session = request.getSession();
			WorkerDTO res = (WorkerDTO)session.getAttribute("Worker");
			String id = res.getId();
			
			
			ArrayList<NoticeDTO> listData = new NoticeDAO().list();
			request.setAttribute("noticeData", listData);
		} catch(NullPointerException e) {
			new RedirectionPage(request, response).goMain("로그인 해주세요.");
		}
		
	
	}
}
