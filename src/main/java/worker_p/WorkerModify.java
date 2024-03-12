package worker_p;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerModify implements WorkerService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
				WorkerDTO res = new WorkerDAO().getWorkerInfo(dto);
				request.setAttribute("dto", res);
			}
		}catch (NullPointerException e) {
			System.out.println("Exception (WorkerModify) - dto 값 없음");
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
		
		
	}
	
}
