package notice_p;

import java.io.IOException;

import dao_p.NoticeDAO;
import dao_p.WorkerDAO;
import dto_p.NoticeDTO;
import dto_p.WorkerDTO;
import etc_p.FileUp;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModifyReg implements NoticeService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			
			WorkerDTO dto2 = (WorkerDTO) request.getSession().getAttribute("Worker");
			if (!dto2.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			} else {

				try {
					
					System.out.println("노티스모디파이레그진입");
					NoticeDTO dto = new NoticeDTO();
					String basedFile = null;
					if(request.getParameter("based_upfile") != null) {
						basedFile = request.getParameter("based_upfile");
						dto.setImg(basedFile);

					}
					dto.setNo(Integer.parseInt(request.getParameter("no")));
					WorkerDTO login = (WorkerDTO) request.getSession().getAttribute("Worker");

					if (request.getParameter("title").equals("") || request.getParameter("content").equals("")) {
						new RedirectionPage(request, response).movePage("제목과 내용은 필수입력사항입니다.",
								"NoticeModify?no=" + dto.getNo());
					} else {
						if (request.getPart("upfile") != null && basedFile == null ) {							
							basedFile = new FileUp(request).fileUpload(request.getPart("upfile"));
							dto.setImg(basedFile);
						}
						dto.setNo(Integer.parseInt(request.getParameter("no")));
						dto.setTitle(request.getParameter("title"));
						dto.setContent(request.getParameter("content"));
						dto.setId(login.getId());

						new NoticeDAO().noticeModify(dto);
						request.setAttribute("ModifyData", dto);

						// new RedirectionPage(request, response).movePage("수정되었습니다.", "NoticeList");
						new RedirectionPage(request, response).movePage("수정되었습니다.", "NoticeDetail?no=" + dto.getNo());

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (NullPointerException e) {

			e.printStackTrace();
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");
			;
		}

	}
}