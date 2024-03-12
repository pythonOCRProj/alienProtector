package worker_p;

import java.util.ArrayList;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerList implements WorkerService {
	
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("근무자명단");
			ArrayList<WorkerDTO> data = new WorkerDAO().list();
			request.setAttribute("mainData", data);
				
		}
	
}
