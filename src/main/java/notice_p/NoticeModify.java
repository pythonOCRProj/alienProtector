package notice_p;

import dao_p.NoticeDAO;
import dao_p.WorkerDAO;
import dto_p.NoticeDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;

public class NoticeModify implements NoticeService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//유효성
		try {
			WorkerDTO dto = (WorkerDTO) request.getSession().getAttribute("Worker");
			if (!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			} else {
				WorkerDTO res = new WorkerDTO();
				res.setId(request.getParameter("id"));
				res = new WorkerDAO().getWorkerInfo(res);
				request.setAttribute("dto", res);
			}
		} catch (NullPointerException e) {
			System.out.println("Exception (WorkerModify) - dto 값 없음");
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");
			
		}

		//본내용
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDTO dto = new NoticeDAO().detail(no);
		request.setAttribute("ModifyData", dto);

	}
}
