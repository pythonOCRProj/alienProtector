package worker_p;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerModify implements WorkerService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
		if(dto.getId() != "master") {
			request.setAttribute("msg", "관리자 권한이 없습니다.");
			request.setAttribute("move", "/alienProtector/");
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		}else {
			WorkerDTO res = new WorkerDAO().getWorkerInfo(dto);
			request.setAttribute("dto", res);
		}
		
	}
	
}
