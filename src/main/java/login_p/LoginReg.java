package login_p;

import java.util.Date;

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
		dto.setAttendTime(new Date());
		System.out.println("Attend "+dto.getAttendTimeStr());
		WorkerDTO res = new WorkerDAO().loginChk(dto);

		System.out.println("로그인reg");

		if(res==null) {
			request.setAttribute("msg", "아이디, 비밀번호 확인해주세요");
			request.setAttribute("move", "/alienProtector/login/Login");
			request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
		}else {

			//로그인과 동시에 출근 등록
			if(new WorkerDAO().attend(dto) != 0) {
				if(res.getId() == "master") {
					request.setAttribute("msg", "관리자 로그인 성공");
					request.setAttribute("move", "/alienProtector/dashboard");
					request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
					res.setAttendTime(dto.getAttendTime());
					request.getSession().setAttribute("Worker", res);
				}else {
					request.setAttribute("msg", "출근하였습니다. 오늘도 좋은 하루 되세요!");
					request.setAttribute("move", "/alienProtector/patrol/PatrolWrite");
					request.setAttribute("incUrl", "/view/components/moveUrl.jsp");
					res.setAttendTime(dto.getAttendTime());
					request.getSession().setAttribute("Worker", res);
				}

			}
		}

	}

}
