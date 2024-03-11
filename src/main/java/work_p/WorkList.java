package work_p;

import java.util.ArrayList;
import java.util.Arrays;

import dao_p.WorkDAO;
import dto_p.PatrolDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkService;

public class WorkList implements WorkService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<PatrolDTO> dateArr = new WorkDAO().dateList();
		ArrayList<PatrolDTO> workArr = new WorkDAO().workList();
		
		request.setAttribute("dateArr", dateArr);
		request.setAttribute("workArr", workArr);
	}

}
