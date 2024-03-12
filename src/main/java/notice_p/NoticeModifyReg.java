package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModifyReg implements NoticeService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		NoticeDTO dto = new NoticeDTO();
		
		String upFileName;
		try {
			
			
			upFileName = new FileUp(request).fileUpload(request.getPart("upfile"));
			
			
			dto.setNo(Integer.parseInt(request.getParameter("no")));
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setImg(upFileName);
			
			
			new NoticeDAO().noticeModify(dto);

			
			request.setAttribute("ModifyData", dto);
			
			new RedirectionPage(request, response).movePage("수정되었습니다.", "NoticeList");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}