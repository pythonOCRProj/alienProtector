package notice_p;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeDetail implements NoticeService  {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDTO dto = new NoticeDAO().detail(no);
		request.setAttribute("noticeDetail", dto);
		System.out.println("노티스디테일자바 진입");
		
	}
}
