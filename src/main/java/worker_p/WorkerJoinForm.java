package worker_p;

import java.util.ArrayList;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerJoinForm implements WorkerService{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
		
			
							
			}
		}catch (NullPointerException e) {
			e.printStackTrace();
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
		
		
	}
}
