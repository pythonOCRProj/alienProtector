package work_p;

import java.util.ArrayList;
import java.util.Arrays;

import dao_p.WorkDAO;
import dao_p.WorkerDAO;
import dto_p.PatrolDTO;
import dto_p.PlaceDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkService;

public class WorkList implements WorkService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WorkList");
		
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
				WorkerDTO res = new WorkerDTO();
				res.setId(request.getParameter("id"));
				res = new WorkerDAO().getWorkerInfo(res);
				request.setAttribute("dto", res);
			}
		}catch (NullPointerException e) {
			System.out.println("Exception (WorkerModify) - dto 값 없음");
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
		
		ArrayList<PatrolDTO> dateArr = new WorkDAO().dateList();
		request.setAttribute("dateArr", dateArr);
		ArrayList<WorkerDTO> workerList = new WorkDAO().workerList();
		request.setAttribute("workerList", workerList);
		ArrayList<PlaceDTO> placeList = new WorkDAO().placeList();
		request.setAttribute("placeList", placeList);
		
		ArrayList<PatrolDTO> workData = new WorkDAO().workData();
		request.setAttribute("workData", workData);
	}

}
