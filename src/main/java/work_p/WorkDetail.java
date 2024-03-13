package work_p;

import dao_p.WorkDAO;
import dto_p.PatrolDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkService;

public class WorkDetail implements WorkService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WorkDetail");
		int no = Integer.parseInt(request.getParameter("no"));
		PatrolDTO dto = new WorkDAO().workDetail(no);
		
		request.setAttribute("workDetail", dto);
	}

}
