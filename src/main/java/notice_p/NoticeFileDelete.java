package notice_p;


import dao_p.NoticeDAO;
import dto_p.NoticeDTO;
import etc_p.FileUp;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;


public class NoticeFileDelete implements NoticeService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NoticeDTO dto = new NoticeDTO();
		System.out.println("삭제진입하냐");
		//1. 파일에서 삭제하기
		//System.out.println(request.getParameter("upFile"));
		new FileUp(request).fileDelete(request.getParameter("based_upfile"));		
		
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		
		//2. DB의 img 이름을 null으로 변경
		new NoticeDAO().fileDelete(dto.getNo());
		
		//3. 값을 반납하고 원래 수정폼으로 이동
		request.setAttribute("ModifyData", dto);
		new RedirectionPage(request, response).movePage("삭제되었습니다.",
				"NoticeModifyForm?no=" + dto.getNo());
		
		System.out.println("삭제진입하냐2");
	}

}
