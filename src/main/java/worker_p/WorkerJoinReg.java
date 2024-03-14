package worker_p;

import java.io.IOException;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.WorkerService;

public class WorkerJoinReg implements WorkerService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
			WorkerDTO worker = new WorkerDTO();
			
			worker.setId(request.getParameter("id"));
			
			worker = new WorkerDAO().getWorkerInfo(worker);
			
			String pwd = request.getParameter("pwd");
			String pwdchk = request.getParameter("pwdchk");
			String phone_num = request.getParameter("phone_num");
			
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String addr3 = request.getParameter("addr3");
			String addr4 = request.getParameter("addr4");
			
			dto.setPwd(request.getParameter("pwd"));
			dto.setEmail(request.getParameter("email"));
			dto.setPhoneNum(request.getParameter("phone_num"));
			dto.setName(request.getParameter("name"));
			dto.setAddr(request.getParameter("addr"));
			dto.setProfileImg(request.getParameter("profile_img"));
			
			try {
			
				//각종 유효성 검사들
				if(!"".equals(pwd) && pwd != null && pwd.equals(pwdchk)) {
					worker.setPwd(pwd);
				} else(!pwd.equals(pwdchk)) {
					
				} 
				
			
				int cnt = new WorkerDAO().join(dto);
				
				new RedirectionPage(request, response).movePage("근무자 등록 완료", "/alienProtector/worker/WorkerList");
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
