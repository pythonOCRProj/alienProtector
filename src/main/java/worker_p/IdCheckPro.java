package worker_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class IdCheckPro implements WorkerService{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("중복체크");
		
	}
}
