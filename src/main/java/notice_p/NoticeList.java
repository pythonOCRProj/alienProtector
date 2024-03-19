package notice_p;

import java.util.ArrayList;

import dao_p.NoticeDAO;
import dao_p.WorkerDAO;
import dto_p.NoticeDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.NoticeService;

public class NoticeList implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("에일리언 노티스리스트 진입");
	
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
