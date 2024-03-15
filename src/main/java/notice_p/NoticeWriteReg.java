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

public class NoticeWriteReg implements NoticeService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// System.out.println("NoticeWriteReg 자바 진입");

		try {
			WorkerDTO dto2 = (WorkerDTO) request.getSession().getAttribute("Worker");
			if (!dto2.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			} else {

				NoticeDTO dto = new NoticeDTO();

				String upFileName;

				try {
					if (request.getParameter("title").equals("") || request.getParameter("content").equals("")) {
						new RedirectionPage(request, response).movePage("제목과 내용은 필수입력사항입니다.", "NoticeList");
					} else {
						upFileName = new FileUp(request).fileUpload(request.getPart("upfile"));

						dto.setTitle(request.getParameter("title"));
						dto.setContent(request.getParameter("content"));
						dto.setImg(upFileName);

						new NoticeDAO().write(dto);
						int no = new NoticeDAO().newNo();
						new RedirectionPage(request, response).movePage("작성되었습니다", "NoticeList");
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
			
		}

	}
}
