package notice_p;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeWriteReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("NoticeWriteReg 자바 진입");
		
		NoticeDTO dto =new NoticeDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		new NoticeDAO().write(dto);
		
		int no = new NoticeDAO().newNo();
		
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		request.setAttribute("msg", "작성되었습니다.");
		request.setAttribute("move", "NoticeList");
		
		
		
	}
}
