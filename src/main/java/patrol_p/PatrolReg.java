package patrol_p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import dao_p.PatrolDAO;
import dto_p.PatrolDTO;
import dto_p.WorkerDTO;
import etc_p.RedirectionPage;
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
			String nowDate = smf.format(now);
			
//			int no = new PatrolDAO().count();
//			String lastStr = new PatrolDAO().search(no);
//			
//			
//			SimpleDateFormat smf2 = new SimpleDateFormat("HH:mm:ss");
//		    Calendar last = Calendar.getInstance();
//		    Calendar up = Calendar.getInstance();
//		    
//		    last.setTime(smf2.parse(lastStr));
//		    up.setTime(smf2.parse(pyOcr.time));
//		    
//		    //마지막 찍은 사진 시간 +10
//		    last.add(Calendar.SECOND, 10);
//		    
//		    //현재 올린 사진의 시간이 마지막 찍은 사진의 시간에서 10초 지났는지 판별
//		    int compare = (smf2.format(up.getTime())).compareTo(smf2.format(last.getTime())); 
		 
		 
			if(pyOcr.date == null || !pyOcr.date.equals(nowDate) || pyOcr.time == null){
				new RedirectionPage(request, response).goMain("올바른 날짜가 아닙니다.");
		
			}else if(pyOcr.date.equals(nowDate) && pos != null && pyOcr.time != null) {
				int no = new PatrolDAO().count();
				String lastStr = new PatrolDAO().search(no);
				
				
				SimpleDateFormat smf2 = new SimpleDateFormat("HH:mm:ss");
			    Calendar last = Calendar.getInstance();
			    Calendar up = Calendar.getInstance();
			    
			    last.setTime(smf2.parse(lastStr));
			    up.setTime(smf2.parse(pyOcr.time));
			    
			    //마지막 찍은 사진 시간 +10
			    last.add(Calendar.SECOND, 10);
			    
			    //현재 올린 사진의 시간이 마지막 찍은 사진의 시간에서 10초 지났는지 판별
			    int compare = (smf2.format(up.getTime())).compareTo(smf2.format(last.getTime())); 
				if(compare > 0) {
				
					String [] sh = pyOcr.time.split(":");
					int hour = Integer.parseInt(sh[0]);
					
					String shift = "";
					if(hour>=23 || (0<=hour && 7>hour)) {
						shift = "야간";
					}else if(hour>=7 && hour <15) {
						shift = "주간";
					}else if(hour>=15 && hour<23) {
						shift = "오후";
					}
					
					
					dto.setPosition(pos);
					dto.setPhoto(file);
					dto.setId(res.getId());
					dto.setSpecial(request.getParameter("special"));
					dto.setDate(pyOcr.date);
					dto.setTime(pyOcr.time);
					dto.setShift(shift);
					
					
					new PatrolDAO().write(dto);
					
					new RedirectionPage(request, response).goMain( pos+" 등록이 되었습니다.");
				}else {
						new RedirectionPage(request, response).goMain("올바른 시간이 아닙니다.");
				}
			}else if(pos == null) {
		    	new RedirectionPage(request, response).goMain("올바른 이미지가 아닙니다.");
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}


}
