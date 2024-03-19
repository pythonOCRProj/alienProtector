package notice_p;

import dao_p.NoticeDAO;

import dto_p.NoticeDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service_p.NoticeService;

public class NoticeDetail implements NoticeService  {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		try {
			
		
		HttpSession session = request.getSession();
		WorkerDTO res = (WorkerDTO)session.getAttribute("Worker");
		String id = res.getId();
		int no = Integer.parseInt(request.getParameter("no"));

		new NoticeDAO().noticeCnt(no);
		NoticeDTO dto = new NoticeDAO().detail(no);
		
//		System.out.println(dto.getId());
		request.setAttribute("noticeDetail", dto);
		} catch(NullPointerException e) {
			new RedirectionPage(request, response).goMain("로그인 해주세요.");
		}
		
		
	}
}
