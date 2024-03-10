package login_p;

import dao_p.WorkerDAO;
import dto_p.WorkerDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.LoginService;

public class LoginReg implements LoginService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		WorkerDTO dto = new WorkerDTO();
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		WorkerDTO res = new WorkerDAO().loginChk(dto);
		
		if(res==null) {
			request.setAttribute("msg", "아이디, 비밀번호 확인해주세요");
			request.setAttribute("move", "/alienProtector/login/Login");
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		}else {
			if(res.getId() == "master") {
				request.setAttribute("msg", "관리자 로그인 성공");
				request.setAttribute("move", "/alienProtector/dashboard");
				request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
				request.getSession().setAttribute("Worker", res);
			}else {
				
				request.setAttribute("msg", "출근");
				request.setAttribute("move", "/alienProtector/dashboard");
				request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
				request.getSession().setAttribute("Worker", res);
			}
		}

	}

}
