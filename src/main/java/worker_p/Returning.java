package worker_p;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class Returning implements WorkerService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String returning = request.getParameter("s");
		String id = request.getParameter("id");
		int selected = returning.equals("퇴사") ? 0 : 1;
		WorkerDTO worker = new WorkerDTO();
		
		if("".equals(id) || id == null || !(new WorkerDAO().checkHiredWorker(id))) {
			new RedirectionPage(request, response).goMain("존재하지 않는 근무자 입니다. "+returning+" 불가합니다.");
			return;
		}
		
		worker.setId(id);
		worker.setHire(selected);
		
		if(new WorkerDAO().updateReturning(worker) != 0) {
			worker = new WorkerDAO().getWorkerInfo(worker);
			request.setAttribute("dto", worker);
			new RedirectionPage(request, response).movePage(returning+" 처리 하였습니다.", "/alienProtector/worker/WorkerModify?id="+worker.getId());
		}
		
		
	}
	
}
