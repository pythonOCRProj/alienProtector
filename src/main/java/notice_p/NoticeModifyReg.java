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
		NoticeDTO dto = new NoticeDTO();
		
	
			//String upFileName = new FileUp(request).fileUpload(request.getPart("upFile"));
			
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			//dto.setNo(Integer.parseInt(request.getParameter("no")));
			//dto.setImg(upFileName);//파일 이름 뽑기
			System.out.println(dto.getContent());
			
			new NoticeDAO().noticeModify(dto);
		
			request.setAttribute("ModifyData", dto);
			request.setAttribute("incUrl", "components/moveUrl.jsp");
			request.setAttribute("msg", "수정되었습니다.");
			request.setAttribute("move", "NoticeList");
			
			System.out.println("노티스 모디파이 레그 진입ㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅ");
			
			System.out.println("notice modifyReg 자바 진입");
	
		
	}
}