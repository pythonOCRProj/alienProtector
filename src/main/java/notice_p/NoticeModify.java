package notice_p;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModify implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("노티스 모디파이 자바 진입");
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDTO dto = new NoticeDAO().detail(no);
		request.setAttribute("ModifyData", dto);
		
	}
}
