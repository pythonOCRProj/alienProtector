package worker_p;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerJoinReg implements WorkerService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
			WorkerDTO dto = new WorkerDTO();
			
			dto.setId(request.getParameter("id"));
			dto.setPwd(request.getParameter("pwd"));
			
			dto.setEmail(request.getParameter("email"));
			dto.setPhoneNum(request.getParameter("phone_num"));
			dto.setName(request.getParameter("name"));
			dto.setAddr(request.getParameter("addr"));
			dto.setProfileImg(request.getParameter("profile_img"));
			
			int cnt = new WorkerDAO().join(dto);
			//System.out.println("회원가입입니다:"+cnt);
			
			
			new RedirectionPage(request, response).movePage("근무자 등록 완료", "/alienProtector/worker/WorkerList");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
