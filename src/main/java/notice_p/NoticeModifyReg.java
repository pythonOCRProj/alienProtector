package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModifyReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		NoticeDTO dto = new NoticeDTO();
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		new NoticeDAO().noticeModify(dto);
		
		
		request.setAttribute("ModifyData", dto);
		request.setAttribute("msg", "수정이 완료되었습니다.");
		request.setAttribute("move", "NoticeList");
		request.setAttribute("incUrl", "components/moveUrl.jsp");
		
		
		
	}
}