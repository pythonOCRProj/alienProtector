package work_p;

import java.util.ArrayList;
import java.util.Arrays;

import dao_p.WorkDAO;
import dto_p.PatrolDTO;
import dto_p.PlaceDTO;
import dto_p.WorkerDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkService;

public class WorkList implements WorkService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WorkList");
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
