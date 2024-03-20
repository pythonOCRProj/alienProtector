package worker_p;

import java.io.File;
import java.io.IOException;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import etc_p.ProfileUpload;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service_p.WorkerService;

public class WorkerModifyReg implements WorkerService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
				//파라미터 값으로 유저정보 다 가져오기
				WorkerDTO worker = new WorkerDTO();
				worker.setId(request.getParameter("id"));
				worker =  new WorkerDAO().getWorkerInfo(worker);
				String beforeImg = worker.getProfileImg();
				
				String email = request.getParameter("email");
				String pwd = request.getParameter("pwd");
				String chk = request.getParameter("pwdChk");
				String phone = request.getParameter("phone");
				
				try {
					
					
					//비밀번호 유효성 검사
					if(!"".equals(pwd) && pwd != null && pwd.equals(chk)) {
						worker.setPwd(pwd);
					}else if(!pwd.equals(chk)) {
						request.setAttribute("dto", worker);
						new RedirectionPage(request, response).movePage("비밀번호와 비밀번호 확인이 맞지 않습니다.", "/alienProtector/worker/WorkerModify?id="+worker.getId());
						return;
					}
					
					
					//휴대폰 번호 유효성 검사
					String phoneRegex = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
					System.out.println("휴대폰 번호 : "+phone+"\t 정규식 : "+ phone.matches(phoneRegex));
					boolean phoneChk = (!"".equals(phone) && phone != null && phone.matches(phoneRegex));
					if(phoneChk) {
						worker.setPhoneNum(phone);
					}else if(!"".equals(phone) || phone != null || !phone.matches(phoneRegex)) {
						request.setAttribute("dto", worker);
						new RedirectionPage(request, response).movePage("휴대폰 번호 양식을 확인하세요. ex) 010-0000-0000", "/alienProtector/worker/WorkerModify?id="+worker.getId());
						return;
					}
					
				
					// 업로드 프로필 유효성 검사
					Part profile = request.getPart("profile");
					String profileName = new ProfileUpload(request).fileUpload(profile);
					String dir = "C:\\woong\\workspace\\alienProtector\\src\\main\\webapp\\profile\\";
					if(profileName != null) {						
						boolean profileRegex = profileName.toLowerCase().matches(".*\\.(jpg|jpeg|png|gif|bmp)$");
						
						if(profileName != null && profileRegex) {
							worker.setProfileImg(profileName);
						}else if (!profileRegex) {
							request.setAttribute("dto", worker);
							new RedirectionPage(request, response).movePage("파일 확장자를 확인하세요. ex) xxx.jpg ", "/alienProtector/worker/WorkerModify?id="+worker.getId());
							new File(dir+profileName).delete();
							return;
						}
					}
					
					//이메일 유효성 검사
					String emailReg = "^[a-zA-Z0-9]{3,}@[a-zA-Z0-9.-]{2,}\\.[a-zA-Z]{2,}$";
					if(!email.matches(emailReg)) {
						new RedirectionPage(request, response).movePage("이메일 양식이 맞지 않습니다.", "/alienProtector/worker/WorkerModify?id="+worker.getId());
						return;
					}
					worker.setEmail(email);
					
					int isUpdated = new WorkerDAO().updateWorker(worker);
					WorkerDTO res = new WorkerDAO().getWorkerInfo(worker);
					request.setAttribute("dto", res);
					
					if(isUpdated == 0) {
						new RedirectionPage(request, response).movePage("근무자 정보 수정 실패, 양식을 확인하세요.", "/alienProtector/worker/WorkerModify?id="+worker.getId());
						return;
					}
					new File(dir+beforeImg).delete();
					new RedirectionPage(request, response).movePage("근무자 정보 수정 완료", "/alienProtector/worker/WorkerModify?id="+worker.getId());
					
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					e.printStackTrace();
				}
				
				
			}
		}catch (NullPointerException e) {
			
			e.printStackTrace();
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}
		
		
	}
	
}
