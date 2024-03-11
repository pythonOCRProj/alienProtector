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
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.PatrolService;

public class PatrolReg implements PatrolService {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
			String file = new FileUpload(request).uploadFile(request.getPart("photo"));
			PatrolOcr pyOcr = new PatrolOcr();
			String pos = pyOcr.ocr(file,request);
			
			PatrolDTO dto = new PatrolDTO();
			dto.setPosition(pos);
			dto.setPhoto(file);
			dto.setId("김명주");
			dto.setSpecial(request.getParameter("special"));
			dto.setDate(pyOcr.date);
			
			System.out.println(pyOcr.date);
			
			dto.setTime(pyOcr.time);
			
			System.out.println(pyOcr.time);
			
			
			new PatrolDAO().write(dto);
			
			
			request.setAttribute("incUrl", "components/alert.jsp");
			request.setAttribute("goUrl", "/alienProtector/patrol/PatrolWrite");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}


}
