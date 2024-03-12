package worker_p;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerJoinComple implements WorkerService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WorkerDTO dto = new WorkerDTO();
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setProfileImg(request.getParameter("profile_img"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhoneNum(request.getParameter("phone_num"));
		dto.setName(request.getParameter("name"));
		dto.setAddr(request.getParameter("addr"));

		new WorkerDAO().join(dto);
		
		int cnt = new WorkerDAO().join(dto);
		System.out.println("회원가입입니다:"+cnt);
				
		request.setAttribute("incUrl", "components/alert.jsp");
		request.setAttribute("msg","근무자 등록 완료");
		request.setAttribute("goUrl", "WorkerList");
		
	}
}
