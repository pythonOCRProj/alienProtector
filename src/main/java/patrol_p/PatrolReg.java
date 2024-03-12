package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import dao_p.PatrolDAO;
import dto_p.PatrolDTO;
import dto_p.WorkerDTO;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import service_p.PatrolService;

public class PatrolReg implements PatrolService {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
			String file = new FileUpload(request).uploadFile(request.getPart("photo"));
			PatrolOcr pyOcr = new PatrolOcr();
			String pos = pyOcr.ocr(file,request);
			
			PatrolDTO dto = new PatrolDTO();
			HttpSession session = request.getSession();
			WorkerDTO res = (WorkerDTO)session.getAttribute("Worker");
			Date now = new Date();
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
			
			if(pyOcr.date == smf.format(now)) {
				dto.setPosition(pos);
				dto.setPhoto(file);
				dto.setId(res.getId());
				dto.setSpecial(request.getParameter("special"));
				dto.setDate(pyOcr.date);
				dto.setTime(pyOcr.time);
				
				
				new PatrolDAO().write(dto);
				
				
				request.setAttribute("incUrl", "components/alert.jsp");
				request.setAttribute("msg", pos+" 등록이 되었습니다.");
				request.setAttribute("goUrl", "/alienProtector/patrol/PatrolWrite");
			}else {
				request.setAttribute("incUrl", "components/alert.jsp");
				request.setAttribute("msg", "올바른 날짜가 아닙니다.");
				request.setAttribute("goUrl", "/alienProtector/patrol/PatrolWrite");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}


}
