package worker_p;

import java.io.IOException;

import dao_p.WorkerDAO;
import dto_p.NoticeDTO;
import dto_p.WorkerDTO;
import etc_p.FileUp;
import etc_p.ProfileUpload;
import etc_p.RedirectionPage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service_p.WorkerService;

public class WorkerJoinFormReg implements WorkerService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			WorkerDTO dto = (WorkerDTO)request.getSession().getAttribute("Worker");
			if(!dto.getId().equals("master")) {
				new RedirectionPage(request, response).goMain("관리자 권한이 없습니다.");
			}else {
		
				WorkerDTO worker = new WorkerDTO();
			
				//String upFileName;
		
				try {
					
					String pwdchk = request.getParameter("pwdchk");
					
					String addr1 = request.getParameter("addr1");
					String addr2 = request.getParameter("addr2");
					String addr3 = request.getParameter("addr3");
					String addr4 = request.getParameter("addr4");
					System.out.println(addr1);
					System.out.println(addr2);
					System.out.println(addr3);
					System.out.println(addr4);
					String addr =  addr2 + addr3 + addr4;
						
					//비밀번호 유효성 검사
					// 비밀번호가 공백이아니거나 눌값이아니거나 비밀번호와 비밀번호확인이다르거나 
					if(request.getParameter("pwd").equals("") || request.getParameter("pwd")==null || !(request.getParameter("pwd").equals(pwdchk)) ) {
						new RedirectionPage(request, response).movePage("비밀번호를 확인해주세요.","WorkerJoinForm");
					
					} else if(request.getParameter("name").equals("") || request.getParameter("name")==null) {
						new RedirectionPage(request, response).movePage("이름을 확인해주세요.","WorkerJoinForm");
					} else {
						//upFileName = new FileUp(request).fileUpload(request.getPart("upfile"));
						System.out.println(request.getParameter("pwd"));
						//id
						worker.setId(request.getParameter("id"));
						worker.setPwd(request.getParameter("pwd"));
						//email
						worker.setEmail(request.getParameter("email"));
						//phone_num
						worker.setPhoneNum(request.getParameter("phone_num"));
						//name
						worker.setName(request.getParameter("name"));
						//addr
						worker.setAddr(addr);
						
						new WorkerDAO().join(worker);
						new RedirectionPage(request, response).movePage("근무자 등록 완료", "WorkerList");		
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}catch (NullPointerException e) {
			e.printStackTrace();
			new RedirectionPage(request, response).goMain("다시 로그인 해주세요.");;
		}	
		
			
	}
}
